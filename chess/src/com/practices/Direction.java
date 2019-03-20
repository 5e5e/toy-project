package com.practices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public enum Direction {

	NORTH(0, 1), NORTH_EAST(1, 1), EAST(1, 0), SOUTH_EAST(1, -1), SOUTH(0, -1),
	SOUTH_WEST(-1, -1), WEST(-1, 0), NORTH_WEST(-1, 1), NORTH_NORTH_EAST(1, 2),
	NORTH_NORTH_WEST(-1, 2), EAST_EAST_NORTH(2, 1), EAST_EAST_SOUTH(2, -1),
	SOUTH_SOUTH_EAST(1, -2), SOUTH_SOUTH_WEST(-1, -2), WEST_WEST_NORTH(-2, 1),
	WEST_WEST_SOUTH(-2, -1);
	private static final Logger logger = LoggerFactory.getLogger(Direction.class);
	private int x;
	private int y;

	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static List<Direction> getWhitePawnPosition() {
		return Arrays.asList(NORTH, NORTH_EAST, NORTH_WEST);
	}

	public static List<Direction> getKnightPosition() {
		return Arrays.asList(NORTH_NORTH_EAST, NORTH_NORTH_WEST, EAST_EAST_NORTH, EAST_EAST_SOUTH, SOUTH_SOUTH_EAST
				, SOUTH_SOUTH_WEST, WEST_WEST_NORTH, WEST_WEST_SOUTH);
	}

	public static List<Direction> getRookPosition() {
		return Arrays.asList(NORTH, SOUTH, WEST, EAST);
	}

	public static List<Direction> getBishopPosition() {
		return Arrays.asList(NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST);
	}

	public static List<Direction> getKingPosition() {
		return Arrays.asList(NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST);

	}

	public static List<Direction> getBlackPawnPosition() {
		return Arrays.asList(SOUTH, SOUTH_EAST, SOUTH_WEST);
	}

	public static Direction decide(String departure, String arrive) {
		Position arrivePosition = new Position(arrive);
		Position departurePosition = new Position(departure);
		int gapX = arrivePosition.getX() - departurePosition.getX();
		int gapY = arrivePosition.getY() - departurePosition.getY();
		if (gapX == 0) {
			return gapY > 0 ? NORTH : SOUTH;
		}
		if (gapY == 0) {
			return gapX > 0 ? EAST : WEST;
		}
		if (gapY / gapX == 1) {
			return gapX + gapY > 0 ? NORTH_EAST : SOUTH_WEST;
		}
		if (gapY / gapX == -1) {
			return gapX > 0 ? SOUTH_EAST : NORTH_WEST;
		}
		throw new IllegalArgumentException("message");
	}

	public Position create(int x, int y) {
		int finalX = x + this.x;
		int finalY = y + this.y;
		if ((finalX >= 0 && finalX < 8) && (finalY >= 0 && finalY < 8))
			return new Position(finalX, finalY);
		return null;
	}
}
