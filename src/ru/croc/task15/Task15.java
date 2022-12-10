package ru.croc.task15;

import java.io.*;

public class Task15 {

    private final static String FILE_PATH = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task15/data";

    public static void main(String[] args) throws IOException {

        Graph graph = new Graph(FILE_PATH);
        graph.buildTree();
        System.out.println(graph.getResult());

    }
}
