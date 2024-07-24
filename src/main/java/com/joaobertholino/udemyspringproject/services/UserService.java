package com.joaobertholino.udemyspringproject.services;

import com.joaobertholino.udemyspringproject.entities.User;
import com.joaobertholino.udemyspringproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> result = this.userRepository.findById(id);
		return result.orElseThrow();
	}

	public User insert(User user) {
		return this.userRepository.save(user);
	}

	public void deleteById(Long id) {
		this.userRepository.deleteById(id);
	}
}
