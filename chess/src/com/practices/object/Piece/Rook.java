package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Rook extends Piece {
	private Rook() {

	}

	private Rook(Color color, Type type) {
		super(color, type);
	}

	public Rook(Color color, Type rook, Position position) {
		super(color, rook, position);
	}

	public static Piece create(Color color) {
		if (isWhite(color) || isBlack(color))
			return isWhite(color) ? new Rook(Color.WHITE, Type.ROOK) : new Rook(Color.BLACK, Type.ROOK);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteRook() {
		return new Rook(Color.WHITE, Type.ROOK);
	}

	public static Piece createBlackRook() {
		return new Rook(Color.BLACK, Type.ROOK);
	}

	public static Piece create(Color color, Type type) {
		if (!isRook(type)) throw new WrongPieceTypeException("룩 기물만 생성할 수 있습니다");
		return create(color);
	}

	private static boolean isRook(Type type) {
		return Type.ROOK.equals(type);
	}

	public static Piece createWhiteRook(String position) {
		return new Rook(Color.WHITE, Type.ROOK, new Position(position));
	}

	public static Piece createBlackRook(String a8) {
		return new Rook(Color.BLACK, Type.ROOK, new Position(a8));

	}
}
