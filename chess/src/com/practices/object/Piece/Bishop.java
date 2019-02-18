package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Bishop extends Piece {
	private Bishop() {

	}

	private Bishop(Color color, Type type) {
		super(color, type);
	}

	public static Piece create(Color color) {
		if (isWhite(color) || isBlack(color))
			return isWhite(color) ? new Bishop(Color.WHITE, Type.BISHOP) : new Bishop(Color.BLACK, Type.BISHOP);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteBishop() {
		return new Bishop(Color.WHITE, Type.BISHOP);
	}

	public static Piece createBlackBishop() {
		return new Bishop(Color.BLACK, Type.BISHOP);
	}

	public static Piece create(Color color, Type type) {
		if (!isBishop(type)) throw new WrongPieceTypeException("비숍 기물만 생성할 수 있습니다");
		return create(color);
	}

	private static boolean isBishop(Type type) {
		return Type.BISHOP.equals(type);
	}
}
