package com.joaobertholino.udemyspringproject.services;

import com.joaobertholino.udemyspringproject.entities.Category;
import com.joaobertholino.udemyspringproject.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> result = this.categoryRepository.findById(id);
		return result.orElseThrow();
	}
}
