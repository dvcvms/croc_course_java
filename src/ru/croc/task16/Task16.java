package ru.croc.task16;

import java.io.*;
import java.util.List;

public class Task16 {

    private final static String FILE_PATH = "C:/Users/Admin/IdeaProjects/croc_course_java/src/ru/croc/task16/logs";

    public static void main(String[] args) throws IOException {

        Directory directory = new Directory(FILE_PATH);

        List<Log> logs = directory.readLogs();
        logs.sort(new LogComparator());

        for (Log log : logs) {
            System.out.println(log.toString());
        }
    }
}
