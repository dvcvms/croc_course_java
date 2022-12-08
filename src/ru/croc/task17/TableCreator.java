package ru.croc.task17;

import ru.croc.task17.tables.Product;
import ru.croc.task17.tables.Order;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class TableCreator {

    private static final Set<Product> productTypes = new HashSet<>();

    public static void createTables(Connection connection) throws SQLException {

        try (Statement statement = connection.createStatement()) {

            String products;
            String users;

            String closeProducts = "DROP TABLE IF EXISTS PRODUCTS;"; // TODO: Check logic
            String closeUsers = "DROP TABLE IF EXISTS ORDERS;"; // TODO: too

            statement.executeUpdate(closeProducts);
            statement.executeUpdate(closeUsers);

            products = "CREATE TABLE IF NOT EXISTS PRODUCTS " +
                    "(ARTICLE VARCHAR(255) not NULL, " +
                    " NAME VARCHAR(255) not NULL, " +
                    " PRICE INTEGER not NULL, " +
                    " PRIMARY KEY ( ARTICLE ))";

            statement.executeUpdate(products);

            users = "CREATE TABLE \"ORDERS\"" +
                    "(NUMBER INT, " +
                    "LOGIN VARCHAR(255), " +
                    "ARTICLE VARCHAR(255));";

            statement.executeUpdate(users);
        }
    }

    // TODO: Добавить предварительный запрос, чтобы каждый раз не обращаться к бд, а сразу кинуть всю инфу
    public static void fillTablesWithData(Connection connection, String pathToCSV) throws SQLException, IOException {

         try (BufferedReader reader = new BufferedReader(new FileReader(pathToCSV))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] args = line.split(",");

                Product product = Product.parse(line);
                Order order = Order.parse(line);

                if (!productTypes.contains(product)){
                    insertProduct(connection, product);
                    productTypes.add(product);
                }
                insertOrder(connection, order);
            }

        }
    }

    private static void insertProduct(Connection connection, Product product) throws SQLException { // TODO: add pattern sql
        try (Statement statement = connection.createStatement()) {
            String sql;
            sql = "INSERT INTO PRODUCTS " + " VALUES( '" + product.getArticle() + "', '" + product.getName() + "',  " + product.getPrice() + ")";
            statement.executeUpdate(sql);
        }
    }

    private static void insertOrder(Connection connection, Order order) throws SQLException { // TODO: add pattern sql
        try (Statement statement = connection.createStatement()) {
            String sql;
            sql = "INSERT INTO ORDERS " + " VALUES( "
                    + order.getNumber() + ", '"
                    + order.getLogin() + "', '"
                    + order.getArticle() + "')";

            statement.executeUpdate(sql);
        }
    }
}
