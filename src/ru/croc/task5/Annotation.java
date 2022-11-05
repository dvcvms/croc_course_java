package ru.croc.task5;

public class Annotation {
    private String label;
    private Figure figure;

    public Annotation(String label, Figure figure) {
        this.label = label;
        this.figure = figure;
    }

    @Override
    public String toString() {
        return figure.toString() + this.label;
    }
}
