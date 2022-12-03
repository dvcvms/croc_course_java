package ru.croc.task13;

import java.io.*;
import java.util.*;

public class Recommendation {

    private final DataReader dataReader;

    public Recommendation(String pathMovies, String pathViews) throws IOException {
        this.dataReader = new DataReader(pathMovies, pathViews);
    }

    public String getRecommendation(String userMovies) {
        Set<Integer> inputMovies = new HashSet<>();

        String[] strings = userMovies.split(",");
        for (String string : strings) {
            inputMovies.add(Integer.parseInt(string));
        }

        return calculateRecommend(inputMovies);
    }

    private String calculateRecommend(Set<Integer> inputMovies) {
        Set<Integer> setOfMoviesNotWatched = new HashSet<>();

        for (Set<Integer> userMovies : dataReader.getListOfUserMoves()) {

            Set<Integer> notWatchedMovies = new HashSet<>(userMovies);
            notWatchedMovies.removeAll(inputMovies);

            // Find the fraction of movies not watched in %
            double fraction = (double) notWatchedMovies.size() / inputMovies.size() * 100;

            // watched more than 50 % is not watched less than 50 %
            if (fraction <= 50) {
                setOfMoviesNotWatched.addAll(notWatchedMovies);
            }
        }

        int movieNumber = -1;
        int maxCountOfViews = -1;
        for (int movieNumberNotWatched : setOfMoviesNotWatched) {
            int t = this.dataReader.getNumberOfEachFilmsHashMap().get(movieNumberNotWatched);
            if (t >= maxCountOfViews) {
                maxCountOfViews = t;
                movieNumber = movieNumberNotWatched;
            }
        }

        if (movieNumber == -1) {
            return "Among users there aren't movies that we can recommend you";
        } else {
            return "Recommendation: " + this.dataReader.getMovieNumberHashMap().get(movieNumber);
        }
    }


}
