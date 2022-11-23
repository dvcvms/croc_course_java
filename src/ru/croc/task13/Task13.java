package ru.croc.task13;

import java.io.IOException;

public class Task13 {

    public static void main(String[] args) throws IOException {

        Recommendation recommendation = new Recommendation();
        recommendation.readFiles();
        recommendation.getRecommendation();

    }
}
