package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Direction;
import com.practices.Position;
import com.practices.Type;

import java.util.Map;

public class Knight extends Piece {


	private Knight(Color color, Type type, Position position, Map<Direction, Direction> direction) {
		super(color, type, position, direction);
	}


	public static Piece create(Color color, Position position) {
		return new Knight(color, Type.KNIGHT, position, Direction.getKnightPosition());
	}

}
