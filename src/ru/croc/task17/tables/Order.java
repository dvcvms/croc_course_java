package ru.croc.task17.tables;

import java.util.Objects;

public class Order {

    private final int number;
    private final String login;
    private String article;

    public Order(int number, String login, String article) {
        this.number = number;
        this.login = login;
        this.article = article;
    }

    public int getNumber() {
        return number;
    }

    public String getLogin() {
        return login;
    }

    public String getArticle() {
        return article;
    }

    public static Order parse(String line) {
        String[] args = line.split(",");
        return new Order(Integer.parseInt(args[0]), args[1], args[2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return login.equals(order.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
