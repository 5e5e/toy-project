package com.practices.Object;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Queen extends Piece {
	private final static String white = "white";
	private final static String black = "black";
	private final static String whiteQueen = "q";
	private final static String blackQueen = "Q";

	private Queen() {

	}

	private Queen(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals(white) || color.equals(black))
			return color.equals(white) ? new Queen(white, whiteQueen) : new Queen(black, blackQueen);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteQueen() {
		return new Queen(white, whiteQueen);
	}

	public static Piece createBlackQueen() {
		return new Queen(black, blackQueen);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals(whiteQueen) || piece.equals(blackQueen))
			if (color.equals(white) || color.equals(black)) {
				return color.equals(white) ? new Queen(white, whiteQueen) : new Queen(black, blackQueen);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("퀸 기물만 생성할 수 있습니다");
	}
}
