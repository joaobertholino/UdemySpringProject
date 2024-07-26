package com.joaobertholino.udemyspringproject.config;

import com.joaobertholino.udemyspringproject.entities.*;
import com.joaobertholino.udemyspringproject.entities.enums.OrderStatus;
import com.joaobertholino.udemyspringproject.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	private final UserRepository userRepository;
	private final OrderRepository orderRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final OrderItemRepository orderItemRepository;

	public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.orderItemRepository = orderItemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category("Electronics");
		Category c2 = new Category("Books");
		Category c3 = new Category("Computers");
		this.categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

		Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		p1.getCategories().add(c2);
		p2.getCategories().addAll(Arrays.asList(c1, c3));
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User("Joao", "joao@gmail.com", "99999999999", "98989898");
		User u2 = new User("Ellen", "ellen@gmail.com", "88888888888", "76767676");
		User u3 = new User("Nicolas", "nicolas@gmail.com", "88888888888", "76767676");
		User u4 = new User("Lucas", "lucas@gmail.com", "88888888888", "76767676");
		User u5 = new User("Irineu", "irineu@gmail.com", "88888888888", "76767676");
		User u6 = new User("Carlos", "carlos@gmail.com", "88888888888", "76767676");
		this.userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));

		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(Instant.parse("2019-07-12T07:34:15Z"), OrderStatus.WAITING_PAYMENT, u1);
		this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		this.orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Payment pay1 = new Payment(Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		this.orderRepository.save(o1);
	}
}
