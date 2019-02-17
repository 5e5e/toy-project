package com.practices.Object;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class King extends Piece {
	private final static String white = "white";
	private final static String black = "black";
	private final static String whiteKing = "k";
	private final static String blackKing = "K";

	private King() {

	}

	private King(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals(white) || color.equals(black))
			return color.equals(white) ? new King(white, whiteKing) : new King(black, blackKing);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteKing() {
		return new King(white, whiteKing);
	}

	public static Piece createBlackKing() {
		return new King(black, blackKing);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals(whiteKing) || piece.equals(blackKing))
			if (color.equals(white) || color.equals("black")) {
				return color.equals(white) ? new King(white, whiteKing) : new King(black, blackKing);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("킹 기물만 생성할 수 있습니다");
	}
}
