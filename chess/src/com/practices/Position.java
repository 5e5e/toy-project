package com.practices;

import com.practices.exception.WrongPositionException;

public class Position {
	private int X;
	private int Y;

	public Position(int x, int y) {
		if ((x < 0 || x > 8) || (y < 0 || y > 8))
			throw new WrongPositionException("x 또는 y가 유효한 값이 아닙니다.");
		this.X = x;
		this.Y = y;
	}

	public Position(String a2) {
	}
}
