package ibf.ssf.pizza.models;

import java.io.Serializable;

import jakarta.json.JsonObject;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Pizza implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message="You forgot to select a pizza")
	private String pizza;

	@NotNull(message="Must specify a pizza size")
	private String size;

	@Min(value=1, message="You must order at least 1 pizza")
	@Max(value=10, message="You can only purchase a maximum of 10 pizzas")
	private int quantity;

	public void setPizza(String pizza) { this.pizza = pizza; }
	public String getPizza() { return this.pizza; }

	public void setSize(String size) { this.size = size; }
	public String getSize() { return this.size; }

	public void setQuantity(int quantity) { this.quantity = quantity; }
	public int getQuantity() { return this.quantity; }

	@Override
	public String toString() {
		return "Pizza{pizza=%s, size=%s, quantity=%d}".formatted(pizza, size, quantity);
	}

	public static Pizza create(JsonObject json) {
		Pizza pizza = new Pizza();
		pizza.setPizza(json.getString("pizza"));
		pizza.setSize(json.getString("size"));
		pizza.setQuantity(json.getInt("quantity"));
		return pizza;
	}
}
