package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public abstract class Piece {
	private static final Logger logger = LoggerFactory.getLogger(Piece.class);
	private Color color;
	private Type type;
	private Position position;
	private double score;

	public Piece() {

	}

	public Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
		this.score = type.getScore();
	}

	public Piece(Color color, Type type, Position position) {
		this.color = color;
		this.type = type;
		this.position = position;
		this.score = type.getScore();
	}

	public static boolean isBlack(Color color) {
		return color.equals(Color.BLACK);
	}

	public static boolean isWhite(Color color) {
		return color.equals(Color.WHITE);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Piece)) return false;
		Piece piece = (Piece) o;
		return color == piece.color &&
				type == piece.type &&
				Objects.equals(position, piece.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, type, position);
	}

	public String presentation() {
		return isWhite() ? this.type.getWhiteType() : this.type.getBlackType();
	}

	public boolean isWhite() {
		return Color.WHITE.equals(this.color);
	}


	public boolean isBlack() {
		return Color.BLACK.equals(this.color);
	}

	public boolean isPawn() {
		return this.type.equals(Type.PAWN);
	}

	public double getPoint(List<Piece> pieces) {
		if (!isPawn()) {
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

	@Override
	public String toString() {
		return "Piece{" +
				"type=" + type +
				", position=" + position +
				'}';
	}

	public void locatePosition(String arrive) {
		this.position.setPosition(arrive);
	}

	public boolean move(Position position) {
		List<Position> positionList = Position.getPosition(color, type, this.position);
		logger.debug("이동할 수 있는 위치 : " + positionList);
		return positionList.contains(position);
	}

	public Position getPosition() {
		return position;
	}
}
