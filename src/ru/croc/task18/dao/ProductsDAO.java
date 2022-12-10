package ru.croc.task18.dao;

import ru.croc.task18.tables.Product;
import ru.croc.task18.exception.IllegalProductIsPresentException;

import java.sql.*;

public class ProductsDAO {

    private final Connection connection;

    public ProductsDAO(Connection connection) {
        this.connection = connection;
    }

    public Product findProduct(String productCode) throws SQLException {

        String query = "SELECT * FROM PRODUCTS WHERE ARTICLE = ?;";

        try (PreparedStatement pStatement = connection.prepareStatement(query)) {
            pStatement.setString(1, productCode);

            try (ResultSet result = pStatement.executeQuery()) {

                Product product = new Product();

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

    public Product createProduct(Product product) throws SQLException, IllegalProductIsPresentException {

        if (findProduct(product.getArticle()) != null) {
            throw new IllegalProductIsPresentException(product);
        }

        String query = "INSERT INTO PRODUCTS (ARTICLE, NAME, PRICE) VALUES (?,?,?);";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, product.getArticle());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getPrice());

            statement.executeUpdate();
        }

        return product;
    }

    public Product updateProduct(Product product) throws SQLException {

        String query = "UPDATE PRODUCTS SET NAME = ?, PRICE = ? WHERE ARTICLE = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setString(3, product.getArticle());

            statement.executeUpdate();
        }

        return product;
    }

    public void deleteProduct(String productCode) throws SQLException {

        String queryProducts = "DELETE PRODUCTS WHERE ARTICLE = ?;";
        String queryOrders = "DELETE ORDERS WHERE ARTICLE = ?;";

        try (PreparedStatement pstmtProducts = connection.prepareStatement(queryProducts);
             PreparedStatement pstmtOrders = connection.prepareStatement(queryOrders)) {

            pstmtProducts.setString(1, productCode);
            pstmtOrders.setString(1, productCode);

            pstmtProducts.executeUpdate();
            pstmtOrders.executeUpdate();
        }
    }
}
