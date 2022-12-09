package ru.croc.task17.tables;

import java.util.Objects;

public class Product {

    private String article;
    private String name;
    private int price;

    public Product(String article, String name, int price) {
        this.article = article;
        this.name = name;
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static Product parse(String line) {
        String[] args = line.split(",");
        return new Product(args[2], args[3], Integer.parseInt(args[4]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && article.equals(product.article) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, name, price);
    }
}
