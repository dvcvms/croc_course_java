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

    private final Queue<FileComponent> fileComponents = new PriorityQueue<>(new LogComparator());

    public Directory(String rootPath) throws IOException {
        this.rootPath = Path.of(rootPath);

        for (File file : getListFiles()) {
            fileComponents.add(new FileComponent(file)); // TODO: add parse method?
        }
    }

    public void readLogs() throws IOException { // TODO: rename
        while (fileComponents.size() != 0) {
            FileComponent fileComponent = fileComponents.poll();

            System.out.println(fileComponent.getLogLine());

            if (fileComponent.readNextLine() == null) {
                fileComponent.getReader().close();
            } else {
                fileComponents.add(fileComponent);
            }
        }
    }

    private List<File> getListFiles() throws IOException {
        return Files.walk(rootPath)
                .filter(Files::isRegularFile)
                .filter(this::isFileLogType)
                .map(Path::toFile)
                .toList();
    }

    private boolean isFileLogType(Path path) {
        String fileName = path.getFileName().toString();

        return fileName.toLowerCase().endsWith(".log") || fileName.toLowerCase().endsWith(".trace");
    }
}
