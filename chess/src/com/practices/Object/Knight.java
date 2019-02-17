package com.practices.Object;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Knight extends Piece {

	private final static String WHITEKNIGHT = "n";
	private final static String BLACKKNIGHT = "N";

	private Knight() {

	}

	private Knight(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals("white") || color.equals("black"))
			return color.equals("white") ? new Knight("white", WHITEKNIGHT) : new Knight("black", BLACKKNIGHT);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteKnight() {
		return new Knight("white", WHITEKNIGHT);
	}

	public static Piece createBlackKnight() {
		return new Knight("black", BLACKKNIGHT);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals("r") || piece.equals("R"))
			if (color.equals("white") || color.equals("black")) {
				return color.equals("white") ? new Knight("white", WHITEKNIGHT) : new Knight("black", BLACKKNIGHT);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("나이트 기물만 생성할 수 있습니다");
	}
}
