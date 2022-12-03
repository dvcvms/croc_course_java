package ru.croc.task13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataReader {

    private final Map<Integer, String> movieNumberHashMap = new HashMap<>();
    private final List<Set<Integer>> listOfUserMoves = new ArrayList<>();

    private final Map<Integer, Integer> numberOfEachFilmsHashMap = new HashMap<>();

    public DataReader(String pathMovies, String pathViews) throws IOException {
        readListOfFilms(pathMovies);
        readUserMovies(pathViews);
    }

    public Map<Integer, String> getMovieNumberHashMap() {
        return movieNumberHashMap;
    }

    public List<Set<Integer>> getListOfUserMoves() {
        return listOfUserMoves;
    }

    public Map<Integer, Integer> getNumberOfEachFilmsHashMap() {
        return numberOfEachFilmsHashMap;
    }

    private void readListOfFilms(String path) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = reader.readLine();
            while (line != null) {
                String[] strings = line.split(",");
                movieNumberHashMap.put(Integer.parseInt(strings[0]), strings[1]);
                line = reader.readLine();
            }
        }

    }

    private void readUserMovies(String path) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                String[] strings = line.split(",");

                // Find unique movies for each of the users
                Set<Integer> uniqueFilms = new HashSet<>();

                for (String string : strings) {
                    // Add lost of unique movies
                    uniqueFilms.add(Integer.parseInt(string));

                    // Calculate the total number of specific movies
                    numberOfEachFilmsHashMap.merge(Integer.parseInt(string), 1, Integer::sum);
                }

                listOfUserMoves.add(uniqueFilms);
                line = reader.readLine();
            }
        }

    }

}
