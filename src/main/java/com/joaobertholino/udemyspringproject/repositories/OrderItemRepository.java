package com.joaobertholino.udemyspringproject.repositories;

import com.joaobertholino.udemyspringproject.entities.OrderItem;
import com.joaobertholino.udemyspringproject.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
