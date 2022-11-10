package ru.croc.task8;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;


public class Task8 {

    public static String readFile(String filePath) throws IOException {

        File file = new File(filePath);

        StringBuilder text = new StringBuilder();

        file.createNewFile();

        InputStream in = new FileInputStream(file);

        int b;
        while ((b = in.read()) != -1) {
            text.append((char) b);
        }

        in.close();

        return text.toString();
    }

    public static int calculateCountWords(String text) {
        int result = 0;

        String[] strings = text.split("[^a-zA-Z]+");

        for (String s : strings) {
            if (s.length() != 0)
                result++;
        }

        return result;
    }

    public static void main(String[] args) {

        String filePath = null;

        try {
            filePath = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        if (filePath != null)
            try {
                String text = readFile(filePath);

                System.out.println(calculateCountWords(text));

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
