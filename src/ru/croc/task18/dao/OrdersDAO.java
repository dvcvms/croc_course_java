package ru.croc.task18.dao;

import ru.croc.task18.tables.Order;
import ru.croc.task18.tables.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrdersDAO {
    private final Connection connection;

    private final String queryPattern = "INSERT INTO ORDERS (NUMBER, LOGIN, ARTICLE) VALUES (?,?,?)";

    public OrdersDAO(Connection connection) {
        this.connection = connection;
    }

    public Order createOrder(String userLogin, List<Product> products) throws ClassNotFoundException, SQLException {
        int orderId = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(NUMBER) FROM ORDERS");
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                orderId = result.getInt("MAX(NUMBER)") + 1;
            }
        }

        for (Product product : products) {
            try (PreparedStatement statement = connection.prepareStatement(queryPattern)) {
                statement.setInt(1, orderId);
                statement.setString(2, userLogin);
                statement.setString(3, product.getArticle());
                statement.execute();
            }
        }
        return new Order(orderId, userLogin, products);
    }
}
