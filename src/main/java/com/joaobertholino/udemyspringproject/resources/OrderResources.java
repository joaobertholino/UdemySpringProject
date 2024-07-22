package com.joaobertholino.udemyspringproject.resources;

import com.joaobertholino.udemyspringproject.entities.Order;
import com.joaobertholino.udemyspringproject.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderResources {

	@Autowired
	private OrderServices orderServices;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		return ResponseEntity.ok().body(this.orderServices.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.orderServices.findById(id));
	}
}
