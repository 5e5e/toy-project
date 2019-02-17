package com.practices.object.Piece;

import com.practices.exception.WrongPieceException;

import java.util.Objects;

public abstract class Piece {
	private final String blank = " ";
	private String color;
	private String piece;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Piece)) return false;
		Piece piece1 = (Piece) o;
		return Objects.equals(color, piece1.color) &&
				Objects.equals(piece, piece1.piece);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, piece);
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
}
