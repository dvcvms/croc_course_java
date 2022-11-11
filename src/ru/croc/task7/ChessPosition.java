package ru.croc.task7;


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

    public static ChessPosition parse(String position) throws IllegalPositionException {

        boolean positionIsCorrect = checkForCorrectStringRepresentation(position);

        if (positionIsCorrect) {

            int x = position.charAt(0) - 'a';
            int y = position.charAt(1) - '1';

            if (checkOnOutOfRange(x, y)) {
                throw new IllegalPositionException(x, y);
            }

            return new ChessPosition(x, y);

        } else {
            throw new IllegalPositionException(position);
        }
    }

    public static void checkHorseMove(ChessPosition... arr) throws IllegalMoveException {
        int xPrev = arr[0].getX();
        int yPrev = arr[0].getY();

        for (int i = 1; i < arr.length; i++) {

            int xCurrent = arr[i].getX();
            int yCurrent = arr[i].getY();

            int xDifference = Math.abs(xCurrent - xPrev);
            int yDifference = Math.abs(yCurrent - yPrev);

            boolean canMove = (xDifference == 2 & yDifference == 1) | (xDifference == 1 & yDifference == 2);

            if (!canMove) {
                throw new IllegalMoveException(arr[i - 1], arr[i]);
            }

            xPrev = xCurrent;
            yPrev = yCurrent;
        }
        System.out.println("OK");
    }

    public static ChessPosition[] parseIntoArrayOfChessPositionObjects(String[] str) throws IllegalPositionException {

        if (str.length == 0) {
            return null;
        }

        ChessPosition[] arr = new ChessPosition[str.length];

        for (int i = 0; i < str.length; i++)
            arr[i] = parse(str[i]);

        return arr;
    }

    @Override
    public String toString() {
        char[] position = new char[2]; // position = (columnNumber, rowNumber)

        // convert from (1, 1) to (b, 1) view using ASCII Table:

        char columnNumber = (char) (this.x + 97);
        char rowNumber = (char) (this.y + 49);

        position[0] = columnNumber;
        position[1] = rowNumber;

        return new String(position);
    }

    private int getY() {
        return y;
    }

    private int getX() {
        return x;
    }

    private static boolean checkOnOutOfRange(int x, int y) {
        return x < 0 | y < 0 | x > 7 | y > 7;
    }

    private static boolean checkForCorrectStringRepresentation(String position) {
        if (position.length() != 2)
            return false;

        return position.charAt(0) >= 'a' && position.charAt(0) <= 'h' && position.charAt(1) >= '1' && position.charAt(1) <= '8';
    }
}
