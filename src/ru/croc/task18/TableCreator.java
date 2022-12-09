package ru.croc.task18;

import ru.croc.task18.tables.Product;
import ru.croc.task18.tables.Order;

import java.io.*;
import java.sql.*;
import java.util.Set;
import java.util.HashSet;

public class TableCreator {

    private static final Set<Product> productTypes = new HashSet<>();
    private static final Set<Order> orderTypes = new HashSet<>();

    private static final int BATCH_SIZE = 25;

    public static void createTables(Connection connection) throws SQLException {

        try (Statement statement = connection.createStatement()) {

            String products;
            String orders;

            String closeProducts = "DROP TABLE IF EXISTS PRODUCTS;";
            String closeUsers = "DROP TABLE IF EXISTS ORDERS;";

            statement.executeUpdate(closeProducts);
            statement.executeUpdate(closeUsers);

            products = "CREATE TABLE PRODUCTS(ARTICLE VARCHAR(255), NAME VARCHAR(255), PRICE INTEGER, PRIMARY KEY (ARTICLE))";

            orders = "CREATE TABLE ORDERS(NUMBER INT, LOGIN VARCHAR(255), ARTICLE VARCHAR(255));";

            statement.executeUpdate(products);
            statement.executeUpdate(orders);
        }
    }

    public static void fillTablesWithData(Connection connection, String pathToCSV) throws SQLException, IOException {

        String queryProductPattern = "INSERT INTO PRODUCTS(ARTICLE, NAME, PRICE) VALUES (?,?,?)";

        String queryOrderPattern = "INSERT INTO ORDERS(NUMBER, LOGIN, ARTICLE) VALUES (?,?,?)";

        connection.setAutoCommit(false);
        try (PreparedStatement pstmtProduct = connection.prepareStatement(queryProductPattern);
             PreparedStatement pstmtOrder = connection.prepareStatement(queryOrderPattern);
             BufferedReader reader = new BufferedReader(new FileReader(pathToCSV))) {

            int counter = 1;
            String line;
            while ((line = reader.readLine()) != null) {

                Product product = Product.parse(line);
                Order order = Order.parse(line);

                if (!productTypes.contains(product)) {
                    insertProduct(pstmtProduct, product);
                    productTypes.add(product);
                    pstmtProduct.addBatch();
                }

                // TODO: нужно ли исключать дублирование, это ведь история покупок?
                if (!orderTypes.contains(order)) {
                    insertOrder(pstmtOrder, order);
                    orderTypes.add(order);
                    pstmtOrder.addBatch();
                }

                if (counter % BATCH_SIZE == 0) {
                    pstmtProduct.executeBatch();
                    pstmtOrder.executeBatch();
                    counter = 1;
                }
                counter++;
            }

            pstmtProduct.executeBatch();
            pstmtOrder.executeBatch();

            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new SQLException(); // TODO: правильно ли так? уточнить в лекции
            }
        }
        connection.setAutoCommit(true);
    }

    private static void insertProduct(PreparedStatement pstmt, Product product) throws SQLException {
        pstmt.setString(1, product.getArticle());
        pstmt.setString(2, product.getName());
        pstmt.setInt(3, product.getPrice());
    }

    private static void insertOrder(PreparedStatement pstmt, Order order) throws SQLException {
        pstmt.setInt(1, order.getNumber());
        pstmt.setString(2, order.getLogin());
        pstmt.setString(3, order.getArticle());
    }
}
