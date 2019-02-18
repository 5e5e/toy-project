package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Pawn extends Piece {
	private Pawn() {

	}

	private Pawn(Color color, Type type) {
		super(color, type);
	}

	private Pawn(Color color, Type type, Position position) {
		super(color, type, position);
	}

	public static Piece create(Color color) {
		if (isWhite(color) || isBlack(color))
			return isWhite(color) ? new Pawn(Color.WHITE, Type.PAWN) : new Pawn(Color.BLACK, Type.PAWN);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}


	public static Piece createWhitePawn() {
		return new Pawn(Color.WHITE, Type.PAWN);
	}

	public static Piece createBlackPawn() {
		return new Pawn(Color.BLACK, Type.PAWN);
	}

	public static Piece create(Color color, Type type) {
		if (!isPawn(type)) throw new WrongPieceTypeException("폰 기물만 생성할 수 있습니다");
		return create(color);
	}

	private static boolean isPawn(Type type) {
		return Type.PAWN.equals(type);
	}


	public static Piece createWhitePawn(Position position) {
		return new Pawn(Color.WHITE, Type.PAWN, position);
	}
}
