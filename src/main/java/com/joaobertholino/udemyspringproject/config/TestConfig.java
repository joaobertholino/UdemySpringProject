package com.joaobertholino.udemyspringproject.config;

import com.joaobertholino.udemyspringproject.entities.Category;
import com.joaobertholino.udemyspringproject.entities.Order;
import com.joaobertholino.udemyspringproject.entities.Product;
import com.joaobertholino.udemyspringproject.entities.User;
import com.joaobertholino.udemyspringproject.entities.enums.OrderStatus;
import com.joaobertholino.udemyspringproject.repositories.CategoryRepository;
import com.joaobertholino.udemyspringproject.repositories.OrderRepository;
import com.joaobertholino.udemyspringproject.repositories.ProductRepository;
import com.joaobertholino.udemyspringproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

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
		this.userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(Instant.parse("2019-07-12T07:34:15Z"), OrderStatus.WAITING_PAYMENT, u1);
		this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
