package ru.croc.task7;

public class Task7 {
    public static void main(String[] args) throws IllegalPositionException, IllegalMoveException {

        ChessPosition cp = new ChessPosition(0, 0);
        System.out.println(cp);

        ChessPosition obj = ChessPosition.parse("h7");
        System.out.println(obj);

        String[] arr = {"g8", "e7", "c8"};

        ChessPosition[] chessPositions;

        chessPositions = ChessPosition.parseIntoArrayOfChessPositionObjects(arr);
        if (chessPositions != null)
            for (int i = 0; i < arr.length; i++)
                System.out.println(chessPositions[i]);

        ChessPosition.checkHorseMove(chessPositions);

    }
}

