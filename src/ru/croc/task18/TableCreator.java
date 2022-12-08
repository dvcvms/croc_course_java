package ru.croc.task18;

import ru.croc.task18.tables.Order;
import ru.croc.task18.tables.Product;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static void fillTablesWithData(Connection connection, String pathToCSV) throws SQLException, IOException {

        String queryProduct = "INSERT INTO PRODUCTS (ARTICLE, NAME, PRICE) VALUES (?,?,?)";
        String queryOrder = "INSERT INTO ORDERS (NUMBER, LOGIN, ARTICLE) VALUES (?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(queryProduct);
             PreparedStatement statement2 = connection.prepareStatement(queryOrder))
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(pathToCSV))) {

                String line;
                while ((line = reader.readLine()) != null) {

                    Product product = Product.parse(line);
                    Order order = Order.parse(line);

                    if (!productTypes.contains(product)) {
                        insertProduct(statement, product);
                        productTypes.add(product);

                        statement.executeUpdate();
                    }
                    insertOrder(statement2, order);

                    statement2.executeUpdate();
                }
            }
        }
    }

    private static void insertProduct(PreparedStatement st1, Product product) throws SQLException {
        st1.setString(1, product.getArticle());
        st1.setString(2, product.getName());
        st1.setInt(3, product.getPrice());
    }

    private static void insertOrder(PreparedStatement st2, Order order) throws SQLException {
        st2.setInt(1, order.getNumber());
        st2.setString(2, order.getLogin());
        st2.setString(3, order.getArticle());
    }
}