package ru.croc.task14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Recommendation {

    private static final String FILE_MOVIES = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task13/files/movies";
    private static final String FILE_VIEWS = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task13/files/views";

    private final Map<Integer, String> movieNumberHashMap = new HashMap<>();
    private final List<Set<Integer>> listOfUserMoves = new ArrayList<>();

    private final Map<Integer, Integer> numberOfEachFilmsHashMap = new HashMap<>();


    public Recommendation() throws IOException {
        readListOfFilms(FILE_MOVIES);
        readUserMovies(FILE_VIEWS);
    }

    public void getRecommendation() {
        Set<Integer> inputMovies = new HashSet<>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String[] strings = line.split(",");
        for (String string : strings) {
            inputMovies.add(Integer.parseInt(string));
        }

        calculateRecommend(inputMovies);
    }

    private void calculateRecommend(Set<Integer> inputMovies) {
        Set<Integer> setOfMoviesNotWatched = new HashSet<>();

        for (Set<Integer> userMoves : listOfUserMoves) {

            Set<Integer> notWatchedMovies = new HashSet<>(userMoves);
            notWatchedMovies.removeAll(inputMovies);

            // Find the fraction of movies not watched in %
            double fraction = (double) notWatchedMovies.size() / userMoves.size() * 100;

            // watched more than 50 % is not watched less than 50 %
            if (fraction <= 50) {
                setOfMoviesNotWatched.addAll(notWatchedMovies);
            }
        }

        int movieNumber = -1;
        int maxCountOfViews = -1;
        for (int movieNumberNotWatched : setOfMoviesNotWatched) {
            int t = this.numberOfEachFilmsHashMap.get(movieNumberNotWatched);
            if (t >= maxCountOfViews) {
                maxCountOfViews = t;
                movieNumber = movieNumberNotWatched;
            }
        }

        if (movieNumber == -1) {
            System.out.println("Among users there aren't movies that we can recommend you");
        } else {
            System.out.println("Recommendation: " + this.movieNumberHashMap.get(movieNumber));
        }
    }

    private void readListOfFilms(String path) throws IOException {

        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();
        while (line != null) {
            String[] strings = line.split(",");
            movieNumberHashMap.put(Integer.parseInt(strings[0]), strings[1]);
            line = reader.readLine();
        }

    }

    private void readUserMovies(String path) throws IOException {

        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();
        while (line != null) {
            String[] strings = line.split(",");

            // Find unique movies for each of the users
            Set<Integer> uniqueFilms = new HashSet<>();

            for (String string : strings) {
                // Add lost of unique movies
                uniqueFilms.add(Integer.parseInt(string));

                // Calculate the total number of specific movies
                numberOfEachFilmsHashMap.merge(Integer.parseInt(string), 1, (a, b) -> (a + b));
            }

            listOfUserMoves.add(uniqueFilms);
            line = reader.readLine();
        }
    }
}
