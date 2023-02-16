package ibf2022.paf.order.day29.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.paf.order.day29.Utils;
import ibf2022.paf.order.day29.models.Order;
import ibf2022.paf.order.day29.services.OrderService;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	@Autowired
	private OrderService orderSvc;

	@PostMapping(path="/order", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postOrder(@RequestBody String payload) {

		System.out.printf(">>> payload: %s\n", payload);

		// from JSON (data interchange format) -> Order (domain entity)
		JsonObject json = Utils.toJson(payload);
		Order order = Utils.toOrder(json);

		String orderId = orderSvc.insertOrder(order);

		JsonObject resp = Json.createObjectBuilder()
			.add("orderId", orderId)
			.add("message", "Created")
			.build();

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(resp.toString());
	}

}
