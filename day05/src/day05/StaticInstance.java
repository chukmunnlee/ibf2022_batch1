package day05;

public class StaticInstance {

    public static void main(String[] args) {

        final Integer version = 10;

        // Access static member without instantiating the class
        Item.quantity = 100;
        Item.printQuantity();

        //Item.name = "grapes";

        Item apple = new Item();
        //apple.name = "apple";
        apple.setName("apple");
        //apple.setQuantity(10);

        Item orange = new Item();
        orange.setName("orange");
        //orange.setQuantity(3);

        System.out.printf("apple = %s, quantity: %d\n"
                , apple.getName(), apple.getQuantity());
        System.out.printf("orange = %s, quantity: %d\n"
                , orange.getName(), orange.getQuantity());

        Float radius = 2.5f;
        System.out.printf("The area of a circle with a radius of %f is %f\n",
            radius, Constants.PI * Math.pow(radius, 2));

        System.out.println("------------------------------\n");

        Item a = Item.create();
        a.setName("grapes");
        a.setQuantity(300);
        System.out.printf("a. name: %s, quantity: %d\n"
            , a.getName(), a.getQuantity());

        Item b = Item.create();
        b.setName("pineapple");
        System.out.printf("b. name: %s, quantity: %d\n"
            , b.getName(), b.getQuantity());

        Item c = Item.create();
        System.out.printf("c. name: %s, quantity: %d\n"
            , c.getName(), c.getQuantity());
        
    }

}