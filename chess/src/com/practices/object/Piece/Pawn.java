package com.practices.object.Piece;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Pawn extends Piece {
	private final static String white = "white";
	private final static String black = "black";
	private final static String whitePawn = "p";
	private final static String blackPawn = "P";

	private Pawn() {

	}

	private Pawn(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals(white) || color.equals(black))
			return color.equals(white) ? new Pawn(white, whitePawn) : new Pawn(black, blackPawn);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhitePawn() {
		return new Pawn(white, whitePawn);
	}

	public static Piece createBlackPawn() {
		return new Pawn(black, blackPawn);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals(whitePawn) || piece.equals(blackPawn))
			if (color.equals(white) || color.equals(black)) {
				return color.equals(white) ? new Pawn(white, whitePawn) : new Pawn(black, blackPawn);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("폰 기물만 생성할 수 있습니다");
	}
}
