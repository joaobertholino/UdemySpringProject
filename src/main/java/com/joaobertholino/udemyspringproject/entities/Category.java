package com.joaobertholino.udemyspringproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Category category = (Category) o;
		return id.equals(category.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
