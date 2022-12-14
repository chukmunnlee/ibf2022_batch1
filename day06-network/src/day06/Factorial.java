package day06;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {

    private Integer factorial = 0;

    public Factorial(Integer factorial) {
        this.factorial = factorial;
    }

    @Override
    public Integer call() {
        Integer total = 1;
        for (Integer i = 2; i <= factorial; i++)
            total *= i;
        System.out.printf(">>>> %d\n", total);
        return total;
    }
    
}
