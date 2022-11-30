package ru.croc.task16;

public class Log {
    private Long time;
    private String message;

    public Log(Long time, String message) {
        this.time = time;
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return time + " " + message;
    }
}
