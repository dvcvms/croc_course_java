package ru.croc.task10;

import java.util.concurrent.Callable;

public class FindPassword implements Callable<String> {

    private final String hashPassword;

    private final long lowerBound;
    private final long upperBound;

    private final long start;
    private final long end;

    private static boolean passwordIsFounded;


    public FindPassword(int currentSteamNumber, int numberOfThreads, String hashPassword) {
        this(currentSteamNumber, numberOfThreads, hashPassword, 7);
    }

    public FindPassword(int currentSteamNumber, int numberOfThreads, String hashPassword, int lengthPassword) {
        this.hashPassword = hashPassword;

        this.lowerBound = (long) Math.pow(26, lengthPassword - 1);
        this.upperBound = (long) Math.pow(26, lengthPassword);

        this.start = lowerBound + currentSteamNumber * (upperBound - lowerBound) / numberOfThreads + ((currentSteamNumber == 0) ? 0 : 1);
        this.end = lowerBound + (currentSteamNumber + 1) * (upperBound - lowerBound) / numberOfThreads;

        this.passwordIsFounded = false;
    }

    @Override
    public String call() throws Exception {
        StringBuilder password = new StringBuilder();

        for (long i = start; i <= end; i++) {

            // If password is founded - stop searching password
            if (passwordIsFounded)
                return "";

            long t = i;
            while (t > 0) {

                long remains = t % 26;
                if (t == 1) {
                    remains--;
                }
                password.append((char) (remains + 97));

                t = t / 26;
            }

            if (hashPassword.equals(Hash.getHashOfPassword(password.toString()))) {
                this.passwordIsFounded = true;
                return password.toString();
            }
            password.setLength(0);
        }
        return ""; // TODO: while all threads haven't given a verdict - do not output
    }
}
