package ru.croc.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {
    public static String calculatePassword(int threadsNumber, String hashPass) throws ExecutionException, InterruptedException {
        String result = "";

        ExecutorService pool = Executors.newFixedThreadPool(threadsNumber);
        List<Future<String>> futures = new ArrayList<>(threadsNumber);


        for (int i = 0; i < threadsNumber; i++) {
            futures.add(pool.submit(new FindPassword(i, threadsNumber, hashPass)));
        }

        for (Future<String> future : futures) {
            String futureResponse = future.get();
            if (!futureResponse.equals("")) {
                result = futureResponse;
                break;
            }
        }

        return result;
    }
}
