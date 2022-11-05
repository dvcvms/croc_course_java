package ru.croc.task6;

public class Task6 {
    public static void main(String[] args) {


        Figure a = new Circle(1, 1, 1);
        Figure main;
        main = a;
        main.checkPointInArea(1, 1);


//        Annotation circle = new Circle(1, 2, 3);
//        Annotation rectangle = new Rectangle(0, 0, 1, 1);
//
//        Annotation annotation = new Annotation();
//        circle.setLabel("circle2");
//        rectangle.setLabel("rectangle2");
//
//        circle.move(1,1);
//        rectangle.move(1,1);
//        System.out.println(circle);
//        System.out.println(rectangle);
//
//        AnnotatedImage annotatedImage = new AnnotatedImage("path", rectangle);
//        annotatedImage.findByPoint(1, 1);
    }
}
