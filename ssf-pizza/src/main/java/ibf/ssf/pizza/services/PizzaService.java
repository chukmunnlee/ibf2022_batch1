package ibf.ssf.pizza.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import ibf.ssf.pizza.models.Delivery;
import ibf.ssf.pizza.models.Order;
import ibf.ssf.pizza.models.Pizza;
import ibf.ssf.pizza.repositories.PizzaRepository;

@Service
public class PizzaService {

	@Autowired 
	private PizzaRepository pizzaRepo;

	public static final String[] PIZZA_NAMES = {
		"bella", "margherita", "marinara", "spianatacalabrese", "trioformaggio"
	};
	public static final String[] PIZZA_SIZES = { "sm", "md", "lg" };

	private final Set<String> pizzaNames;
	private final Set<String> pizzaSizes;

	public PizzaService() {
		pizzaNames = new HashSet<>(Arrays.asList(PIZZA_NAMES));
		pizzaSizes = new HashSet<>(Arrays.asList(PIZZA_SIZES));
	}

	public Optional<Order> getOrderByOrderId(String orderId) {
		return pizzaRepo.get(orderId);
	}

	public Order savePizzaOrder(Pizza pizza, Delivery delivery) {
		Order order = createPizzaOrder(pizza, delivery);
		calculateCost(order);
		pizzaRepo.save(order);
		return order;
	}

	public Order createPizzaOrder(Pizza pizza, Delivery delivery) {
		String orderId = UUID.randomUUID().toString().substring(0, 8);
		Order order = new Order(pizza, delivery);
		order.setOrderId(orderId);
		return order;
	}

	public float calculateCost(Order order) {
		float total = 0f;

		switch (order.getPizza()) {
			case "margherita":
				total += 22;
				break;
			case "trioformaggio":
				total += 25;
				break;
			case "bella", "marinara", "spianatacalabrese":
				total += 30;
				break;
			default:
		}

		switch (order.getSize()) {
			case "md":
				total *= 1.2;
				break;
			case "lg":
				total *= 1.5;
				break;
			case "sm":
			default:
		}

		total *= order.getQuantity();

		if (order.isRush())
			total += 2;

		order.setTotalCost(total);

		return total;
	}

	public List<ObjectError> validatePizzaOrder(Pizza pizza) {
		List<ObjectError> errors = new LinkedList<>();
		FieldError error;

		if (!pizzaNames.contains(pizza.getPizza().toLowerCase())) {
			error = new FieldError("pizza", "pizza"
					, "We do not have %s pizza".formatted(pizza.getPizza()));
			errors.add(error);
		}

		if (!pizzaSizes.contains(pizza.getSize().toLowerCase())) {
			error = new FieldError("pizza", "size"
					, "We do not have %s size".formatted(pizza.getSize()));
			errors.add(error);
		}

		return errors;
	}
}
