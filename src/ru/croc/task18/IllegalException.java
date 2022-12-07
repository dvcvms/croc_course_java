package ru.croc.task18;

import ru.croc.task18.tables.Product;

public class IllegalException extends Exception {
    private Product product;

    public IllegalException(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Mistace! " + product;
    }
}
