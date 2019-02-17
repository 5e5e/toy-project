package com.practices.Object;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Queen extends Piece {
	private final static String WHITEBISHOPP = "q";
	private final static String BLACKKBUSHOP = "Q";

	private Queen() {

	}

	private Queen(String color, String piece) {
		super(color, piece);
	}

	public static Piece create(String color) {
		if (color.equals("white") || color.equals("black"))
			return color.equals("white") ? new Queen("white", WHITEBISHOPP) : new Queen("black", BLACKKBUSHOP);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteQueen() {
		return new Queen("white", WHITEBISHOPP);
	}

	public static Piece createBlackQueen() {
		return new Queen("black", BLACKKBUSHOP);
	}

	public static Piece create(String color, String piece) {
		if (piece.equals(WHITEBISHOPP) || piece.equals(BLACKKBUSHOP))
			if (color.equals("white") || color.equals("black")) {
				return color.equals("white") ? new Queen("white", WHITEBISHOPP) : new Queen("black", BLACKKBUSHOP);
			} else {
				throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
			}
		throw new WrongPieceTypeException("퀸 기물만 생성할 수 있습니다");
	}
}
