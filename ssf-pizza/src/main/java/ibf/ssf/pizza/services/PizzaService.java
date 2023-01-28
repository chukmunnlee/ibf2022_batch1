package ibf.ssf.pizza.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import ibf.ssf.pizza.models.Pizza;

@Service
public class PizzaService {

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
