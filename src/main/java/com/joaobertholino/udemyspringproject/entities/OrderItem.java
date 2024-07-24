package com.joaobertholino.udemyspringproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaobertholino.udemyspringproject.entities.pk.OrderItemPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	@JsonIgnore
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();
	private Integer quantity;
	private Double price;

	public OrderItem() {
	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		this.id.setOrder(order);
		this.id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		this.id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		this.id.setProduct(product);
	}

	public OrderItemPk getId() {
		return id;
	}

	public void setId(OrderItemPk id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		OrderItem orderItem = (OrderItem) o;
		return id.equals(orderItem.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
