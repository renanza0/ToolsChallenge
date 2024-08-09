package com.toolschallenge.exception;

public class TransacaoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TransacaoNotFoundException(String message) {
        super(message);
    }
}