package ibf2022.day35.server.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.day35.server.models.Order;
import ibf2022.day35.server.respositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	public String createOrder(Order order) {
		String orderId = UUID.randomUUID().toString().substring(0, 8);
		order.setOrderId(orderId);
		orderRepo.createOrder(order);
		return orderId;
	}
}
