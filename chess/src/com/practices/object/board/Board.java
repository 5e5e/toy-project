package com.practices.object.board;

import com.practices.object.Piece.Piece;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private static final Logger logger = LoggerFactory.getLogger(Board.class);
	private List<Rank> ranks = new ArrayList<>();

	public Board() {
		create();
	}

	public List<Rank> create() {
		ranks.add(Rank.createWhiteOthersPiecesRank());
		ranks.add(Rank.createWhitePawnRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlackPawnRank());
		ranks.add(Rank.createBlackOthersPiecesRank());
		return ranks;
	}

	public String result() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("  abcdefgh ");
		stringBuilder.append("\n");
		for (int i = ranks.size() - 1; i >= 0; i--) {
			stringBuilder.append((i + 1) + " " + ranks.get(i).result() + " " + (i + 1));
			stringBuilder.append("\n");
		}
		stringBuilder.append("  abcdefgh ");
		return stringBuilder.toString();
	}

	public Piece findPiece(String position) {
		int x = (position.charAt(0) - 'a' + 1) - 1;
		int y = Character.getNumericValue(position.charAt(1)) - 1;
		Rank rank = ranks.get(y);
		return rank.findPiece(x);
	}

	public void move(String departure, String arrive) {
		Piece departurePiece = getPiece(departure);
		departurePiece.locatePosition(arrive);
		setPiece(arrive, departurePiece);
	}

	private Piece getPiece(String departure) {
		int x = (departure.charAt(0) - 'a' + 1) - 1;
		int y = Character.getNumericValue(departure.charAt(1)) - 1;
		Rank rank = ranks.get(y);
		return rank.getPiece(x);
	}

	private void setPiece(String arrive, Piece departurePiece) {
		int x = (arrive.charAt(0) - 'a' + 1) - 1;
		int y = Character.getNumericValue(arrive.charAt(1)) - 1;
		Rank rank = ranks.get(y);
		rank.setPiece(x, departurePiece);
	}

	public List<Piece> findWhitePiece() {
		List<Piece> whitePieces = new ArrayList<>();
		for (Rank ranks : ranks) {
			whitePieces.addAll(ranks.findWhitePieces());
		}
//		logger.debug("whitePieces : " + whitePieces);
		return whitePieces;
	}

	public List<Piece> findBlackPiece() {
		List<Piece> blackPieces = new ArrayList<>();
		for (Rank ranks : ranks) {
			blackPieces.addAll(ranks.findBlackPieces());
		}
//		logger.debug("blackPieces : " + blackPieces);
		return blackPieces;
	}

	public double whitePieceCalculation() {
		List<Piece> pieces = findWhitePiece();
//		logger.info(pieces+"");
		double result = 0;
		for (Piece piece : pieces) {
			result += piece.getPoint(pieces);
		}
		return result;
	}

	public double blackPieceCalculation() {
		List<Piece> pieces = findBlackPiece();
		double result = 0;
		for (Piece piece : pieces) {
			result += piece.getPoint(pieces);
		}
		return result;
	}
}
