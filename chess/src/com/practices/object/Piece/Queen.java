package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Queen extends Piece {
	private Queen() {

	}

	private Queen(Color color, Type type) {
		super(color, type);
	}

	public Queen(Color color , Type queen, Position position) {
		super(color, queen, position);
	}

	public static Piece create(Color color) {
		if (isWhite(color) || isBlack(color))
			return isWhite(color) ? new Queen(Color.WHITE, Type.QUEEN) : new Queen(Color.BLACK, Type.QUEEN);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteQueen() {
		return new Queen(Color.WHITE, Type.QUEEN);
	}

	public static Piece createBlackQueen() {
		return new Queen(Color.BLACK, Type.QUEEN);
	}

	public static Piece create(Color color, Type type) {
		if (!isQueen(type)) throw new WrongPieceTypeException("퀸 기물만 생성할 수 있습니다");
		return create(color);
	}

	public static boolean isQueen(Type type) {
		return Type.QUEEN.equals(type);
	}

	public static Piece createWhiteQueen(String a4) {
		return new Queen(Color.WHITE, Type.QUEEN, new Position(a4));
	}

	public static Piece createBlackQueen(String d8) {
		return new Queen(Color.BLACK, Type.QUEEN, new Position(d8));

	}
}
