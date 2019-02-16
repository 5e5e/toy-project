package com.practices.Object;

import com.practices.exception.WrongPieceException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Piece {
	private final String blank = " ";
	private final List<String> whitePieces = Arrays.asList("p", "n", "r", "b", "q", "k");
	private final List<String> blackPieces = Arrays.asList("P", "N", "R", "B", "Q", "K");
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
		if (color.equals("white")) {
			if (!whitePieces.contains(piece))
				throw new WrongPieceException("하얀색 기물만 생성할 수 있습니다.");
			this.color = color;
			this.piece = piece;
		} else {
			if (!blackPieces.contains(piece))
				throw new WrongPieceException("검은색 기물만 생성할 수 있습니다.");
			this.color = color;
			this.piece = piece;
		}
	}

	public Piece makeBlank() {
		return new Piece(" ");
	}

	public Piece makePiece(String piece) {
		return new Piece(piece);
	}

	public Piece makeWhitePawn() {
		return new Piece("white", "p");
	}

	public Piece makeWhitePawn(String piece) {
		return new Piece("white", piece);
	}

	public Piece makeWhiteRook() {
		return new Piece("white", "r");
	}

	public Piece makeWhiteRook(String piece) {
		return new Piece("white", piece);

	}

	public Piece makeWhiteKnight() {
		return new Piece("white", "n");
	}

	public Piece makeWhiteKnight(String piece) {
		return new Piece("white", piece);
	}

	public Piece makeWhiteBishop() {
		return new Piece("white", "b");
	}

	public Piece makeWhiteBishop(String piece) {
		return new Piece("white", piece);
	}

	public Piece makeWhiteQueen() {
		return new Piece("white", "q");
	}

	public Piece makeWhiteQueen(String piece) {
		return new Piece("white", piece);
	}

	public Piece makeWhiteKing() {
		return new Piece("white", "k");
	}

	public Piece makeWhiteKing(String piece) {
		return new Piece("white", piece);
	}

	public Piece makeBlackPawn() {
		return new Piece("black", "P");
	}

	public Piece makeBlackPawn(String piece) {
		return new Piece("black", piece);
	}

	public Piece makeBlackRook() {
		return new Piece("black", "R");
	}

	public Piece makeBlackRook(String piece) {
		return new Piece("black", piece);

	}

	public Piece makeBlackKnight() {
		return new Piece("black", "N");
	}

	public Piece makeBlackKnight(String n) {
		return new Piece("black", piece);
	}

	public Piece makeBlackBishop() {
		return new Piece("black", "B");
	}

	public Piece makeBlackBishop(String piece) {
		return new Piece("black", piece);
	}

	public Piece makeBlackQueen() {
		return new Piece("black", "Q");
	}

	public Piece makeBlackQueen(String piece) {
		return new Piece("black", piece);
	}

	public Piece makeBlackKing() {
		return new Piece("black", "K");
	}

	public Piece makeBlackKing(String piece) {
		return new Piece("black", piece);
	}

	public String getPiece() {
		return piece;
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
}
