package com.practices.Object;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class King extends Piece {
	private final static String WHITEKING = "k";
	private final static String BLACKKING = "K";

	private King() {

	}

	private King(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals("white") || color.equals("black"))
			return color.equals("white") ? new King("white", WHITEKING) : new King("black", BLACKKING);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteKing() {
		return new King("white", WHITEKING);
	}

	public static Piece createBlackKing() {
		return new King("black", BLACKKING);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals(WHITEKING) || piece.equals(BLACKKING))
			if (color.equals("white") || color.equals("black")) {
				return color.equals("white") ? new King("white", WHITEKING) : new King("black", BLACKKING);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("킹 기물만 생성할 수 있습니다");
	}
}
