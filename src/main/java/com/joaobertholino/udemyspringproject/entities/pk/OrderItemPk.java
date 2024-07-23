package com.joaobertholino.udemyspringproject.entities.pk;

import com.joaobertholino.udemyspringproject.entities.Order;
import com.joaobertholino.udemyspringproject.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class OrderItemPk implements Serializable {

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		OrderItemPk that = (OrderItemPk) o;
		return order.equals(that.order) && product.equals(that.product);
	}

	@Override
	public int hashCode() {
		int result = order.hashCode();
		result = 31 * result + product.hashCode();
		return result;
	}
}
