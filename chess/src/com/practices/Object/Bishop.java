package com.practices.Object;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Bishop extends Piece {
	private final static String WHITEBISHOPP = "b";
	private final static String BLACKKBUSHOP = "B";

	private Bishop() {

	}

	private Bishop(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals("white") || color.equals("black"))
			return color.equals("white") ? new Bishop("white", WHITEBISHOPP) : new Bishop("black", BLACKKBUSHOP);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteBishop() {
		return new Bishop("white", WHITEBISHOPP);
	}

	public static Piece createBlackBishop() {
		return new Bishop("black", BLACKKBUSHOP);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals("r") || piece.equals("R"))
			if (color.equals("white") || color.equals("black")) {
				return color.equals("white") ? new Bishop("white", WHITEBISHOPP) : new Bishop("black", BLACKKBUSHOP);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("비숍 기물만 생성할 수 있습니다");
	}
}
