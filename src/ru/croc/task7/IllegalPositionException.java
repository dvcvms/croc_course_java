package ru.croc.task7;

public class IllegalPositionException extends Exception {
    private final int x;
    private final int y;

    public IllegalPositionException(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getMessage() {
        return ("Uncorrected chess position ("  + x + ", " + y + ")");
    }

}
