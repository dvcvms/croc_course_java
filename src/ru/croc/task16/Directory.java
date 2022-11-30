package ru.croc.task16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Directory {

    private static Path rootPath;
    private static final List<Log> logs = new ArrayList<>();

    public Directory(String rootPath) {
        Directory.rootPath = Path.of(rootPath);
    }

    public List<Log> readLogs() throws IOException {

        for (File file : Directory.getListFiles()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                String[] strings;
                while ((line = reader.readLine()) != null) {
                    strings = line.split(" ");
                    Log log = new Log(Long.parseLong(strings[0]), strings[1]);
                    logs.add(log);
                }
            }
        }

        return logs;
    }

    private static List<File> getListFiles() throws IOException {
        return Files.walk(rootPath)
                    .filter(Files::isRegularFile)
                    .filter(Directory::isFileLogType)
                    .map(Path::toFile)
                    .toList();
    }

    private static boolean isFileLogType(Path path) {
        String fileName = path.getFileName().toString();

        return fileName.endsWith(".log") || fileName.endsWith(".trace");
    }
}
