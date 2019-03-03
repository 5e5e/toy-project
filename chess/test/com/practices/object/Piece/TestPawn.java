package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPawn {
	private static Logger logger = LoggerFactory.getLogger(TestPawn.class);
	private Piece whitePawn;
	private Piece blackPawn;
	private Board board;
	private Piece piece;

	@BeforeEach
	public void setup() {
		whitePawn = Pawn.createWhitePawn();
		blackPawn = Pawn.createBlackPawn();
		board = new Board();
	}

	@Test
	public void createWhitePawn() {
		assertEquals(whitePawn, Pawn.create(Color.WHITE));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackPawn, Pawn.create(Color.BLACK));
	}

	@Test
	public void calculatePoint() {
		board.createEmptyBoard();
		board.replacePiece(Pawn.create(Color.WHITE, new Position("a1")));
		board.replacePiece(Pawn.create(Color.BLACK, new Position("a2")));
		board.replacePiece(Pawn.create(Color.WHITE, new Position("a3")));
		board.replacePiece(Pawn.create(Color.WHITE, new Position("a4")));
		board.replacePiece(Pawn.create(Color.BLACK, new Position("a5")));
		board.replacePiece(Pawn.create(Color.BLACK, new Position("a6")));
		board.replacePiece(Pawn.create(Color.WHITE, new Position("a7")));
		board.replacePiece(Pawn.create(Color.WHITE, new Position("a8")));
		logger.debug(board.result());
		double whitePieces = board.whitePieceCalculation();
		double blackPieces = board.blackPieceCalculation();
		assertEquals(2.5, whitePieces, 0.01);
		assertEquals(1.5, blackPieces, 0.01);

	}

	@Test
	public void validMove() {
		board.create();
		piece = board.findPiece("e1");
		logger.debug(piece.moveList(new Position("e1")) + "");

	}
}
