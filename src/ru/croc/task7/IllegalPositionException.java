package ru.croc.task7;

public class IllegalPositionException extends Exception {

    private final String invalidPosition;

    public IllegalPositionException(int x, int y) {
        this.invalidPosition = Integer.toString(x) + y;
    }

    public IllegalPositionException(String position) {
        this.invalidPosition = position;
    }

    @Override
    public String getMessage() {
        return "Invalid chess position - " + this.invalidPosition;
    }
}
