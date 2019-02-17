package com.practices.Object;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Rook extends Piece {
	private final static String WHITEROOK = "r";
	private final static String BLACKROOK = "R";

	private Rook() {

	}

	private Rook(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals("white") || color.equals("black"))
			return color.equals("white") ? new Rook("white", WHITEROOK) : new Rook("black", BLACKROOK);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteRook() {
		return new Rook("white", WHITEROOK);
	}

	public static Piece createBlackRook() {
		return new Rook("black", BLACKROOK);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals("r") || piece.equals("R"))
			if (color.equals("white") || color.equals("black")) {
				return color.equals("white") ? new Rook("white", WHITEROOK) : new Rook("black", BLACKROOK);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("룩 기물만 생성할 수 있습니다");
	}
}
