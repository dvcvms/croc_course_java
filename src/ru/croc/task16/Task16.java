package ru.croc.task16;

import java.io.*;

public class Task16 {

    public static void main(String[] args) throws IOException {

        Directory directory = new Directory(args[0]);
        directory.processLogs();

    }
}
