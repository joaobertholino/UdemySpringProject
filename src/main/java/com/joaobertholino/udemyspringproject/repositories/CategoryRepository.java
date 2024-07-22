package com.joaobertholino.udemyspringproject.repositories;

import com.joaobertholino.udemyspringproject.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
