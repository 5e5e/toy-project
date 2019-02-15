package com.practices.Object;

import com.practices.exception.WrongPieceException;

import java.util.Objects;

public class Piece {
	private String piece;

	public Piece(String piece) {
		if (!piece.equals(" "))
			throw new WrongPieceException("잘못된 블랭크 요청입니다.");
	}

	public Piece() {

	}

	public Piece makeBlank() {
		return new Piece(" ");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Piece)) return false;
		Piece piece1 = (Piece) o;
		return Objects.equals(piece, piece1.piece);
	}

	@Override
	public int hashCode() {
		return Objects.hash(piece);
	}

	public Piece makePiece(String piece) {
		return new Piece(piece);
	}
}
