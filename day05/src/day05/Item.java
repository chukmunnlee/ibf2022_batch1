package day05;

public class Item {

    private static Item item = null;

    public static Integer quantity;
    public String name;

    public static void printQuantity() {
        System.out.printf(">>> the quantity is %d\n", quantity);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { Item.quantity = quantity; }

    public static Item create() {
        if (null == item)
            item = new Item();
        return item;
    }
    
}
