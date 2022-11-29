package ru.croc.task6;

public class Task6 {
    public static void main(String[] args) {

        Figure circle = new Circle(1, 2, 3);
        Figure rectangle = new Rectangle(0, 0, 1, 1);

        Annotation annotation = new Annotation("circle_figure", circle);

        System.out.println(circle);
        System.out.println(rectangle);

        circle.move(1,1);
        rectangle.move(1,1);

        System.out.println(circle);
        System.out.println(rectangle);

        AnnotatedImage annotatedImage = new AnnotatedImage("path", annotation);

        System.out.println(annotatedImage.findByLabel("circle"));
    }
}
