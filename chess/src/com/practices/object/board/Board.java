package com.practices.object.board;

import com.practices.Direction;
import com.practices.Position;
import com.practices.grobal.Manager;
import com.practices.object.Piece.Piece;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private static final Logger logger = LoggerFactory.getLogger(Board.class);
	private List<Rank> ranks = new ArrayList<>();

	public Board() {
	}

	public void create() {
		ranks.add(Rank.createWhiteOthersPiecesRank());
		ranks.add(Rank.createWhitePawnRank());
		ranks.add(Rank.createBlankLine(2));
		ranks.add(Rank.createBlankLine(3));
		ranks.add(Rank.createBlankLine(4));
		ranks.add(Rank.createBlankLine(5));
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
		Position p = new Position(position);
		int x = p.getX();
		int y = p.getY();
		Rank rank = ranks.get(y);
		return rank.findPiece(x);
	}

	public boolean move(String departure, String arrive, boolean turn) {
		Piece departurePiece = findPiece(departure);
		if (turn == true) {
			if (!departurePiece.isWhite()) throw new IllegalArgumentException("흰색 차례입니다.");
		} else if (turn == false) {
			if (departurePiece.isWhite()) throw new IllegalArgumentException("검은색 턴 입니다.");
		}
		Piece arrivePiece = findPiece(arrive);
		Direction direction = departurePiece.validDirection(arrivePiece);
		Position next = new Position(departure, direction);
		Piece nextPiece = findPiece(next);
		while (true) {
			if (!nextPiece.isBlank()) throw new IllegalArgumentException("빈칸이 아닌 곳으로 움직을수 없습니다.");
			if (nextPiece.samePosition(arrivePiece)) break;
			next = new Position(next, direction);
			logger.debug("next : " +next);
			nextPiece = findPiece(next);
		}
		setPiece(arrive, departurePiece);
		setBlank(departure);
		departurePiece.increaseMoveCount();
		return !turn;
	}

	private Piece findPiece(Position next) {
		Rank rank = ranks.get(next.getY());
		return rank.findPiece(next.getX());
	}

	private void setBlank(String departure) {
		Position position = new Position(departure);
		int x = position.getX();
		int y = position.getY();
		Rank rank = ranks.get(y);
		rank.setBlank(x, y);
	}

	private void setPiece(String arrive, Piece departurePiece) {
		Position position = new Position(arrive);
		int x = position.getX();
		int y = position.getY();
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

	public void toMap() {
		for (Rank i : ranks) {
			for (Piece j : i.getPiece()) {
				if (!j.isBlank())
					Manager.chessMap.put(j.getPosition(), j);
			}
		}
	}
}
