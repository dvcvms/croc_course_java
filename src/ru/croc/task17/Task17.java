package ru.croc.task17;

import ru.croc.task17.tables.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class Task17 {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/croc";

    private static final String USERNAME = "max";
    private static final String PASSWORD = "java";


    private static final String PATH = "C:\\Users\\Admin\\IdeaProjects\\croc_course_java\\src\\ru\\croc\\task17\\data\\orders.csv";

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)){

            TableCreator.newCreateTable(connection);
            TableCreator.insertTables(connection, PATH);
        }

    }
}
