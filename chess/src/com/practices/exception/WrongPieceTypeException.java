package com.practices.exception;

public class WrongPieceTypeException extends RuntimeException {
	public WrongPieceTypeException(String message) {
		super(message);
	}
}
