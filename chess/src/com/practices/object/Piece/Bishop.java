package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Direction;
import com.practices.Position;
import com.practices.Type;

import java.util.Map;

public class Bishop extends Piece {
	private Bishop(Color color, Type bishop, Position position, Map<Direction, Direction> directions) {
		super(color, bishop, position, directions);
	}


	public static Piece create(Color color, Position position) {
		return new Bishop(color, Type.BISHOP, position, Direction.getDiagonal());
	}

}
