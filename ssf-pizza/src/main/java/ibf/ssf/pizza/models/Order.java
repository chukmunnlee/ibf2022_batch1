package ibf.ssf.pizza.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Order {

	private float totalCost = -1;
	private String orderId;

	private final Pizza pizza;
	private final Delivery delivery;

	public Order(Pizza pizza, Delivery delivery) {
		this.pizza = pizza;
		this.delivery = delivery;
	}

	public void setOrderId(String orderId) { this.orderId = orderId; }
	public String getOrderId() { return this.orderId; }

	public float getPizzaCost() { 
		return isRush()? getTotalCost() - 2: getTotalCost();
	}
	public void setTotalCost(float totalCost) { this.totalCost = totalCost; }
	public float getTotalCost() { return this.totalCost; }

	public String getPizza() { return this.pizza.getPizza(); }
	public String getSize() { return this.pizza.getSize(); }
	public int getQuantity() { return this.pizza.getQuantity(); }
	public String getName() { return this.delivery.getName(); }
	public String getAddress() { return this.delivery.getAddress(); }
	public String getPhone() { return this.delivery.getPhone(); }
	public boolean getRush() { return this.delivery.getRush(); }
	public boolean isRush() { return this.delivery.isRush(); }
	public String getComments() { return this.delivery.getComments(); }

	@Override
	public String toString() {
		return "Order{orderId=%s, totalCost=%.3f, pizza=%s, delivery=%s}"
				.formatted(orderId, totalCost, pizza, delivery);
	}

	public static JsonObject toJSON(String str) {
		JsonReader reader = Json.createReader(new StringReader(str));
		return reader.readObject();
	}

	public static Order create(String str) {
		JsonObject json = toJSON(str);
		Pizza pizza = Pizza.create(json);
		Delivery delivery = Delivery.create(json);
		Order order = new Order(pizza, delivery);
		order.setOrderId(json.getString("orderId"));
		order.setTotalCost((float)json.getJsonNumber("total").doubleValue());
		return order;
	}

	public JsonObject toJSON() {
		return Json.createObjectBuilder()
			.add("orderId", orderId)
			.add("name", getName())
			.add("address", getAddress())
			.add("phone", getPhone())
			.add("rush", isRush())
			.add("comments", getComments())
			.add("pizza", getPizza())
			.add("size", getSize())
			.add("quantity", getQuantity())
			.add("total", totalCost)
			.build();
	}
}
