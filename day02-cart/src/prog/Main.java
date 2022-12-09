package prog;

import java.io.Console;

import cart.ShoppingCart;

public class Main {

    // This is how you declare constant
    public static final String CHECKOUT = "checkout";
    public static final String ADD = "add";
    public static final String REMOVE = "remove";
    public static final String LIST = "list";

    public static void main(String[] args) {
        // Get an instance of Console
        Console cons = System.console();

        // Boolean to control the command line
        Boolean stop = false;

        // Create an instance of ShoppingCart
        ShoppingCart shoppingCart = new ShoppingCart();

        while (!stop) {
            String line = cons.readLine("> ");
            String[] terms = line.trim().split(" ");

            switch (terms[0]) {
                // checkout or checkout .03
                case CHECKOUT:
                    Float discount = 0f;
                    // Check if discount is applied
                    if (terms.length > 0)
                        discount = Float.parseFloat(terms[1]);
                    shoppingCart.calculate(discount);
                    stop = true;
                    break;

                // add apple quantity price
                case ADD:
                    String item = terms[1];
                    Integer quantity = Integer.parseInt(terms[2]);
                    Float price = Float.parseFloat(terms[3]);
                    if (shoppingCart.addToCart(item, quantity, price))
                        System.out.printf("%s added to your shopping cart\n", item);
                    else
                        System.err.printf("%s is not in our inventory.\n", item);
                    break;

                // remove 3
                case REMOVE:
                    Integer index = Integer.parseInt(terms[1]);
                    if (shoppingCart.removeFromCart(index))
                        System.out.println("Item removed from shopping cart");
                    else
                        System.out.println("Cannot find item in the shopping cart");
                    break;

                // list
                case LIST:
                    shoppingCart.listContents();
                    break;

                default:
                    System.out.printf("Unknown command: %s\n", terms[0]);
            }
            System.out.println();
        }

        System.out.println("Thank you for shopping with us");
    }
    
}
