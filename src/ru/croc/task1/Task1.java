package ru.croc.task1;

import java.util.Scanner;


public class Task1 {

    static class Point {
        double x;
        double y;
    }

    static double square(Point a, Point b, Point c) {
        double l1 = Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
        double l2 = Math.sqrt(Math.pow((c.x - a.x), 2) + Math.pow((c.y - a.y), 2));
        double l3 = Math.sqrt(Math.pow((b.x - c.x), 2) + Math.pow((b.y - c.y), 2));

        if (l1 * l2 * l3 == 0.0)
            return -100;

        double p = (l1 + l2 + l3) / 2;
        double s = Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));

        return s;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Point a = new Point();
        Point b = new Point();
        Point c = new Point();

        double s;

        System.out.print("Введите координату х вершины №1: ");
        a.x = in.nextDouble();
        System.out.print("Введите координату y вершины №1: ");
        a.y = in.nextDouble();

        System.out.print("Введите координату х вершины №2: ");
        b.x = in.nextDouble();
        System.out.print("Введите координату y вершины №2: ");
        b.y = in.nextDouble();

        System.out.print("Введите координату х вершины №3: ");
        c.x = in.nextDouble();
        System.out.print("Введите координату y вершины №3: ");
        c.y = in.nextDouble();

        s = square(a, b, c);

        if (s == -100){
            System.out.println("Координаты вершин заданы некорректно!");
        }
        else {
            System.out.println("Площадь равна: " + String.format("%.1f", square(a, b, c)));
        }

        // System.out.format("%.1f", Square(a, b, c) + "Площадь равна");
    }
}
