package com.joaobertholino.udemyspringproject.services;

import com.joaobertholino.udemyspringproject.entities.Order;
import com.joaobertholino.udemyspringproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		return this.orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> result = this.orderRepository.findById(id);
		return result.orElseThrow();
	}
}