package ru.croc.task16;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;

public class Directory {

    private final Path rootPath;
    private final Queue<FileComponent> filesQueue = new PriorityQueue<>(new LogComparator());

    public Directory(String rootPath) throws IOException {
        this.rootPath = Path.of(rootPath);

        for (File file : getListFiles()) {
            filesQueue.add(new FileComponent(file));
        }
    }

    /**
     * Method reads logs from all files gradually in increasing order of time logs.
     * This is provided by priority queue.
     */
    public void processLogs() throws IOException {
        while (filesQueue.size() != 0) {
            FileComponent file = filesQueue.poll();

            System.out.println(file.getLogLine());

            if (file.readNextLine() == null) {
                file.getReader().close();
            } else {
                filesQueue.add(file);
            }
        }
    }

    /**
     * Method that search for all required files in the specified directory.
     *
     * @return The result of searching is list of file paths with ".log" and ".trace" extension.
     */
    private List<File> getListFiles() throws IOException {
        return Files.walk(rootPath)
                .filter(Files::isRegularFile)
                .filter(this::isFileLogType)
                .map(Path::toFile)
                .toList();
    }

    /**
     * Method that checks the file extension for a valid one.
     *
     * @param path This is file path.
     * @return The result of checking for extension ".log" and ".trace".
     */
    private boolean isFileLogType(Path path) {
        String fileName = path.getFileName().toString();

        return fileName.toLowerCase().endsWith(".log") || fileName.toLowerCase().endsWith(".trace");
    }
}
