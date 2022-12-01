package ru.croc.task16;

import java.io.*;
import java.util.List;

public class Task16 {

    public static void main(String[] args) throws IOException {

        Directory directory = new Directory(args[0]);
        directory.readLogs();

        List<Log> logs = directory.getResult();
        logs.sort(new LogComparator());

        for (Log log : logs) {
            System.out.println(log.toString());
        }

    }
}
