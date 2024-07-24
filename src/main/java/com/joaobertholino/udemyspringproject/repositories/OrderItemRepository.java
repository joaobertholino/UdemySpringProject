package com.joaobertholino.udemyspringproject.repositories;

import com.joaobertholino.udemyspringproject.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
