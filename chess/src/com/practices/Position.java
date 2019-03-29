package com.practices;

import com.practices.exception.WrongPositionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position {
	private static final Logger logger = LoggerFactory.getLogger(Position.class);
	private final int min = 0;
	private final int max = 8;
	private int x;
	private int y;


	public Position(String position) {
		this.x = convertX(position);
		this.y = convertY(position);
	}

	public Position(int x, int y) {

		this.x = x;
		this.y = y;

	}

	private int convertY(String position) {
		int y = Character.getNumericValue(position.charAt(1)) - 1;
		if (!validY(y))
			throw new WrongPositionException("x 또는 y가 유효한 값이 아닙니다.");
		return y;
	}

	private boolean validY(int y) {
		return (y >= min) && (y < max);
	}

	private int convertX(String position) {
		int x = (position.charAt(0) - 'a' + 1) - 1;
		if (!validX(x))
			throw new WrongPositionException("x 또는 y가 유효한 값이 아닙니다.");
		return x;
	}

	private boolean validX(int x) {
		return x >= min && x < max;
	}

	public List<Position> getYPosition() {
		List<Position> prePositions = new ArrayList<>();
		List<Position> postPositions = new ArrayList<>();
		for (int i = 0; i < this.y; i++) {
			prePositions.add(new Position(this.x, i));
		}
		for (int i = this.y + 1; i < 8; i++) {
			postPositions.add(new Position(this.x, i));
		}
		prePositions.addAll(postPositions);
		return prePositions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Position)) return false;
		Position position = (Position) o;
		return x == position.x &&
				y == position.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return "Position{" +
				"x=" + x +
				", y=" + y +
				'}';
	}

	public void setPosition(String arrive) {
		this.x = convertX(arrive);
		this.y = convertY(arrive);
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
}
