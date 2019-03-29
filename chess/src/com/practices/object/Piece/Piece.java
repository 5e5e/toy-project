package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Direction;
import com.practices.Position;
import com.practices.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Piece {
	private static final Logger logger = LoggerFactory.getLogger(Piece.class);
	private Map<Direction, Direction> directions;
	private Color color;
	private Type type;
	private Position position;
	private double score;
	private int moveCount;

	public Piece() {

	}

	public Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
		this.score = type.getScore();
	}

	public Piece(Color color, Type type, Position position, Map<Direction, Direction> directions) {
		this.color = color;
		this.type = type;
		this.position = position;
		this.directions = directions;
		this.score = type.getScore();
	}

	public String presentation() {
		return isWhite() ? this.type.getWhiteType() : this.type.getBlackType();
	}

	public boolean isWhite() {
		return Color.WHITE.equals(this.color);
	}


	private boolean isPawn() {
		return this.type.equals(Type.PAWN);
	}

	public double getPoint(List<Piece> pieces) {
		if (! isPawn()) {
			return this.score;
		}
		List<Position> positions = this.position.getYPosition();
		for (Position position : positions) {
			if (pieces.contains(Pawn.create(this.color, position))) {
				return this.score - 0.5;
			}
		}
		return this.score;
	}

	public void locatePosition(String arrive) {
		this.position.setPosition(arrive);
	}

//	public boolean move(Position position) {
//		List<Position> positionList = Position.getPosition(color, type, this.position);
//		for (Iterator<Position> it = positionList.iterator(); it.hasNext(); ) {
//			Position value = it.next();
//
//			try {
//				if (value.equals(null)) {
//				}
//			} catch (NullPointerException e) {
//				it.remove();
//			}
//		}
//		return positionList.contains(position);
//	}

	public Position getPosition() {
		return position;
	}

	public boolean isBlank() {
		return this.type.equals(Type.BLANK);
	}


	public boolean validMove(Piece target) {
		Direction direction = Direction.calculateRoute(this.position, target.position);
		if (!directions.containsKey(direction)) {
			return false;
		}
		return directions.containsKey(direction);
	}

	public boolean validDirection(Piece target) {
		Direction direction = Direction.calculateRoute(this.position, target.position);
		return directions.containsKey(direction);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Piece)) return false;
		Piece piece = (Piece) o;
		return Double.compare(piece.score, score) == 0 &&
				directions.equals(piece.directions) &&
				color == piece.color &&
				type == piece.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(directions, color, type, score);
	}

	@Override
	public String toString() {
		return "Piece{" +
				"directions=" + directions +
				", color=" + color +
				", type=" + type +
				", position=" + position +
				", score=" + score +
				", moveCount=" + moveCount +
				'}';
	}
}
