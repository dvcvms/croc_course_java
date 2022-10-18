package task1;

import java.util.Scanner;


public class Main {

    static class Point {
        double x;
        double y;
    }

    static double Square(Point a, Point b, Point c) {
        double l1 = Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
        double l2 = Math.sqrt(Math.pow((c.x - a.x), 2) + Math.pow((c.y - a.y), 2));
        double l3 = Math.sqrt(Math.pow((b.x - c.x), 2) + Math.pow((b.y - c.y), 2));

        double p = (l1 + l2 + l3) / 2;
        double s = Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));

        return s;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Point a = new Point();
        Point b = new Point();
        Point c = new Point();

        System.out.print("Введите координату х вершины №1: ");
        a.x = in.nextInt();
        System.out.print("Введите координату y вершины №1: ");
        a.y = in.nextInt();

        System.out.print("Введите координату х вершины №2: ");
        b.x = in.nextInt();
        System.out.print("Введите координату y вершины №2: ");
        b.y = in.nextInt();

        System.out.print("Введите координату х вершины №3: ");
        c.x = in.nextInt();
        System.out.print("Введите координату y вершины №3: ");
        c.y = in.nextInt();

        System.out.println("Площадь равна: " + String.format("%.1f", Square(a, b, c)));
        // System.out.format("%.1f", Square(a, b, c) + "Площадь равна");
    }
}
