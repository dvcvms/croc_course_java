package ru.croc.task3;

import java.util.Scanner;

public class Task3 {

    public static void fillArray(int[] arr, String str) {
        int j = 0;

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != ' ') {
                buffer.append(str.charAt(i));
            }

            if (str.charAt(i) == ' ') {
                arr[j] = Integer.parseInt(buffer.substring(0));
                buffer.delete(0, buffer.length()); // clear buffer
                j++;
            }
        }
    }

    public static void findMaxMin(int[] arr) {
        int lengthArray = arr.length;

        int maxValue = arr[0], minValue = arr[0];
        int indexMin = 0, indexMax = 0;

        for (int i = 1; i < lengthArray; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                indexMax = i;
            }

            if (arr[i] < minValue) {
                minValue = arr[i];
                indexMin = i;
            }
        }

        changeMaxMin(arr, minValue, maxValue, indexMin, indexMax);
    }

    public static void changeMaxMin(int[] arr, int minValue, int maxValue, int indexMin, int indexMax) {

        int first = arr[0];
        arr[0] = minValue;
        arr[indexMin] = first;

        /* We must check this situation:
         *
         * 4 1 2 3 -> 1 4 2 3
         *
         * Because maxValue changed position then indexMax value must be changed:
         */

        if (arr[indexMin] == maxValue) {
            indexMax = indexMin;
        }

        int last = arr[arr.length - 1];
        arr[arr.length - 1] = maxValue;
        arr[indexMax] = last;
    }

    public static void printArray(int[] arr) {
        int lengthArray = arr.length;

        System.out.print(arr[0]);
        for (int i = 1; i < lengthArray; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static int findLengthArray(String str) {
        int lengthArray = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                lengthArray++;
            }
        }

        return lengthArray;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int lengthArray;
        String str;

        str = in.nextLine();
        str = str + " ";

        lengthArray = findLengthArray(str);

        int[] arr = new int[lengthArray];

        fillArray(arr, str);

        findMaxMin(arr);

        printArray(arr);
    }
}