package ru.croc.task7;

public class Task7 {
    public static void main(String[] args) {

        try {
            ChessPosition cp = new ChessPosition(0, 0);
            System.out.println(cp);


            ChessPosition obj = ChessPosition.parse("#9");
            System.out.println(obj);

        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

        String[] arr = {"h8", "a2", "c4", "d6"};



        ChessPosition[] chessPositions;


        try {
            chessPositions = ChessPosition.parseIntoArrayOfChessPositionObjects(arr);
            for (int i = 0; i < arr.length; i++)
                System.out.println(chessPositions[i]);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
            chessPositions = null;
        }

        if (chessPositions != null) {
            try {
                ChessPosition.checkHorseMove(chessPositions);
            } catch (IllegalMoveException e) {
                e.printStackTrace();
            }
        }
    }
}
