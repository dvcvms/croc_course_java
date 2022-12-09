package ru.croc.task18;

import ru.croc.task18.dao.ProductsDAO;
import ru.croc.task18.exception.IllegalProductIsPresentException;
import ru.croc.task18.tables.Product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task18 {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/croc";

    private static final String USERNAME = "max";
    private static final String PASSWORD = "java";


    private static final String PATH = "C:\\Users\\Admin\\IdeaProjects\\croc_course_java\\src\\ru\\croc\\task18\\data\\orders.csv";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, IllegalProductIsPresentException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            TableCreator.createTables(connection);
            TableCreator.fillTablesWithData(connection, PATH);

            ProductsDAO dao = new ProductsDAO(connection);
            System.out.println(dao.findProduct("Т1"));

            System.out.println(dao.createProduct(new Product("Т6", "Car", 10000)));
//            System.out.println(dao.createProduct(new Product("Т3", "Table", 780)));

            System.out.println(dao.updateProduct(new Product("Т2", "Pen", 20)));

            dao.deleteProduct("Т4");
            System.out.println(dao.findProduct("Т4"));

 /*           List<Product> productList = new ArrayList<>();
            productList.add(dao.findProduct("Т6"));
            System.out.println(dao.createOrder("petya", productList));*/

        }

    }
}
