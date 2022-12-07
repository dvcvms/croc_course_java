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

    private static Set<Product> setPr = new HashSet<>();

    public static void newCreateTable(Connection connectionNew) throws SQLException {
        try (Statement statementNew = connectionNew.createStatement()) {

            String products;
            String users;
            String test;

            String closeProducts = "DROP TABLE IF EXISTS PRODUCT;";
            String closeUsers = "DROP TABLE IF EXISTS ORDERS;";

            statementNew.executeUpdate(closeProducts);
            statementNew.executeUpdate(closeUsers);

            products = "CREATE TABLE IF NOT EXISTS PRODUCT " +
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

    public static void insertTables(Connection con, String pathToCSV) throws SQLException, IOException {
         try (BufferedReader reader = new BufferedReader(new FileReader(pathToCSV))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                Product t1 = new Product(values[2], values[3], Integer.parseInt(values[4]));
                Order t2 = new Order(Integer.parseInt(values[0]), values[1], values[2]);

                if (!setPr.contains(t1)){
                    insert(con, t1);
                    setPr.add(t1);
                }
                insertUsers(con, t2);
            }
        }

    }

    private static void insert(Connection con, Product product) throws SQLException {
        try (Statement statementNew = con.createStatement()) {
            String sql;
            sql = "INSERT INTO PRODUCT " + " VALUES( '" + product.getArticle() + "', '" + product.getName() + "',  " + product.getPrice() + ")";
            statementNew.executeUpdate(sql);
        }
    }

    private static void insertUsers(Connection con, Order order) throws SQLException {
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
