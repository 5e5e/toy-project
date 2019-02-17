package com.practices.object.board;

import com.practices.object.Piece.*;

import java.util.ArrayList;
import java.util.List;

public class Rank {
	private List<Piece> pieces = new ArrayList<>();

	public Rank() {

	}

	public List<Piece> createWhitePawnRank() {
		for (int i = 0; i < 8; i++) {
			pieces.add(Pawn.createWhitePawn());
		}
		return pieces;
	}

	public String result() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Piece index : pieces) {
			stringBuilder.append(index.presentation());
		}
		return stringBuilder.toString();
	}

	public List<Piece> createWhiteOthersPiecesRank() {
		pieces.add(Rook.createWhiteRook());
		pieces.add(Knight.createWhiteKnight());
		pieces.add(Bishop.createWhiteBishop());
		pieces.add(Queen.createWhiteQueen());
		pieces.add(King.createWhiteKing());
		pieces.add(Bishop.createWhiteBishop());
		pieces.add(Knight.createWhiteKnight());
		pieces.add(Rook.createWhiteRook());
		return pieces;
	}

	public List<Piece> createBlackPawnRank() {
		for (int i = 0; i < 8; i++) {
			pieces.add(Pawn.createBlackPawn());
		}
		return pieces;
	}

	public List<Piece> createBlackOthersPiecesRank() {
		pieces.add(Rook.createBlackRook());
		pieces.add(Knight.createBlackKnight());
		pieces.add(Bishop.createBlackBishop());
		pieces.add(Queen.createBlackQueen());
		pieces.add(King.createBlackKing());
		pieces.add(Bishop.createBlackBishop());
		pieces.add(Knight.createBlackKnight());
		pieces.add(Rook.createBlackRook());
		return pieces;
	}

	public List<Piece> createBlankRank() {
		for (int i = 0; i < 8; i++) {
			pieces.add(Blank.create());
		}
		return pieces;
	}
}
