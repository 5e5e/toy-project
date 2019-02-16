package com.practices.Object;

public class Blank extends Piece {
	public Blank() {
		super(" ");
	}

	public static Piece create() {
		return new Blank();
	}
}
