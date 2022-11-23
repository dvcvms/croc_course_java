package ru.croc.task13.tests;

import org.testng.annotations.Test;
import ru.croc.task13.Recommendation;

import java.io.IOException;

public class RecommendationTest {
    @Test
    private void test1() throws IOException {

        String pathMovie = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task13/tests/files/films_first";
        String pathWatch = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task13/tests/files/watch_first";

        Recommendation recommendation = new Recommendation(pathMovie, pathWatch);
        recommendation.readFiles();
        recommendation.getRecommendation();

    }
}
