package ru.croc.task17;

import ru.croc.task17.tables.Product;
import ru.croc.task17.tables.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class TableCreator {

    private static int counter = 0;
    private static Set<Product> setPr = new HashSet<>();
    private static Set<User> setUs = new HashSet<>();


    public static void newCreateTable(Connection connectionNew) throws SQLException {
        try (Statement statementNew = connectionNew.createStatement()) {

            String products;
            String users;
            String test;

            String closeProducts = "DROP TABLE IF EXISTS PRODUCT;";
            String closeUsers = "DROP TABLE IF EXISTS USERS;";

            statementNew.executeUpdate(closeProducts);
            statementNew.executeUpdate(closeUsers);

            products = "CREATE TABLE IF NOT EXISTS PRODUCT " +
                    "(ID VARCHAR(255) not NULL, " +
                    " NAME VARCHAR(255) not NULL, " +
                    " PRICE INTEGER not NULL, " +
                    " PRIMARY KEY ( ID ))";

            statementNew.executeUpdate(products);

            users = "CREATE TABLE IF NOT EXISTS Users("
                    + "ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                    + "LOGIN VARCHAR(20) "
                    + ")";

            statementNew.executeUpdate(users);
        }
    }

    public static void insertTables(Connection con, String pathToCSV) throws SQLException, IOException {
         try (BufferedReader reader = new BufferedReader(new FileReader(pathToCSV))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                Product t1 = new Product(values[2], values[3], values[4]);
                User t2 = new User(values[1]);

                if (!setPr.contains(t1)){
                    insert(con, t1);
                    setPr.add(t1);
                }
                if (!setUs.contains(t2)) {
                    insertUsers(con, t2);
                    setUs.add(t2);
                    User.incrementId();
                }
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

    private static void insertUsers(Connection con, User user) throws SQLException {
        try (Statement statementNew = con.createStatement()) {
            String sql;
            sql = "INSERT INTO USERS " + " VALUES( "
                    + user.getId() + ", '"
                    + user.getLogin() + "' ) ";

            statementNew.executeUpdate(sql);
        }
        counter++;
    }
}
