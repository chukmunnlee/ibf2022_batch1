package day06;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LambdaThreads {

    public static void main(String[] args) {

        ExecutorService thrpool = Executors.newFixedThreadPool(2);

        Runnable run = () -> {
            Random rnd = new SecureRandom();
            for (Integer j = 0; j < 10; j++)
                System.out.printf("[%d]: %d\n", j, rnd.nextInt(100));
        };

        for (Integer i = 0; i < 3; i++) {
            //thrpool.submit(run);
            thrpool.submit(() -> {
                Random rnd = new SecureRandom();
                for (Integer j = 0; j < 10; j++)
                    System.out.printf("[%d]: %d\n", j, rnd.nextInt(100));
            });
        }
    }
    
}
