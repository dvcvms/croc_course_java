package ru.croc.task13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataReader {

    private final Map<Integer, String> movieNumberHashMap = new HashMap<>();
    private final List<List<Integer>> listOfUserMoves = new ArrayList<>();

    private final Map<Integer, Integer> numberOfEachFilmsHashMap = new HashMap<>();

    public DataReader(String pathMovies, String pathViews) throws IOException {
        readListOfFilms(pathMovies);
        readUserMovies(pathViews);
    }

    public Map<Integer, String> getMovieNumberHashMap() {
        return this.movieNumberHashMap;
    }

    public List<List<Integer>> getListOfUserMoves() {
        return this.listOfUserMoves;
    }

    public Map<Integer, Integer> getNumberOfEachFilmsHashMap() {
        return this.numberOfEachFilmsHashMap;
    }

    private void readListOfFilms(String path) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(",");
                this.movieNumberHashMap.put(Integer.parseInt(strings[0]), strings[1]);
            }
        }

    }

    private void readUserMovies(String path) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(",");

                // Find unique movies for each of the users
                List<Integer> uniqueFilms = new ArrayList<>();

                for (String string : strings) {
                    // Add lost of unique movies
                    uniqueFilms.add(Integer.parseInt(string));

                    // Calculate the total number of specific movies
                    this.numberOfEachFilmsHashMap.merge(Integer.parseInt(string), 1, Integer::sum);
                }

                this.listOfUserMoves.add(uniqueFilms);
            }
        }

    }

}
