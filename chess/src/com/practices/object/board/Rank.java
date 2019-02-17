package com.practices.object.board;

import com.practices.object.Piece.*;

import java.util.ArrayList;
import java.util.List;

public class Rank {
	private List<Piece> pieces = new ArrayList<>();

	private Rank() {

	}

	public static Rank createWhiteOthersPiecesRank() {
		Rank rank = new Rank();
		rank.add(Rook.createWhiteRook());
		rank.add(Knight.createWhiteKnight());
		rank.add(Bishop.createWhiteBishop());
		rank.add(Queen.createWhiteQueen());
		rank.add(King.createWhiteKing());
		rank.add(Bishop.createWhiteBishop());
		rank.add(Knight.createWhiteKnight());
		rank.add(Rook.createWhiteRook());
		return rank;
	}

	public static Rank createBlackOthersPiecesRank() {
		Rank rank = new Rank();
		rank.add(Rook.createBlackRook());
		rank.add(Knight.createBlackKnight());
		rank.add(Bishop.createBlackBishop());
		rank.add(Queen.createBlackQueen());
		rank.add(King.createBlackKing());
		rank.add(Bishop.createBlackBishop());
		rank.add(Knight.createBlackKnight());
		rank.add(Rook.createBlackRook());
		return rank;
	}

	public static Rank createWhitePawnRank() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.add(Pawn.createWhitePawn());
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
			rank.add(Pawn.createBlackPawn());
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
}
