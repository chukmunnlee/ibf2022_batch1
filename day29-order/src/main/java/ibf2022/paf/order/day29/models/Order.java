package ibf2022.paf.order.day29.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Order {

    private String orderId;
    private String name;
    private String email;
    private Date deliveryDate;
    private List<LineItem> lineItems = new LinkedList<>();

    public String getOrderid() { return orderId; }
    public void setOrderid(String orderId) { this.orderId = orderId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(Date deliveryDate) { this.deliveryDate = deliveryDate; }

    public List<LineItem> getLineItems() { return lineItems; }
    public void setLineItems(List<LineItem> lineItems) { this.lineItems = lineItems; }
    public void addItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    @Override
    public String toString() {
        return "Order [name=" + name + ", email=" + email + ", deliveryDate=" 
			  + deliveryDate + ", lineItems=" + lineItems + "]";
    }
}
