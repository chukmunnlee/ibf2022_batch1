package ibf2022.day35.server.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class LineItem {

	private String item;
	private int quantity;

	public void setItem(String item) { this.item = item; }
	public String getItem() { return this.item; }

	public void setQuantity(int quantity) { this.quantity = quantity; }
	public int getQuantity() { return this.quantity; }

	public JsonObject toJson() {
		return Json.createObjectBuilder()
			.add("item", item)
			.add("quantity", quantity)
			.build();
	}

	public static LineItem toLineItem(JsonObject j) {
		LineItem lineItem = new LineItem();
		lineItem.setItem(j.getString("item"));
		lineItem.setQuantity(j.getInt("quantity"));
		return lineItem;
	}
}
