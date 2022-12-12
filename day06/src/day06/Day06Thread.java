package day06;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day06Thread {

    public static void main(String[] args) {

        List<Integer> numList = new LinkedList<>();
        ExecutorService threadpool = Executors.newFixedThreadPool(2);

        for (Integer i = 0; i < 3; i++) {
            // Create a thread
            RandomNumbers thr = new RandomNumbers("thr-%d".formatted(i), 100, numList);
            // this is just a method call
            //thr.run();
            // Schedule a thread to the Runnable
            threadpool.submit(thr);
        }

        System.out.println("All done");
        while (true) {
            System.out.println("\n>>>> numList: " + numList + ", size: " + numList.size());
            try {
                // Sleep for 15 sec
                Thread.sleep(1 * 1000);
            } catch (InterruptedException ex) { }
        }
    }
}

