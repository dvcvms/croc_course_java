package ru.croc.task5;

public class Task5 {
    public static void main(String[] args) {

        Figure circle = new Circle(1, 2, 3);
        Figure rectangle = new Rectangle(0, 0, 1, 1);

        circle.setSignature("circle");
        rectangle.setSignature("rectangle");

        System.out.println(circle);
        System.out.println(rectangle);
    }
}
