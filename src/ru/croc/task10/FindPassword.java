package ru.croc.task10;

public class FindPassword extends Thread {

    private final String hashPassword;

    private final long lowerBound;
    private final long upperBound;

    private final long start;
    private final long end;

    private static boolean passwordIsFounded = false;


    public FindPassword(int currentSteamNumber, int numberOfThreads, String hashPassword) {
        this(currentSteamNumber, numberOfThreads, hashPassword, 7);
    }

    public FindPassword(int currentSteamNumber, int numberOfThreads, String hashPassword, int lengthPassword) {
        this.hashPassword = hashPassword;

        this.lowerBound = (long) Math.pow(26, lengthPassword - 1);
        this.upperBound = (long) Math.pow(26, lengthPassword);

        this.start = lowerBound + currentSteamNumber * (upperBound - lowerBound) / numberOfThreads + ((currentSteamNumber == 0) ? 0 : 1);
        this.end = lowerBound + (currentSteamNumber + 1) * (upperBound - lowerBound) / numberOfThreads;
    }

    @Override
    public void run() {
        StringBuilder password = new StringBuilder();

        for (long i = start; i <= end; i++) {

            // If password is founded - stop searching password
            if (passwordIsFounded)
                return;

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
                passwordIsFounded = true;
                System.out.println("Password is founded: " + password);
                password.setLength(0);
                return;
            }
            password.setLength(0);
        }
        System.out.println("Password could not be founded"); // TODO: while all threads haven't given a verdict - do not output
    }
}
