package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Direction;
import com.practices.Position;
import com.practices.Type;

import java.util.Map;

public class Rook extends Piece {
	private Rook(Color color, Type type, Position position, Map<Direction, Direction> directions) {
		super(color, type, position, directions);
	}


	public static Piece create(Color color, Position position) {
		return new Rook(color, Type.ROOK, position, Direction.getUpDownLeftRight());
	}


}
