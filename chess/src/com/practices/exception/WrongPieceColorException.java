package com.practices.exception;

public class WrongPieceColorException extends RuntimeException {
	public WrongPieceColorException(String message) {
		super(message);
	}
}
