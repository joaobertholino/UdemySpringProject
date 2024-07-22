package com.joaobertholino.udemyspringproject.config;

import com.joaobertholino.udemyspringproject.entities.Order;
import com.joaobertholino.udemyspringproject.entities.User;
import com.joaobertholino.udemyspringproject.entities.enums.OrderStatus;
import com.joaobertholino.udemyspringproject.repositories.OrderRepository;
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

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("Joao", "joao@gmail.com", "99999999999", "98989898");
		User u2 = new User("Ellen", "ellen@gmail.com", "88888888888", "76767676");

		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(Instant.parse("2019-07-12T07:34:15Z"), OrderStatus.WAITING_PAYMENT, u1);

		this.userRepository.saveAll(Arrays.asList(u1, u2));
		this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
