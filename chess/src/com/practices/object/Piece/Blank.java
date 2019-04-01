package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;

import java.util.HashMap;

public class Blank extends Piece {
	private Blank() {
		super(Color.NO_COLOR, Type.BLANK);
	}

	private Blank(int x, int y) {
		super(Color.NO_COLOR, Type.BLANK, new Position(x, y), new HashMap<>());
	}

	public static Piece create() {
		return new Blank();
	}


	public static Piece create(int x, int y) {
		return new Blank(x, y);
	}
}
