package ru.croc.task5;

public class Annotation {

    private String label = null;

    public void setLabel(String label) {
        this.label = label;
    }

    protected String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return "";
    }
}