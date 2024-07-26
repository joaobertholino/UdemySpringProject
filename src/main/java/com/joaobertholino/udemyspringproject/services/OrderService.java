package com.joaobertholino.udemyspringproject.services;

import com.joaobertholino.udemyspringproject.entities.Order;
import com.joaobertholino.udemyspringproject.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> findAll() {
		return this.orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> result = this.orderRepository.findById(id);
		return result.orElseThrow();
	}
}
