package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class King extends Piece {
	private final static String white = "white";
	private final static String black = "black";
	private final static String whiteKing = "k";
	private final static String blackKing = "K";

	private King() {

	}

	private King(Color color, Type type) {
		super(color, type);
	}

	public static Piece create(Color color) {
		if (isWhite(color) || isBlack(color))
			return isWhite(color) ? new King(Color.WHITE, Type.KING) : new King(Color.BLACK, Type.KING);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteKing() {
		return new King(Color.WHITE, Type.KING);
	}

	public static Piece createBlackKing() {
		return new King(Color.BLACK, Type.KING);
	}

	public static Piece create(Color color, Type type) {
		if (!isKing(type)) throw new WrongPieceTypeException("킹 기물만 생성할 수 있습니다");
		return create(color);
	}

	private static boolean isKing(Type type) {
		return Type.KING.equals(type);
	}
}
