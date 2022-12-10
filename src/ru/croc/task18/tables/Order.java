package ru.croc.task18.tables;

import java.util.List;
import java.util.Objects;

public class Order {

    private final int number;
    private final String login;
    private String article;

    private List<Product> articles;

    public Order(int number, String login, String article) {
        this.number = number;
        this.login = login;
        this.article = article;
    }

    public Order(int number, String login, List<Product> articles) {
        this.number = number;
        this.login = login;
        this.articles = articles;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order user = (Order) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", login='" + login + '\'' +
                ", article='" + article + '\'' +
                ", articles=" + articles +
                '}';
    }

    public static Order parse(String line) {
        String[] args = line.split(",");
        return new Order(Integer.parseInt(args[0].replaceAll(" ", "")), args[1], args[2]);
    }
}
