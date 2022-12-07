package ru.croc.task19;

import java.io.FileWriter;
import java.io.IOException;

public class Task19 {
    public static void main(String[] args) throws IOException {

        try(FileWriter writer = new FileWriter(args[0])) {
            writer.write("Hello world!");
            writer.flush();
        }

    }
}
