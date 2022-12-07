package ru.croc.task18;

import ru.croc.task18.tables.Product;

public class IllegalProductMissingException extends Exception {

    private final Product product;

    public IllegalProductMissingException(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Product with " + product.getArticle() + " article is not exist.";
    }
}
