package ru.croc.task6;

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
        return "C (" + this.x0 + ", " + this.y0 + "), " + this.r + ": ";
    }

    public boolean checkPointInArea(int x, int y) {
        return Math.pow(x - this.x0, 2) + Math.pow(y - this.y0, 2) <= r * r;
    }


    @Override
    public void move(int dx, int dy) {
        this.x0 += dx;
        this.y0 += dy;
    }
}
