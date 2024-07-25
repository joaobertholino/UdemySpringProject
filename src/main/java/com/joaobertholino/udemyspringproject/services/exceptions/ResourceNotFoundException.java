package com.joaobertholino.udemyspringproject.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public <T> ResourceNotFoundException(T id) {
		super("Resource not found. Id " + id);
	}
}
