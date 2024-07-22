package com.joaobertholino.udemyspringproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma entidade do tipo {@code User} sendo mapeada com JPA/Hibernate utilizando as anotações:
 * <ul>
 * 	<li>
 *    {@link Entity} Especifica a classe como sendo uma entidade.
 * 	</li>
 * 	<li>
 *    {@link Table} Especifica o nome da tabela primaria para a entidade anotada.
 * 	</li>
 * </ul>
 *
 * @implNote Esta classe implementa a interface {@link Serializable} para poder passar pelo processo de serialização,
 * sendo convertidos em um fluxo de bytes podendo ser trafegados em rede ou gravados em arquivos, e desserialização,
 * sendo um objeto serializado, convertido de volta a um objeto Java mantendo seu estado do qual foi serializado.
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	/**
	 * Mapeando o campo {@code id} especificando sua representatividade como chave primaria da entidade e especificando
	 * sua estrategia de geração dos valores que pertencem a chave primaria utilizando as anotações:
	 * <ul>
	 *   <li>
	 *     {@link Id} Especifica o campo que representa a chave primaria de uma entidade.
	 *   </li>
	 *   <li>
	 *     {@link GeneratedValue} Especifica a estrategia a ser utilizada na geração da chave primaria.
	 *   </li>
	 * </ul>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private final List<Order> orders = new ArrayList<>();

	public User() {
	}

	public User(String name, String email, String phone, String password) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;
		return id.equals(user.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
