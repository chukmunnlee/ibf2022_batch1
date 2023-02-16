package ibf2022.paf.order.day29.models;

public class LineItem {
    private String item;
    private int quantity;

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    @Override
    public String toString() {
        return "LineItem [item=" + item + ", quantity=" + quantity + "]";
    } 
}
