package com.joaobertholino.udemyspringproject.services;

import com.joaobertholino.udemyspringproject.entities.Product;
import com.joaobertholino.udemyspringproject.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> result = this.productRepository.findById(id);
		return result.orElseThrow();
	}
}
