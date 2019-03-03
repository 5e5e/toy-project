package com.practices.object.board;

import com.practices.Position;
import com.practices.object.Piece.Piece;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
	private static final Logger logger = LoggerFactory.getLogger(Board.class);
	private List<Rank> ranks = new ArrayList<>();
	private Map<Position, Piece> positionPieceMap = new HashMap<>();

	public Board() {
	}

	public void create() {
		ranks.add(Rank.createWhiteOthersPiecesRank());
		ranks.add(Rank.createWhitePawnRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlackPawnRank());
		ranks.add(Rank.createBlackOthersPiecesRank());
	}

	public String result() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
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
		if (departurePiece.move(new Position(arrive))) {
			departurePiece.locatePosition(arrive);
			setPiece(arrive, departurePiece);
			setBlank(departure);
		}
	}

	private void setBlank(String departure) {
		int x = (departure.charAt(0) - 'a' + 1) - 1;
		int y = Character.getNumericValue(departure.charAt(1)) - 1;
		Rank rank = ranks.get(y);
		rank.setBlank(x);
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
		return whitePieces;
	}

	public List<Piece> findBlackPiece() {
		List<Piece> blackPieces = new ArrayList<>();
		for (Rank ranks : ranks) {
			blackPieces.addAll(ranks.findBlackPieces());
		}
		return blackPieces;
	}

	public double whitePieceCalculation() {
		List<Piece> pieces = findWhitePiece();
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


	public void createEmptyBoard() {
		for (int i = 0; i < 8; i++)
			ranks.add(Rank.createBlankLine(i));
	}

	public void replacePiece(Piece piece) {
		Position arrive = piece.getPosition();
		ranks.get(arrive.getY()).setPiece(arrive.getX(), piece);
		}
}
