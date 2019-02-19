package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Knight extends Piece {
	private Knight() {

	}

	private Knight(Color color, Type type) {
		super(color, type);
	}

	public Knight(Color color , Type knight, Position position) {
		super(color,knight,position);
	}

	public static Piece create(Color color) {
		if (isWhite(color) || isBlack(color))
			return isWhite(color) ? new Knight(Color.WHITE, Type.KNIGHT) : new Knight(Color.BLACK, Type.KNIGHT);
		throw new WrongPieceColorException("하얀색 또는 검은색 기물만 생성할 수 있습니다");
	}

	public static Piece createWhiteKnight() {
		return new Knight(Color.WHITE, Type.KNIGHT);
	}

	public static Piece createBlackKnight() {
		return new Knight(Color.BLACK, Type.KNIGHT);
	}

	public static Piece create(Color color, Type type) {
		if (!isKnight(type)) throw new WrongPieceTypeException("나이트 기물만 생성할 수 있습니다");
		return create(color);
	}

	private static boolean isKnight(Type type) {
		return Type.KNIGHT.equals(type);
	}

	public static Piece createWhiteKnight(String position) {
		return new Knight(Color.WHITE,Type.KNIGHT, new Position(position));
	}

	public static Piece createBlackKnight(String b8) {
		return new Knight(Color.BLACK,Type.KNIGHT, new Position(b8));

	}
}
