package day07;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class TerminalOps {

    public static void main(String[] args) {
        // Randomly generate a list of numbers
        Integer max = 200;
        Integer range = 100;
        Random rnd = new SecureRandom();

        List<Integer> numList = new LinkedList<>();
        for (Integer i = 0; i < max; i++)
            numList.add(rnd.nextInt(range));

        System.out.println(">>> nunList: " + numList);

        //joining(numList);
        //reducing(numList);
        //joiningAsReducing(numList);
        reducing2(numList);
    }

    public static void joiningAsReducing(List<Integer> numList) {
        System.out.println("======== JOINING AS REDUCING ==========");

        Optional<String> opt = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n, n))
            .collect(
                // Integer apply(Integer total, Integer i)
                Collectors.reducing((total, i) -> {
                    System.out.printf("total: %s, i: %s\n", total, i);
                    return "%s, %s".formatted(total, i);
                })
            );

        // Check if we have any answer
        if (opt.isPresent())
            // Get the answer
            System.out.println(">>> total : " + opt.get());
        else
            System.out.println("Reducing produces no result");
    }

    public static void reducing(List<Integer> numList) {

        System.out.println("======== JOINING ==========");

        Optional<Integer> opt = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n, n))
            .map(Integer::parseInt)
            .collect(
                // Integer apply(Integer total, Integer i)
                Collectors.reducing((total, i) -> {
                    System.out.printf("total: %d, i: %d\n", total, i);
                    return total + i;
                })
            );

        // Check if we have any answer
        if (opt.isPresent())
            // Get the answer
            System.out.println(">>> total : " + opt.get());
        else
            System.out.println("Reducing produces no result");
    }


    public static void reducing2(List<Integer> numList) {

        System.out.println("======== JOINING ==========");

        Integer result = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n, n))
            .map(Integer::parseInt)
            .collect(
                // Integer apply(Integer total, Integer i)
                Collectors.reducing(
                    -100 // total = 0
                    , (total, i) -> {
                        System.out.printf("total: %d, i: %d\n", total, i);
                        return total + i;
                    }
                )
            );

        // Check if we have any answer
        System.out.println(">>> total : " + result);
    }

    public static void joining(List<Integer> numList) {

        System.out.println("======== JOINING ==========");

        String listOfNums = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n, n))
            .collect(Collectors.joining("\n"));
        System.out.println(">>> csv : " + listOfNums);
    }
    
}
