package ru.croc.task17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;

public class Task17 {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/croc";

    private static final String USERNAME = "max";
    private static final String PASSWORD = "java";

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            TableCreator.createTables(connection);
            TableCreator.fillTablesWithData(connection, args[0]);
        }

    }
}
