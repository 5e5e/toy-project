package com.practices.object.board;

import com.practices.object.Piece.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Rank {
	private static final Logger logger = LoggerFactory.getLogger(Rank.class);
	private List<Piece> pieces = new ArrayList<>();
	private List<Piece> temps = new ArrayList<>();

	private Rank() {

	}

	public static Rank createWhiteOthersPiecesRank() {
		Rank rank = new Rank();
		rank.add(Rook.createWhiteRook("a1"));
		rank.add(Knight.createWhiteKnight("b1"));
		rank.add(Bishop.createWhiteBishop("c1"));
		rank.add(Queen.createWhiteQueen("d1"));
		rank.add(King.createWhiteKing("e1"));
		rank.add(Bishop.createWhiteBishop("f1"));
		rank.add(Knight.createWhiteKnight("g1"));
		rank.add(Rook.createWhiteRook("h1"));
		return rank;
	}

	public static Rank createBlackOthersPiecesRank() {
		Rank rank = new Rank();
		rank.add(Rook.createBlackRook("a8"));
		rank.add(Knight.createBlackKnight("b8"));
		rank.add(Bishop.createBlackBishop("c8"));
		rank.add(Queen.createBlackQueen("d8"));
		rank.add(King.createBlackKing("e8"));
		rank.add(Bishop.createBlackBishop("f8"));
		rank.add(Knight.createBlackKnight("g8"));
		rank.add(Rook.createBlackRook("h8"));
		return rank;
	}

	public static Rank createWhitePawnRank() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.add(Pawn.createWhitePawn(i));
		}
		return rank;
	}

	public static Rank createBlankRank() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.add(Blank.create());
		}
		return rank;
	}

	public static Rank createBlackPawnRank() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.add(Pawn.createBlackPawn(i));
		}
		return rank;
	}

	public String result() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Piece index : pieces) {
			stringBuilder.append(index.presentation());
		}
		return stringBuilder.toString();
	}

	private void add(Piece piece) {
		pieces.add(piece);
	}

	public Piece getPiece(int index) {
//		Piece temp = pieces.get(index);

		return pieces.get(index);
	}

	public Piece findPiece(int index) {
		return pieces.get(index);
	}

	public void setPiece(int index, Piece departurePiece) {
		pieces.set(index, departurePiece);
	}

	public List<Piece> findWhitePieces() {
		temps.clear();
		for (Piece piece : pieces) {
			if (piece.isWhite()) {
				temps.add(piece);
			}
		}
		return temps;
	}

	public List<Piece> findBlackPieces() {
		temps.clear();
		for (Piece piece : pieces) {
			if (piece.isBlack()) {
				temps.add(piece);
			}
		}
		return temps;
	}

	public void setBlank(int index) {
		pieces.set(index, Blank.create());
	}

	public List<Piece> getPieces() {
		return pieces;
	}
}