package ru.croc.task6;

public class Annotation implements Movable {

    private String label = "";

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

    public boolean comparePoints(int x, int y) {
        return false;
    }

    @Override
    public void move(int dx, int dy) {

    }
}
