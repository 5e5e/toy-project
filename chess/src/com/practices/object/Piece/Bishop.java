package com.practices.object.Piece;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Bishop extends Piece {
	private final static String white = "white";
	private final static String black = "black";
	private final static String whiteBishop = "b";
	private final static String blackBishop = "B";

	private Bishop() {

	}

	private Bishop(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals(white) || color.equals(black))
			return color.equals(white) ? new Bishop(white, whiteBishop) : new Bishop(black, blackBishop);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteBishop() {
		return new Bishop(white, whiteBishop);
	}

	public static Piece createBlackBishop() {
		return new Bishop(black, blackBishop);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals(whiteBishop) || piece.equals(blackBishop))
			if (color.equals(white) || color.equals(black)) {
				return color.equals(white) ? new Bishop(white, whiteBishop) : new Bishop(black, blackBishop);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("비숍 기물만 생성할 수 있습니다");
	}
}
