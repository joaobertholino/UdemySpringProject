package com.joaobertholino.udemyspringproject.services;

import com.joaobertholino.udemyspringproject.entities.User;
import com.joaobertholino.udemyspringproject.repositories.UserRepository;
import com.joaobertholino.udemyspringproject.services.exceptions.DatabaseIntegrityException;
import com.joaobertholino.udemyspringproject.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> result = this.userRepository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return this.userRepository.save(user);
	}

	public void deleteById(Long id) {
		this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		try {
			this.userRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseIntegrityException(id);
		}
	}

	public User updateById(Long id, User user) {
		User entity = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		updateData(entity, user);
		return this.userRepository.save(entity);
	}

	private void updateData(User entity, User user) {
		if (user.getName() != null) entity.setName(user.getName());
		if (user.getEmail() != null) entity.setEmail(user.getEmail());
		if (user.getPhone() != null) entity.setPhone(user.getPhone());
	}
}
