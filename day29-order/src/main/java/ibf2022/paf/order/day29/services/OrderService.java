package ibf2022.paf.order.day29.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.paf.order.day29.models.Order;
import ibf2022.paf.order.day29.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	public String insertOrder(Order order) {
		String orderId = UUID.randomUUID().toString().substring(0, 8);
		order.setOrderid(orderId);

		// Save to mongo
		orderRepo.insertOrder(order);

		return orderId;
	}
}
