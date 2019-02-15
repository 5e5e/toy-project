package com.practices.exception;

public class WrongPieceException extends RuntimeException {
	public WrongPieceException(String message) {
		super(message);
	}
}
