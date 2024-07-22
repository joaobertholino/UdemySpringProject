package com.joaobertholino.udemyspringproject.resources;

import com.joaobertholino.udemyspringproject.entities.User;
import com.joaobertholino.udemyspringproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe de recursos referente a classe {@link User} que define um end-point de acesso aos dados de usuários utilizando
 * as anotações:
 * <ul>
 *   <li>
 *     {@link RestController} Anotação responsável por especificar esta classe como um controlador REST.
 *   </li>
 *   <li>
 *     {@link RequestMapping} Anotação responsável por mapear requisições web recebendo um path relativo,
 *     {@code "/users"}, que sera usado para compor a URL mapeada para esse recurso.
 *   </li>
 * </ul>
 */
@RestController
@RequestMapping(path = "/users")
public class UserResources {

	@Autowired
	private UserService userService;

	/**
	 * Método responsável por retornar todos os usuários por meio de uma requisição http GET utilizando a anotação:
	 * <ul>
	 *   <li>
	 *     {@link GetMapping} Anotação responsável por mapear requisições GET ao método {@code findAll}.
	 *   </li>
	 * </ul>
	 *
	 * @return Retorna um objeto da classe {@link ResponseEntity}, recebendo o tipo {@link User} como tipo genérico, como
	 * resultado da requisição GET.
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(this.userService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.userService.findById(id));
	}
}
