package ru.croc.task15;

import java.io.*;

public class Task15 {

    private final static String FILE_PATH = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task15/data";

    public static void main(String[] args) throws IOException {

        Graph graph = new Graph();
        graph.buildTree(FILE_PATH);
//        System.out.println(graph.getRoot().calculateTime());
        System.out.println(graph.getResult());
    }
}
