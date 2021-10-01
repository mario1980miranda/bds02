package com.devsuperior.bds02.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4230324034094037101L;

	public ResourceNotFoundException(final String msg) {
		super(msg);
	}
}
