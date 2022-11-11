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

        String[] arr = {"b9", "a2", "c4", "d6"};


        ChessPosition[] chessPositions = new ChessPosition[arr.length];


        try {
            chessPositions = ChessPosition.parseIntoArrayOfChessPositionObjects(arr);
        } catch (IllegalPositionException e) {
//            System.out.println(e);
            e.printStackTrace();
        }


        try {
            ChessPosition.checkHorseMove(chessPositions);
        } catch (IllegalMoveException e) {
//            System.out.println(e);
            e.printStackTrace();
        }


    }
}
