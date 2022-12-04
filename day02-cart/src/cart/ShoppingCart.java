package cart;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {

    public static final String APPLE = "apple";
    public static final String ORANGE = "orange";

    private List<Item> cart;

    public ShoppingCart() {
        this.cart = new LinkedList<>();
    }

    public void listContents() {

        if (cart.size() <= 0) {
            System.out.println("Your shopping cart is empty");
            return;
        }

        System.out.println("Your shopping cart has the following items:");
        for (Integer i = 0; i < cart.size(); i++) {
            Item item = cart.get((int)i);
            System.out.printf("%d: %s, %d, $%.2f\n", i + 1, item.getName(), item.getQuantity(), item.getPrice());
        }
    }

    public Boolean addToCart(String item, Integer quantity, Float price) {
        Item toAdd = null;
        switch (item) {
            case APPLE:
                toAdd = new Apple();
                break;

            case ORANGE:
                toAdd = new Orange();
                break;

            default:
                return false;
        }

        // Set quantity and price
        toAdd.setQuantity(quantity);
        toAdd.setPrice(price);
        this.cart.add(toAdd);

        return true;
    }

    public Boolean removeFromCart(Integer index) {
        // Check if the index is in the list range
        if ((index < 0) || (index >= this.cart.size()))
            return false;

        this.cart.remove((int)index);
        return true;
    }

    public void calculate() {
        this.calculate(0f);
    }
    public void calculate(Float discount) {
        Float total = 0f;
        // This is called the for-each loop. 
        // An alternative for loop, used only for arrays and collection
        // The for-each loops loops the contents
        for (Item item: this.cart) {
            Float subtotal = item.getPrice() * item.getQuantity();
            System.out.printf("%s [%s] %d@%.2f=$%.2f\n", 
                    item.getName(), item.getCode(), item.getQuantity(), item.getPrice(), subtotal);
            total += subtotal;
        }

        if (0 != discount) {
            System.out.printf("Applying a %2.2f%% discount to %f\n", discount, total);
            total -= (total * discount);
        }

        System.out.printf("Grand total: $%.2f\n", total);
    }
}
