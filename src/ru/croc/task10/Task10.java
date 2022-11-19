package ru.croc.task10;

public class Task10 {
    public static void main(String[] args) {
        String passwordTest = "aaaaada";
        String hashPasswordTest = Hash.getHashOfPassword(passwordTest);

        hashPasswordTest = "40682260CC011947FC2D0B1A927138C5";

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FindPassword(i, threads.length, hashPasswordTest));
            threads[i].start();
        }
    }
}
