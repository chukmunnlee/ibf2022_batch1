package ibf2022.paf.order.day29.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.order.day29.Constants;
import ibf2022.paf.order.day29.Utils;
import ibf2022.paf.order.day29.models.Order;
import jakarta.json.JsonObject;

@Repository
public class OrderRepository {

	@Autowired
	private MongoTemplate template;

	public void insertOrder(Order order) {
		Document doc = Utils.toDocument(order);
		template.insert(doc, Constants.COLLECTION_PURCHASE_ORDER);
	}
}
