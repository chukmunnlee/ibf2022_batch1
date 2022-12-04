package cart;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> cart = new LinkedList<>();
        Console cons = System.console();
        Boolean stop = false;

        while (!stop) {
            // list
            // add <item>
            // delete <num>
            // exit
            String line = cons.readLine("> ");
            // command line delimited by space
            line = line.trim();
            // add apple => ["add", "apple"]
            // list => ["list"]
            String[] terms = line.split(" ");

            switch (terms[0]) {
                case "list":
                    if (cart.size() <= 0) {
                        System.out.println("Your cart is empty");
                    } else {
                        System.out.println("The contents of your cart");
                        for (Integer idx = 0; idx < cart.size(); idx++)
                            System.out.printf("%d. %s\n", idx + 1, cart.get(idx));
                    }
                    break;

                case "add": // add apple orange pear
                    // Check if add has any items
                    cart.add(terms[1]);
                    System.out.printf("Added %s to cart\n", terms[1]);
                    break;

                case "delete":
                    // delete has any number and if the number is valid
                    Integer index = Integer.parseInt(terms[1]);
                    cart.remove((int)index);
                    break;

                case "exit":
                    stop = true;
                    break;

                default:
                    System.err.printf("Unknown command: %s\n", terms[0]);
            }
        }

        System.out.println("Thank you for shopping with us. Bye bye.");

    }

}