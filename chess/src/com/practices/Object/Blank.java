package com.practices.Object;

public class Blank extends Piece {
	private Blank() {
		super(" ");
	}

	public static Piece create() {
		return new Blank();
	}
}
