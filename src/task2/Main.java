package task2;

import java.util.Scanner;

public class Main {

    static String human_read_format(long bytes) {

        if (bytes < 0) {
            return "Incorrect value (input bytes < 0)!";
        }

        String result = "";
        String[] arrayName = new String[]{"B", "KB", "MB", "GB", "TB", "PB"};
        long border = 1;

        for (int i = 0; i < 6; i++) {

            if (bytes < border * 1024) {

                double new_value = bytes / (double) border;

                result = String.format("%.1f", new_value) + " " + arrayName[i];

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

        System.out.println("Result: " + human_read_format(bytes));

    }
}
