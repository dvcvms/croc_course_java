package ru.croc.task7;

public class IllegalMoveException extends Exception {

    private final String positionFrom;
    private final String positionTo;

    public IllegalMoveException(String positionFrom, String positionTo) {
        this.positionFrom = positionFrom;
        this.positionTo = positionTo;
    }

    @Override
    public String getMessage() {
        return "Конь так не ходит: " + positionFrom + " -> " + positionTo;
    }
}
