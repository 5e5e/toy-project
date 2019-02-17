package com.practices.object.Piece;

public class Blank extends Piece {
	private Blank() {
		super(" ");
	}

	public static Piece create() {
		return new Blank();
	}
}
