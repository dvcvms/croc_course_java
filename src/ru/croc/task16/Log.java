package ru.croc.task16;

public class Log {
    private final Long time;
    private final String message;

    public Log(Long time, String message) {
        this.time = time;
        this.message = message;
    }

    public Long getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return this.time + " " + this.message;
    }
}
