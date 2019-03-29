package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Direction;
import com.practices.Position;
import com.practices.Type;

import java.util.Map;

public class King extends Piece {

	private King(Color color, Type king, Position position, Map<Direction, Direction> directions) {
		super(color, king, position, directions);
	}

	public static Piece create(Color color, Position position) {
		return new King(color, Type.KING, position, Direction.get8Way());
	}

}

