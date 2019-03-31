package com.practices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

	NORTH(0, 1), NORTH_EAST(1, 1), EAST(1, 0), SOUTH_EAST(1, -1), SOUTH(0, -1),
	SOUTH_WEST(-1, -1), WEST(-1, 0), NORTH_WEST(-1, 1), NORTH_NORTH_EAST(1, 2),
	NORTH_NORTH_WEST(-1, 2), EAST_EAST_NORTH(2, 1), EAST_EAST_SOUTH(2, -1),
	SOUTH_SOUTH_EAST(1, -2), SOUTH_SOUTH_WEST(-1, -2), WEST_WEST_NORTH(-2, 1),
	WEST_WEST_SOUTH(-2, -1), NORTH_NORTH(0, 2), SOUTH_SOUTH(0, -2);
	private static final Logger logger = LoggerFactory.getLogger(Direction.class);
	private int x;
	private int y;

	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public static Map<Direction, Direction> getKnightPosition() {
		Map<Direction, Direction> directions = new HashMap<>();
		addKnight(directions);
		return directions;

	}

	private static void addKnight(Map<Direction, Direction> directions) {
		directions.put(NORTH_NORTH_WEST, NORTH_NORTH_WEST);
		directions.put(NORTH_NORTH_EAST, NORTH_NORTH_EAST);
		directions.put(EAST_EAST_NORTH, EAST_EAST_NORTH);
		directions.put(EAST_EAST_SOUTH, EAST_EAST_SOUTH);
		directions.put(SOUTH_SOUTH_EAST, SOUTH_SOUTH_EAST);
		directions.put(SOUTH_SOUTH_WEST, SOUTH_SOUTH_WEST);
		directions.put(WEST_WEST_NORTH, WEST_WEST_NORTH);
		directions.put(WEST_WEST_SOUTH, WEST_WEST_SOUTH);
	}


	public static Direction calculateRoute(Position start, Position end) {

		int x = end.getX() - start.getX();
		int y = end.getY() - start.getY();
		if (x == 0) {
			return y > 0 ? NORTH : SOUTH;
		}
		if (y == 0) {
			return x > 0 ? EAST : WEST;
		}
		if (y / x == 1) {
			return end.getX() > start.getX() ? NORTH_EAST : SOUTH_WEST;
		}
		if (y / x == -1) {
			return end.getX() > start.getX() ? SOUTH_EAST : NORTH_WEST;
		}
		if (y == 2) {
			if (x == -1) return NORTH_NORTH_WEST;
			else if (x == 1) return NORTH_NORTH_EAST;
		}

		if (y == -2) {
			if (x == -1) return SOUTH_SOUTH_WEST;
			else if (x == 1) return SOUTH_SOUTH_EAST;
		}

		if (x == 2) {
			if (y == 1) return EAST_EAST_NORTH;
			else if (y == -1) return EAST_EAST_SOUTH;
		}
		if (x == -2) {
			if (y == 1) return WEST_WEST_NORTH;
			else if (y == -1) return WEST_WEST_SOUTH;
		}
		throw new IllegalArgumentException("message");
	}

	public static Map<Direction, Direction> getDiagonal() {
		Map<Direction, Direction> diagonal = new HashMap<>();
		addDiagonal(diagonal);
		return diagonal;
	}

	private static void addDiagonal(Map<Direction, Direction> diagonal) {
		diagonal.put(NORTH_WEST, NORTH_WEST);
		diagonal.put(NORTH_EAST, NORTH_EAST);
		diagonal.put(SOUTH_WEST, SOUTH_WEST);
		diagonal.put(SOUTH_EAST, SOUTH_EAST);
	}

	public static Map<Direction, Direction> get8Way() {
		Map<Direction, Direction> diagonal = new HashMap<>();
		addDiagonal(diagonal);
		addUpDownLeftRight(diagonal);
		return diagonal;
	}

	private static void addUpDownLeftRight(Map<Direction, Direction> diagonal) {
		diagonal.put(Direction.NORTH, Direction.NORTH);
		diagonal.put(Direction.SOUTH, Direction.SOUTH);
		diagonal.put(Direction.EAST, Direction.EAST);
		diagonal.put(Direction.WEST, Direction.WEST);
	}

	public static Map<Direction, Direction> getPawnDirection(Color color) {
		return Color.WHITE.equals(color) ? getWhitePawnDirection() : getBlackPawnDirection();
	}

	private static Map<Direction, Direction> getBlackPawnDirection() {
		Map<Direction, Direction> directions = new HashMap<>();
		addBlackPawn(directions);
		return directions;
	}

	private static void addBlackPawn(Map<Direction, Direction> directions) {
		directions.put(SOUTH_SOUTH, SOUTH_SOUTH);
		directions.put(SOUTH, SOUTH);
		directions.put(SOUTH_WEST, SOUTH_WEST);
		directions.put(SOUTH_EAST, SOUTH_EAST);
	}

	private static Map<Direction, Direction> getWhitePawnDirection() {
		Map<Direction, Direction> directions = new HashMap<>();
		addWhitePawn(directions);
		return directions;
	}

	private static void addWhitePawn(Map<Direction, Direction> directions) {
		directions.put(NORTH_NORTH, NORTH_NORTH);
		directions.put(NORTH, NORTH);
		directions.put(NORTH_WEST, NORTH_WEST);
		directions.put(NORTH_EAST, NORTH_EAST);
	}

	public static Map<Direction, Direction> getUpDownLeftRight() {
		Map<Direction, Direction> directions = new HashMap<>();
		directions.put(NORTH, NORTH);
		directions.put(SOUTH, SOUTH);
		directions.put(WEST, WEST);
		directions.put(EAST, EAST);
		return directions;
	}

	public Position create(int x, int y) {
		int finalX = x + this.x;
		int finalY = y + this.y;
		if ((finalX >= 0 && finalX < 8) && (finalY >= 0 && finalY < 8))
			return new Position(finalX, finalY);
		return null;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
