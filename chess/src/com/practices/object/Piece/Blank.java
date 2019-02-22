package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;

public class Blank extends Piece {
	private Blank() {
		super(Color.NO_COLOR, Type.BLANK);
	}

	public static Piece create() {
		return new Blank();
	}

	public static Piece create(Color color, Type type) {
		if (!isBlank(type)) throw new WrongPieceTypeException("블랭크 타입만 생성할 수 있습니다.");
		return create(color);
	}

	private static Piece create(Color color) {
		if (!isNoColor(color)) throw new WrongPieceColorException("색깔 없음");
		return create();
	}

	public static boolean isNoColor(Color color) {
		return Color.NO_COLOR.equals(color);
	}

	private static boolean isBlank(Type type) {
		return Type.BLANK.equals(type);
	}
}
