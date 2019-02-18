package com.practices.object.Piece;

import com.practices.Position;
import com.practices.exception.WrongPieceException;

import java.util.Objects;

public abstract class Piece {
	private final String blank = " ";
	private String color;
	private String piece;
	private Position position;

	public Piece() {

	}

	public Piece(String piece) {
		if (!blank.equals(piece))
			throw new WrongPieceException("잘못된 생성 요청입니다.");

		this.piece = piece;
	}

	public Piece(String color, String piece) {
		this.color = color;
		this.piece = piece;
	}

	public Piece(String color, String piece, Position position) {
		this.color = color;
		this.piece = piece;
		this.position = position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Piece)) return false;
		Piece piece1 = (Piece) o;
		return Objects.equals(color, piece1.color) &&
				Objects.equals(piece, piece1.piece) &&
				Objects.equals(position, piece1.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, piece, position);
	}

	@Override
	public String toString() {
		return "Piece{" +
				"piece='" + piece + '\'' +
				'}';
	}

	public String presentation() {
		return piece;
	}

	public void move(String position) {

	}

	public void move(String arrive, Piece arrivePiece) {
	}

	;
}
