package ru.croc.task18.exception;

import ru.croc.task18.tables.Product;

public class IllegalProductIsPresentException extends Exception {

    private final Product product;

    public IllegalProductIsPresentException(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Product with " + product.getArticle() + " article is already exist.";
    }
}
