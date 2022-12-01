package myapp.ver1;

import java.io.Console;

public class Hello {

    public static void main(String[] args) {

        // Get system console
        Console cons = System.console();

        // Read from the console, the result is assigned to a variable
        String name = "";
        while (name.trim().length() <= 0) {
            name = cons.readLine("What is your name? ");
        }

        // use equals() for string comparison, == is for numbers
        if (name.trim().equals("fred")) {
            System.out.println("Yabadabadoo");

        } else if (name.equals("barney")) {
            System.out.println("Hello barney");

        } else {
            // Send a greeting to the name with a formatted string
            System.out.printf("Hello %s.\n\tNice to make your acquantance\n"
                    , name.toUpperCase());
        }

    }
}
