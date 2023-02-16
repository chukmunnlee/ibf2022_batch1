package ibf2022.paf.order.day29;

import java.io.Reader;
import java.io.StringReader;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import ibf2022.paf.order.day29.models.LineItem;
import ibf2022.paf.order.day29.models.Order;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {

	public static JsonObject toJson(String str) {
		Reader reader = new StringReader(str);
		JsonReader jsonReader = Json.createReader(reader);
		return jsonReader.readObject();
	}

	public static Document toDocument(LineItem lineItem) {
		Document doc = new Document();
		doc.put("item", lineItem.getItem());
		doc.put("quantity", lineItem.getQuantity());
		return doc;
	}

	public static Document toDocument(Order order) {
		Document doc = new Document();
		doc.put("orderId", order.getOrderid());
		doc.put("name", order.getName());
		doc.put("email", order.getEmail());
		doc.put("deliveryDate", order.getDeliveryDate());

		List<Document> docs = order.getLineItems()
			.stream()
			.map(v -> toDocument(v))
			.toList();
		doc.put("lineItems", docs);
		return doc;
	}

	public static JsonObject toJson(Order order) {

		JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
		order.getLineItems()
			.stream()
			.map(v -> toJson(v))
			.forEach(v -> {
				arrBuilder.add(v);
			});

		return Json.createObjectBuilder()
			.add("orderId", order.getOrderid())
			.add("name", order.getName())
			.add("email", order.getEmail())
			.add("deliveryDate", order.getDeliveryDate().toString())
			.add("lineItems", arrBuilder.build())
			.build();
	}

	public static JsonObject toJson(LineItem lineItem) {
		return Json.createObjectBuilder()
			.add("item", lineItem.getItem())
			.add("quantity", lineItem.getQuantity())
			.build();
	}

	public static LineItem toLineItem(JsonObject json) {
		LineItem lineItem = new LineItem();
		lineItem.setItem(json.getString("item"));
		lineItem.setQuantity(json.getInt("quantity"));
		return lineItem;
	}
	public static Order toOrder(JsonObject json) {
		Order order = new Order();
		order.setName(json.getString("name"));
		order.setEmail(json.getString("email"));
		// yyyy-mm-dd
		// Date date = convert the date
		order.setDeliveryDate(new Date());

		List<LineItem> lineItems = json.getJsonArray("lineItems")
			.stream()
			.map(v -> (JsonObject)v)
			.map(v -> toLineItem(v))
			.toList();
		order.setLineItems(lineItems);

		return order;
	}
}
