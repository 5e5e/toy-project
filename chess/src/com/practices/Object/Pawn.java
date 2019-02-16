package com.practices.Object;

import com.practices.exception.WrongPieceException;

public class Pawn extends Piece {
	public Pawn() {

	}

	private Pawn(String color, String piece) {
		super(color, piece);
	}


	public static Piece create() {
		return new Pawn();
	}

	public static Piece create(String color) {
		if (color.equals("white") || color.equals("black"))
			return color.equals("white") ? new Pawn(color, "p") : new Pawn(color, "P");
		throw new WrongPieceException("폰 기물만 생성할 수 있습니다");
	}

	public static Piece createWhite() {
		return create("white");
	}

	public static Piece createBlack() {
		return create("black");
	}
}
