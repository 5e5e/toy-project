package com.practices;

import com.practices.exception.WrongPositionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Position {
	private static final Logger logger = LoggerFactory.getLogger(Position.class);
	private final int minX = 0;
	private final int maxX = 7;
	private final int minY = 0;
	private final int maxY = 7;
	private int X;
	private int Y;

	public Position(String position) {
		this.X = convertX(position);
		this.Y = convertY(position);
	}

	private int convertY(String position) {
		int y = Character.getNumericValue(position.charAt(1)) - 1;
		if ((y < minY || y > maxY))
			throw new WrongPositionException("x 또는 y가 유효한 값이 아닙니다.");
		return y;
	}

	private int convertX(String position) {
		int x = (position.charAt(0) - 'a' + 1) - 1;
		if ((x < minX || x > maxX))
			throw new WrongPositionException("x 또는 y가 유효한 값이 아닙니다.");
		return x;
	}
}
