package ru.croc.task18.tables;

import java.util.List;
import java.util.Objects;

public class Order {

    private static int id = 1;
    private int number;
    private final String login;
    private String article;

    public String getArticle() {
        return article;
    }

    private List<Product> articles;

    @Override
    public String toString() {
        return "id = " + id + " number = " + number + " login = " + login + " article = " + article;
    }

    public Order(String number, String login, String article) {
        this.number = Integer.parseInt(number);
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

    public Order(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public static void incrementId() {
        id++;
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
}
