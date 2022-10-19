package ru.croc.task2;

import java.util.Scanner;

public class Task2 {

    static String humanReadFormat(long bytes) {

        if (bytes < 0) {
            return "Incorrect value (input bytes < 0)!";
        }

        String result = "";
        String[] arrayName = new String[]{"B", "KB", "MB", "GB", "TB", "PB"};
        double border = 1.0;

        for (int i = 0; i < arrayName.length; i++) {

            if (bytes < border * 1024) {

                double newValue = bytes / border;

                result = String.format("%.1f", newValue) + " " + arrayName[i];

                break;
            }
            border = border * 1024;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Input bytes: ");
        long bytes = in.nextLong();

        System.out.println("Result: " + humanReadFormat(bytes));

    }
}
