package ru.croc.task13;

import java.io.*;
import java.util.*;

public class Recommendation {

    private final String FILE_MOVIE = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task13/files/films";
    private final String FILE_WATCH = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task13/files/watch";

    private String specifiedFilePathMovie = null;
    private String specifiedFilePathWatch = null;

    private final Map<Integer, String> movieNumberHashMap = new HashMap<>();
    private final List<Set<Integer>> listOfUserMoves = new ArrayList<>();

    private final Map<Integer, Integer> numberOfEachFilmsHashMap = new HashMap<>();


    public Recommendation() {
        // system-defined file paths are used
    }

    public Recommendation(String pathMovie, String pathWatch) {
        if (pathMovie != null) {
            specifiedFilePathMovie = pathMovie;
        }
        if (pathMovie != null) {
            specifiedFilePathWatch = pathWatch;
        }
    }

    public void readFiles() throws IOException {
        readListOfFilms(specifiedFilePathMovie == null ? FILE_MOVIE : specifiedFilePathMovie);
        readUserMovies(specifiedFilePathWatch == null ? FILE_WATCH : specifiedFilePathWatch);
    }

    public void getRecommendation() {
        Set<Integer> inputFilms = new HashSet<>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String[] strings = line.split(",");
        for (String string : strings) {
            inputFilms.add(Integer.parseInt(string));
        }

        calculateRecommend(inputFilms);
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

            // Find unique films for each of the users
            Set<Integer> uniqueFilms = new HashSet<>();

            for (String string : strings) {
                // Add lost of unique films
                uniqueFilms.add(Integer.parseInt(string));

                // Calculate the total number of specific films
                numberOfEachFilmsHashMap.merge(Integer.parseInt(string), 1, (a, b) -> (a + b));
            }

            listOfUserMoves.add(uniqueFilms);
            line = reader.readLine();
        }
    }

/*    private void demonstration() {
        for (int i = 0; i < movieNumberHashMap.size(); i++) {
            System.out.println(movieNumberHashMap.get(i + 1));
        }
        for (int i = 0; i < listOfUserMoves.size(); i++) {
            System.out.println(listOfUserMoves.get(i));
        }
    }*/

    private void calculateRecommend(Set<Integer> inputFilms) {
        Set<Integer> setOfMoviesNotWatched = new HashSet<>();

        for (Set<Integer> userMoves : listOfUserMoves) {

            Set<Integer> notWatchedMovies = new HashSet<>(userMoves);
            notWatchedMovies.removeAll(inputFilms);

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
//            System.out.println(this.map.get(movieNumberNotWatched));
            int t = this.numberOfEachFilmsHashMap.get(movieNumberNotWatched);
            if (t >= maxCountOfViews) {
                maxCountOfViews = t;
                movieNumber = movieNumberNotWatched;
            }
        }
        System.out.println("Recommendation: " + this.movieNumberHashMap.get(movieNumber));
    }
}
