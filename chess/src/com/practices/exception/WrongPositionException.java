package com.practices.exception;

public class WrongPositionException extends RuntimeException {
	public WrongPositionException(String message) {
		super(message);
	}
}
