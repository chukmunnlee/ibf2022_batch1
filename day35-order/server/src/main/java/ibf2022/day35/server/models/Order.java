package ibf2022.day35.server.models;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

public class Order {

	private String orderId = "";
	private String name;
	private String email;
	private List<LineItem> lineItems = new LinkedList<>();

	public void setOrderId(String orderId) { this.orderId = orderId; }
	public String getOrderId() { return this.orderId; }

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }

	public void setEmail(String email) { this.email = email; }
	public String getEmail() { return this.email; }

	public void setLineItems(List<LineItem> lineItems) { this.lineItems = lineItems; }
	public List<LineItem> getLineItems() { return this.lineItems; }
	public void addLineItem(LineItem lineItem) { this.lineItems.add(lineItem); }
	public void removeLineItem(int idx) { this.lineItems.remove(idx); }

	public JsonObject toJson() {
		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		lineItems.stream()
			.forEach(v -> arrBuilder.add(v.toJson()));

		return Json.createObjectBuilder()
			.add("orderId", orderId)
			.add("name", name)
			.add("email", email)
			.add("lineItems", arrBuilder.build())
			.build();
	}

	public static Order toOrder(String j) {
		JsonReader reader = Json.createReader(new StringReader(j));
		return toOrder(reader.readObject());
	}
	public static Order toOrder(JsonObject j) {
		Order order = new Order();
		if (j.containsKey("orderId") && (!j.isNull("orderId")))
			order.setOrderId(j.getString("orderId"));
		order.setName(j.getString("name"));
		order.setEmail(j.getString("email"));
		List<LineItem> lineItems = j.getJsonArray("lineItems").stream()
			.map(i -> i.asJsonObject())
			.map(LineItem::toLineItem)
			.toList();
		order.setLineItems(lineItems);
		return order;
	}
}
