package ru.croc.task18.tables;

import java.util.Objects;

public class Product {

    private String article;
    private String name;
    private int price;

    public Product() {

    }

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

    public void setArticle(String article) {
        this.article = article;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Product{" +
                "article='" + article + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static Product parse(String line) {
        String[] args = line.split(",");
        return new Product(args[2], args[3], Integer.parseInt(args[4].replaceAll(" ", "")));
    }
}
