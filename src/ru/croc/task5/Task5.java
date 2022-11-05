package ru.croc.task5;

public class Task5 {
    public static void main(String[] args) {

        Figure obj = new Circle(1, 2, 3);
        Annotation annotation = new Annotation("test", obj);

        Figure obj1 = new Rectangle(4, 5, 6, 7);
        Annotation annotation1 = new Annotation("test1", obj1);

        System.out.println(annotation);
        System.out.println(annotation1);

    }
}
