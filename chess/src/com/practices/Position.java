package com.practices;

import com.practices.exception.IllegalParameterExcpetion;
import com.practices.exception.WrongPositionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.practices.object.Piece.Bishop.isBishop;
import static com.practices.object.Piece.Blank.isNoColor;
import static com.practices.object.Piece.King.isKing;
import static com.practices.object.Piece.Knight.isKnight;
import static com.practices.object.Piece.Pawn.isPawn;
import static com.practices.object.Piece.Piece.isWhite;
import static com.practices.object.Piece.Queen.isQueen;
import static com.practices.object.Piece.Rook.isRook;

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

	public static List<Position> getWhitePawnPosition(Position position) {
		List<Direction> directions = Direction.getWhitePawnPosition();
		List<Position> positions = getPositions(position, directions);
		return positions;
	}

	private static List<Position> getPositions(Position position, List<Direction> directions) {
		List<Position> positions = new ArrayList<>();
		for (Direction direction : directions) {
			positions.add(direction.create(position.x, position.y));
		}
		return positions;
	}

	public static List<Position> getPosition(Color color, Type type, Position position) {
		if (isNoColor(color)) throw new WrongPositionException("빈칸은 움직일수 없습니다.");
		return isWhite(color) ? getWhitePosition(type, position) : getBlackPosition(type, position);
	}

	private static List<Position> getWhitePosition(Type type, Position position) {
		if (isPawn(type)) return getWhitePawnPosition(position);
		else if (isKnight(type)) return getKnightPosition(position);
		else if (isRook(type)) return getRookPosition(position);
		else if (isBishop(type)) return getBishopPosition(position);
		else if (isQueen(type)) return getQueenPosition(position);
		else if (isKing(type)) return getKingPosition(position);
		throw new IllegalParameterExcpetion("잘못된 매개 변수 요청입니다.");
	}

	private static List<Position> getKingPosition(Position position) {
		List<Direction> directions = Direction.getKingPosition();
		List<Position> positions = getPositions(position, directions);
		return positions;
	}

	private static List<Position> getQueenPosition(Position position) {
		List<Position> positions = new ArrayList<>();
		positions.addAll(getRookPosition(position));
		positions.addAll(getBishopPosition(position));
		logger.debug("position : " + positions);
		return positions;
	}

	private static List<Position> getBishopPosition(Position position) {
		List<Direction> directions = Direction.getBishopPosition();
		List<Position> positions = new ArrayList<>();
		int x = 0;
		for (int j = position.y; j < position.max; j++) {
			positions.add(directions.get(0).create(position.x + x, j));
			x += 1;
		}
		x = 0;
		for (int j = position.y; j >= position.min; j--) {
			positions.add(directions.get(1).create(position.x + x, j));
			x += 1;
		}
		x = 0;
		for (int j = position.y; j >= position.min; j--) {
			positions.add(directions.get(2).create(position.x + x, j));
			x -= 1;
		}
		x = 0;
		for (int j = position.y; j < position.max; j++) {
			positions.add(directions.get(3).create(position.x + x, j));
			x -= 1;
		}
		return positions;
	}

	private static List<Position> getRookPosition(Position position) {
		List<Direction> directions = Direction.getRookPosition();
		List<Position> positions = new ArrayList<>();
		for (int j = position.y; j > position.min; j--) {
			positions.add(directions.get(1).create(position.x, j));
		}
		for (int j = position.y; j < position.max; j++) {
			positions.add(directions.get(0).create(position.x, j));
		}
		for (int j = position.x; j > position.min; j--) {
			positions.add(directions.get(2).create(j, position.y));
		}
		for (int j = position.x; j < position.max; j++) {
			positions.add(directions.get(3).create(j, position.y));
		}
		return positions;
	}

	private static List<Position> getKnightPosition(Position position) {
		List<Direction> directions = Direction.getKnightPosition();
		List<Position> positions = getPositions(position, directions);
		return positions;
	}

	private static List<Position> getBlackPosition(Type type, Position position) {
		if (isPawn(type)) return getBlackPawnPosition(position);
		else if (isKnight(type)) return getKnightPosition(position);
		else if (isRook(type)) return getRookPosition(position);
		else if (isBishop(type)) return getBishopPosition(position);
		else if (isQueen(type)) return getQueenPosition(position);
		else if (isKing(type)) return getKingPosition(position);
		throw new IllegalParameterExcpetion("잘못된 매개 변수 요청입니다.");
	}

	private static List<Position> getBlackPawnPosition(Position position) {
		List<Direction> directions = Direction.getBlackPawnPosition();
		List<Position> positions = getPositions(position, directions);
		return positions;
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

}
