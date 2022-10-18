package task2;

import java.util.Scanner;

public class Main {


    static String human_read_format(int bytes) {
        String result = "";
        String[] arrayName = new String[]{"B", "KB", "MB", "GB", "TB", "PB"};
        int counter = 1;

        while (true) {

            int integer_part = (bytes / ((int) Math.pow(1024, counter)));

            if (integer_part < 1) {
                int remainder_part = (bytes % ((int) Math.pow(1024, counter)));
                result = Integer.toString(integer_part) + "." + Integer.toString(remainder_part) + " " + arrayName[counter - 1];
                break;
            }

            counter++;

            if (counter > 6) {
                result = "Too much value (max=PB)";
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Input bytes: ");
        int bytes = in.nextInt();

        System.out.println("Result: " + human_read_format(bytes));

    }
}
