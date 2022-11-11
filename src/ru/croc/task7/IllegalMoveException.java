package ru.croc.task7;

public class IllegalMoveException extends Exception {

    private final ChessPosition positionFrom;
    private final ChessPosition positionTo;


    public IllegalMoveException(ChessPosition positionFrom, ChessPosition positionTo) {
        this.positionFrom = positionFrom;
        this.positionTo = positionTo;
    }

    @Override
    public String getMessage() {
        return "Конь так не ходит: " + positionFrom.toString() + " -> " + positionTo.toString();
    }
}
