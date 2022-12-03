package ru.croc.task13;

import java.io.IOException;
import java.util.Scanner;

public class Task13 {

    private static final String FILE_MOVIES = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task13/files/movies";
    private static final String FILE_VIEWS = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task13/files/views";

    public static void main(String[] args) throws IOException {

        Recommendation recommendation = new Recommendation(FILE_MOVIES, FILE_VIEWS);

        Scanner in = new Scanner(System.in);

        System.out.println(recommendation.getRecommendation(in.nextLine()));

    }
}
