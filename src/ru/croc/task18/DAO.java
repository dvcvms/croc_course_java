package ru.croc.task18;

import ru.croc.task18.tables.Order;
import ru.croc.task18.tables.Product;

import java.sql.*;
import java.util.List;

public class DAO {

    private final Connection connection;
    private final String queryPattern = "INSERT INTO ORDERS (NUMBER, LOGIN, ARTICLE) VALUES (?,?,?)";

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public Product findProduct(String productCode) throws SQLException {

        Product product = new Product();

        String query = "SELECT * FROM PRODUCTS WHERE ARTICLE = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, productCode);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    product.setArticle(result.getString("ARTICLE"));
                    product.setName(result.getString("NAME"));
                    product.setPrice(result.getInt("PRICE"));
                    return product;
                }
            }
        }
        return null;
    }

    public Product createProduct(Product product) throws SQLException, IllegalProductMissingException {

        if (findProduct(product.getArticle()) != null) {
            throw new IllegalProductMissingException(product);
        } else {
            String query = "INSERT INTO PRODUCTS (ARTICLE, NAME, PRICE) VALUES (?,?,?)";
//            String query = "INSERT INTO PRODUCTS " + "(ARTICLE, NAME, PRICE) VALUES" +
//                    "('" + product.getArticle() + "', '" + product.getName() + "', " + product.getPrice() + ");";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, product.getArticle());
                statement.setString(2, product.getName());
                statement.setInt(3, product.getPrice());

                statement.executeUpdate(query);
            }

            return product;
        }
    }

    public Product updateProduct(Product product) throws SQLException {

/*        if (findProduct(product.getArticle()) == null) {
            System.out.println("Данного товара не существует");
            return null;
        }*/

        String sql =
                String.format("UPDATE PRODUCTS SET NAME = ?, PRICE = ? WHERE ID = '%s'", product.getArticle());

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.executeUpdate();
            return product;
        }
    }

    public void deleteProduct(String productCode) throws SQLException {

        String SQL_ORDER = "DELETE " + "\"" + "ORDERS" + "\"" +
                " WHERE ARTICLE = '" + productCode + "';";
        try (Statement statement = connection.createStatement()) {
            statement.execute(SQL_ORDER);
        }
        String SQL_ITEM = "DELETE " + Product.class.getSimpleName() +
                " WHERE ID = '" + productCode + "';";
        try (Statement statement = connection.createStatement()) {
            statement.execute(SQL_ITEM);
        }
    }

    public Order createOrder(String userLogin, List<Product> products) throws ClassNotFoundException, SQLException {
        int orderId = 0;

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT MAX(NUMBER) FROM ORDERS")) {
            try (ResultSet result = preparedStatement.executeQuery()) {
                while (result.next()) {
                    orderId = result.getInt("MAX(NUMBER)") + 1;
                }
            }
        }

        for (Product product : products) {
            try (PreparedStatement statement = connection.prepareStatement(queryPattern)) {
                statement.setInt(1, orderId);
                statement.setString(2, userLogin);
                statement.setString(3, product.getArticle());
                statement.execute();
            }
        }
        return new Order(orderId, userLogin, products);
    }


}
