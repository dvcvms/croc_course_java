package ru.croc.task15;

import java.io.*;

public class Task15 {

    private final static String FILE_PATH = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task15/data";

    public static int calculateTime(Node root) {
        int result = 0;

        for (Node node : root.getChildren()) {
            result = Math.max(result, calculateTime(node));
        }

        return result + root.getTime();
    }

    public static void main(String[] args) throws IOException {

        File file = new File(FILE_PATH);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        Graph graph = new Graph();

        String line;
        String[] strings;

        while ((line = reader.readLine()) != null) {
            strings = line.split(",");
            graph.addNode(strings[0], strings[1], Integer.parseInt(strings[2]));
        }

        System.out.println(calculateTime(graph.getRoot()));
    }
}
