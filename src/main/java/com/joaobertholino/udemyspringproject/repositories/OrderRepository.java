package com.joaobertholino.udemyspringproject.repositories;

import com.joaobertholino.udemyspringproject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
