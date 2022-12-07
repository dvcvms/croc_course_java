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

    private static final Set<Product> setPr = new HashSet<>();

    public static void createTables(Connection connectionNew) throws SQLException {
        try (Statement statementNew = connectionNew.createStatement()) {

            String products;
            String users;

            String closeProducts = "DROP TABLE IF EXISTS PRODUCTS;";
            String closeUsers = "DROP TABLE IF EXISTS ORDERS;";

            statementNew.executeUpdate(closeProducts);
            statementNew.executeUpdate(closeUsers);

            products = "CREATE TABLE IF NOT EXISTS PRODUCTS " +
                    "(ID VARCHAR(255) not NULL, " +
                    " NAME VARCHAR(255) not NULL, " +
                    " PRICE INTEGER not NULL, " +
                    " PRIMARY KEY ( ID ))";

            statementNew.executeUpdate(products);

            users = "CREATE TABLE \"ORDERS\"" +
                    "(NUMBER INT, " +
                    "LOGIN VARCHAR(255), " +
                    "ARTICLE VARCHAR(255));";

            statementNew.executeUpdate(users);
        }
    }

    public static void fillTablesWithData(Connection con, String pathToCSV) throws SQLException, IOException {
         try (BufferedReader reader = new BufferedReader(new FileReader(pathToCSV))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                Product t1 = new Product(values[2], values[3], Integer.parseInt(values[4]));
                Order t2 = new Order(Integer.parseInt(values[0]), values[1], values[2]);

                if (!setPr.contains(t1)){
                    insertProduct(con, t1);
                    setPr.add(t1);
                }
                insertOrder(con, t2);
            }
        }

    }

    private static void insertProduct(Connection con, Product product) throws SQLException {
        try (Statement statementNew = con.createStatement()) {
            String sql;
            sql = "INSERT INTO PRODUCTS " + " VALUES( '" + product.getArticle() + "', '" + product.getName() + "',  " + product.getPrice() + ")";
            statementNew.executeUpdate(sql);
        }
    }

    private static void insertOrder(Connection con, Order order) throws SQLException {
        try (Statement statementNew = con.createStatement()) {
            String sql;
            sql = "INSERT INTO ORDERS " + " VALUES( "
                    + order.getNumber() + ", '"
                    + order.getLogin() + "', '"
                    + order.getArticle() + "')";

            statementNew.executeUpdate(sql);
        }
    }
}
