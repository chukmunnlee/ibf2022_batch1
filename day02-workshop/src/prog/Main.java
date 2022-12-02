package prog;

import cart.Apple;
import cart.Item;
import cart.Orange;

public class Main {

    public static void main(String[] args) {
        //Item apple = new Item("apple", "Apple");
        //Item orange = new Item("orange", "Orange");

        //apple.setPrice(.5f);
        //apple.setQuantity(10);

        //orange.setPrice(.5f);
        //orange.setQuantity(10);

        Apple apple = new Apple();
        apple.setType("washington");

        Orange orange = new Orange();

        System.out.printf("apple code: %s\n", apple.getCode());
        System.out.printf("orange code: %s\n", orange.getCode());

        Item item = apple;
        System.out.printf("item code: %s\n", item.getCode());

        Apple washington = (Apple)item;
        System.out.printf("washington code: %s\n", washington.getCode());

        System.out.printf("is item an Orange? %b\n", item instanceof Orange);
        if (item instanceof Orange)
            orange = (Orange)item;
    }
    
}
