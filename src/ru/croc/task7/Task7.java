package ru.croc.task7;

public class Task7 {
    public static void main(String[] args) {

        try {
            ChessPosition cp = new ChessPosition(0, 0);
            System.out.println(cp);


            ChessPosition obj = ChessPosition.parse("h9");
            System.out.println(obj);

        } catch (IllegalPositionException e) {
            System.out.println(e);
        }

        String[] arr = {"b1", "a3", "c4", "d6"};


        try {
            ChessPosition.checkHorseMove("a0", "a1");
        } catch (IllegalMoveException e) {
            System.out.println(e);
        }


    }
}
