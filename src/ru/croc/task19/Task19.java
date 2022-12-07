package ru.croc.task19;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Task19 {
    public static void main(String[] args) throws IOException {

        try (PrintWriter writer = new PrintWriter(args[0], StandardCharsets.UTF_8)) {
            writer.println("Hello, world!");
            writer.flush();
        }

    }
}
