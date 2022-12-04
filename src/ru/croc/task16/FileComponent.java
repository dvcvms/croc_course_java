package ru.croc.task16;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileComponent {

    private final BufferedReader reader;
    private String logLine;
    private long logTime;

    public FileComponent(File file) throws IOException {
        this.reader = new BufferedReader(new FileReader(file));
        readNextLine();
    }

    public BufferedReader getReader() {
        return reader;
    }

    public String getLogLine() {
        return logLine;
    }

    public long getLogTime() {
        return logTime;
    }

    public String readNextLine() throws IOException {
        this.logLine = reader.readLine();

        if (logLine == null) {
            return null;
        }

        this.logTime = Long.parseLong(logLine.split(" ")[0]);
        return logLine;
    }
}
