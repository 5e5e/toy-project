package com.practices.object.Piece;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Knight extends Piece {
	private final static String white = "white";
	private final static String black = "black";
	private final static String whiteKnight = "n";
	private final static String blackKnight = "N";

	private Knight() {

	}

	private Knight(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals(white) || color.equals(black))
			return color.equals(white) ? new Knight(white, whiteKnight) : new Knight(black, blackKnight);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteKnight() {
		return new Knight(white, whiteKnight);
	}

	public static Piece createBlackKnight() {
		return new Knight(black, blackKnight);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals(whiteKnight) || piece.equals(blackKnight))
			if (color.equals(white) || color.equals(black)) {
				return color.equals(white) ? new Knight(white, whiteKnight) : new Knight(black, blackKnight);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("나이트 기물만 생성할 수 있습니다");
	}
}
