package day06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialMain {

    public static void main(String[] args) throws Exception {

        ExecutorService thrPool = Executors.newFixedThreadPool(2);

        Factorial factorial = new Factorial(10);
        
        Future<Integer> future = thrPool.submit(factorial);

        // Wait until it is done
        while (!future.isDone()) {
            System.out.println("Waiting....");
        }

        System.out.printf("The answer of 10! is %d\n", future.get());

        thrPool.shutdown();
    }
    
}
