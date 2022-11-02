package ru.croc.task5;

public class Task5 {
    public static void main(String[] args) {

        Annotation circle = new Circle(1, 2, 3);
        Annotation rectangle = new Rectangle(0, 0, 1, 1);

        circle.setLabel("circle");
        rectangle.setLabel("rectangle");

        System.out.println(circle);
        System.out.println(rectangle);
    }
}
