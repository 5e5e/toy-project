package com.practices.object.board;

import com.practices.Color;
import com.practices.Position;
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
		rank.add(Rook.create(Color.WHITE,new Position("a1")));
		rank.add(Knight.create(Color.WHITE, new Position("b1")));
		rank.add(Bishop.create(Color.WHITE, new Position("c1")));
		rank.add(Queen.create(Color.WHITE, new Position("d1")));
		rank.add(King.create(Color.WHITE, new Position("e1")));
		rank.add(Bishop.create(Color.WHITE, new Position("f1")));
		rank.add(Knight.create(Color.WHITE, new Position("g1")));
		rank.add(Rook.create(Color.WHITE,new Position("h1")));
		return rank;
	}

	public static Rank createBlackOthersPiecesRank() {
		Rank rank = new Rank();
		rank.add(Rook.create(Color.BLACK,new Position("a8")));
		rank.add(Knight.create(Color.BLACK, new Position("b8")));
		rank.add(Bishop.create(Color.BLACK, new Position("c8")));
		rank.add(Queen.create(Color.BLACK, new Position("d8")));
		rank.add(King.create(Color.BLACK, new Position("e8")));
		rank.add(Bishop.create(Color.BLACK, new Position("f8")));
		rank.add(Knight.create(Color.BLACK, new Position("g8")));
		rank.add(Rook.create(Color.BLACK,new Position("h8")));
		return rank;
	}

	public static Rank createWhitePawnRank() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.add(Pawn.create(Color.WHITE, new Position(i, 1)));
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
			rank.add(Pawn.create(Color.BLACK, new Position(i, 6)));
		}
		return rank;
	}

	public static Rank createBlankLine(int y) {
		Rank rank = new Rank();
		for (int x = 0; x < 8; x++) {
			rank.add(Blank.create(x, y));
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
			if (!piece.isWhite()) {
				temps.add(piece);
			}
		}
		return temps;
	}

	public void setBlank(int index) {
		pieces.set(index, Blank.create());
	}

	public List<Piece> getPiece() {
		return pieces;
	}
}