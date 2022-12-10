package ru.croc.task18;

import ru.croc.task18.dao.OrdersDAO;
import ru.croc.task18.dao.ProductsDAO;
import ru.croc.task18.exception.IllegalProductIsPresentException;
import ru.croc.task18.tables.Product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

            ProductsDAO productsDAO = new ProductsDAO(connection);
            System.out.println(productsDAO.findProduct("Т1"));

            System.out.println(productsDAO.createProduct(new Product("Т6", "Car", 10000)));
//            System.out.println(productsDAO.createProduct(new Product("Т3", "Table", 780)));

            System.out.println(productsDAO.updateProduct(new Product("Т2", "Pen", 20)));

            productsDAO.deleteProduct("Т4");
            System.out.println(productsDAO.findProduct("Т4"));


            OrdersDAO ordersDAO = new OrdersDAO(connection);

            List<Product> productList = new ArrayList<>();
            productList.add(productsDAO.findProduct("Т6"));
            productList.add(productsDAO.findProduct("Т5"));
            productList.add(productsDAO.findProduct("Т3"));

            System.out.println(ordersDAO.createOrder("petya", productList));

        }

    }
}
