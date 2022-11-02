package ru.croc.task5;

public class Circle extends Figure {
    private int r;
    private int x0, y0;

    public Circle(int x0, int y0, int r) {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    @Override
    public String toString() {
        return "C (" + this.x0 + ", " + this.y0 + "), " + this.r + ": " + getSignature();
    }
}
