package ru.croc.task6;

public class Annotation {

    private String label;
    private Figure figure;

    public Annotation(String label, Figure figure) {
        this.label = label;
        this.figure = figure;
    }

    public String getLabel() {
        return label;
    }

    public Figure getFigure() {
        return this.figure;
    }

    @Override
    public String toString() {
        return figure.toString() + this.label;
    }

}
