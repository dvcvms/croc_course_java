package ru.croc.task8;


import java.io.*;

public class Task8 {

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
        StringBuilder text = null;
        File file = null;

        int result = -1;

        try {
            filePath = args[0];

            file = new File(filePath);

            file.createNewFile();

        } catch (ArrayIndexOutOfBoundsException | NullPointerException | IOException e) {
            e.printStackTrace();
        }


        try (InputStream in = new FileInputStream(file)) {

            text = new StringBuilder();

            int b;
            while ((b = in.read()) != -1) {
                text.append((char) b);
            }

        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // check: filePath not null, text has been successfully read
        if (filePath != null && text != null && file != null)
            result = calculateCountWords(text.toString());

        if (result != -1)
            System.out.println(result);

    }
}
