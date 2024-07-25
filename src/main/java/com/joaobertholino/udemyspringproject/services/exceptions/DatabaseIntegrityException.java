package com.joaobertholino.udemyspringproject.services.exceptions;

public class DatabaseIntegrityException extends RuntimeException {
	public <T> DatabaseIntegrityException(T id) {
		super("Relational integrity error with the database when trying to delete a record with the given id. Id: " + id);
	}
}
