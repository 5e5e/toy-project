package com.practices.Object;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Rook extends Piece {
	private final static String white = "white";
	private final static String black = "black";
	private final static String whiteRook = "r";
	private final static String blackRook = "R";

	private Rook() {

	}

	private Rook(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals(white) || color.equals(black))
			return color.equals(white) ? new Rook(white, whiteRook) : new Rook(black, blackRook);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteRook() {
		return new Rook(white, whiteRook);
	}

	public static Piece createBlackRook() {
		return new Rook(black, blackRook);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals(whiteRook) || piece.equals(blackRook))
			if (color.equals(white) || color.equals(black)) {
				return color.equals(white) ? new Rook(white, whiteRook) : new Rook(black, blackRook);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("룩 기물만 생성할 수 있습니다");
	}
}
