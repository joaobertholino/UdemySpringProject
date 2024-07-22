package com.joaobertholino.udemyspringproject.services;

import com.joaobertholino.udemyspringproject.entities.Product;
import com.joaobertholino.udemyspringproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> result = this.productRepository.findById(id);
		return result.orElseThrow();
	}
}
