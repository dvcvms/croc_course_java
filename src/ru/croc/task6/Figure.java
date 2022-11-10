package ru.croc.task6;

public abstract class Figure implements Movable {

    public abstract boolean checkPointInArea(int x, int y);

    public abstract void move(int dx, int dy);
}
