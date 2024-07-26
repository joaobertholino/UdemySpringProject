package com.joaobertholino.udemyspringproject.resources;

import com.joaobertholino.udemyspringproject.entities.User;
import com.joaobertholino.udemyspringproject.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

	private final UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(this.userService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok(this.userService.findById(id));
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		User userInserted = this.userService.insert(user);
		UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}");
		UriComponents components = builder.buildAndExpand(userInserted.getId());
		return ResponseEntity.created(components.toUri()).body(userInserted);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		this.userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody User user) {
		user = this.userService.updateById(id, user);
		return ResponseEntity.ok(user);
	}
}
