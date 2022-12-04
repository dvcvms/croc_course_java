package ru.croc.task16;

import java.util.Comparator;

public class LogComparator implements Comparator<FileComponent> {

    @Override
    public int compare(FileComponent o1, FileComponent o2) {
        return Long.compare(o1.getLogTime(), o2.getLogTime());
    }

}
