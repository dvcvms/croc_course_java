package ru.croc.task7;


import java.nio.CharBuffer;

public class ChessPosition {
    private final int x;
    private final int y;


    public ChessPosition(int x, int y) throws IllegalPositionException {
        if (checkOnOutOfRange(x, y)) {
            throw new IllegalPositionException(x, y);
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        char[] position = new char[2]; // position = (columnNumber, rowNumber)

        // convert from (1, 1) to (b, 1) view using ASCII Table:

        char columnNumber = (char) (this.x + 97);
        char rowNumber = (char) (this.y + 48);

        position[0] = columnNumber;
        position[1] = rowNumber;

        return new String(position);
    }

    static ChessPosition parse(String position) throws IllegalPositionException {

        int x = position.charAt(0) - 'a';
        int y = position.charAt(1) - '0';

        if (checkOnOutOfRange(x, y)) {
            throw new IllegalPositionException(x, y);
        }
        return new ChessPosition(x, y);
    }

    static void checkHorseMove(String... arr) throws IllegalMoveException {
        int xPrev = arr[0].charAt(0) - 'a';
        int yPrev = arr[0].charAt(1) - '0';

        for (int i = 1; i < arr.length; i++) {

            int xCurrent = arr[i].charAt(0) - 'a';
            int yCurrent = arr[i].charAt(1) - '0';

            int xDifference = Math.abs(xCurrent - xPrev);
            int yDifference = Math.abs(yCurrent - yPrev);

            boolean result = (xDifference == 2 & yDifference == 1) | (xDifference == 1 & yDifference == 2);

            if (!result) {
                throw new IllegalMoveException(arr[i - 1], arr[i]);
            }

            xPrev = xCurrent;
            yPrev = yCurrent;
        }
        System.out.println("OK");
    }


    static boolean checkOnOutOfRange(int x, int y) {
        return x < 0 | y < 0 | x > 7 | y > 7;
    }
}
