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

import ibf.ssf.pizza.models.Pizza;
import ibf.ssf.pizza.services.PizzaService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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

		return "index";
	}
}
