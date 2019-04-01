package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Direction;
import com.practices.Position;
import com.practices.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Pawn extends Piece {
	private static final Logger logger = LoggerFactory.getLogger(Pawn.class);

	private Pawn(Color color, Type type, Position position, Map<Direction, Direction> directions) {
		super(color, type, position, directions);
	}


	public static Piece create(Color color, Position position) {
		return new Pawn(color, Type.PAWN, position, Direction.getPawnDirection(color));
	}

	@Override
	public Direction validDirection(Piece target) {
		int count = super.getMoveCount();
		logger.debug("count : " +count);
		Direction direction = super.validDirection(target);

		if (count != 0) {
			if(direction.equals(Direction.NORTH_NORTH) || direction.equals(Direction.SOUTH_SOUTH)) throw new IllegalArgumentException("");
		}
		logger.debug("direction : " +direction);
		return direction;
	}
}
