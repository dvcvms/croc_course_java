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

    public OrdersDAO(Connection connection) {
        this.connection = connection;
    }

    public Order createOrder(String login, List<Product> products) throws SQLException {
        int number = 0;

        String queryMaxNumber = "SELECT MAX(NUMBER) FROM ORDERS";

        try (PreparedStatement preparedStatement = connection.prepareStatement(queryMaxNumber);
             ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {
                number = result.getInt("MAX(NUMBER)") + 1;
            }
        }

        String queryPattern = "INSERT INTO ORDERS (NUMBER, LOGIN, ARTICLE) VALUES (?,?,?)";

        for (Product product : products) {
            try (PreparedStatement statement = connection.prepareStatement(queryPattern)) {
                statement.setInt(1, number);
                statement.setString(2, login);
                statement.setString(3, product.getArticle());

                statement.execute();
            }
        }
        return new Order(number, login, products);
    }
}
