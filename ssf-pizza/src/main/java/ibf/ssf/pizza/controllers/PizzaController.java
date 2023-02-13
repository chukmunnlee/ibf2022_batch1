package ibf.ssf.pizza.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import ibf.ssf.pizza.models.Pizza;
import ibf.ssf.pizza.models.Delivery;
import ibf.ssf.pizza.models.Order;
import ibf.ssf.pizza.services.PizzaService;

@Controller
public class PizzaController {

	@Autowired
	private PizzaService pizzaSvc;

	private Logger logger = Logger.getLogger(PizzaController.class.getName());

	@GetMapping(path={"/", "/index.html"})
	public String getIndex(Model model, HttpSession sess) {
		sess.invalidate();
		model.addAttribute("pizza", new Pizza());
		return "index";
	}

	@PostMapping(path="/pizza")
	public String postPizza(Model model, HttpSession sess
			, @Valid Pizza pizza, BindingResult bindings) {

		logger.info("POST /pizza: %s".formatted(pizza.toString()));

		// Syntatic and semantic validation
		if (bindings.hasErrors())
			return "index";

		List<ObjectError> errors = pizzaSvc.validatePizzaOrder(pizza);
		if (!errors.isEmpty()) {
			for (ObjectError err: errors)
				bindings.addError(err);
			return "index";
		}

		sess.setAttribute("pizza", pizza);

		model.addAttribute("delivery", new Delivery());

		return "delivery";
	}

	@PostMapping(path="/pizza/order")
	public String postPizzaOrder(Model model, HttpSession sess
				, @Valid Delivery delivery, BindingResult bindings) {

		logger.info("POST /pizza/order: %s".formatted(delivery.toString()));

		if (bindings.hasErrors())
			return "delivery";

		Pizza pizza = (Pizza)sess.getAttribute("pizza");

		Order order = pizzaSvc.savePizzaOrder(pizza, delivery);

		logger.info("%s".formatted(order));

		model.addAttribute("order", order);

		return "order";
	}
}
