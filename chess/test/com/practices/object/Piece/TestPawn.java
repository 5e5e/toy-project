package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestPawn {
	private static Logger logger = LoggerFactory.getLogger(TestPawn.class);
	private Board board;
	private Piece piece;

	@BeforeEach
	public void setup() {

		board = new Board();
	}

	@Test
	public void createWhitePawn() {
		board.create();
		piece = board.findPiece("a2");
		assertEquals(piece, Pawn.create(Color.WHITE, new Position("a2")));
	}

	@Test
	public void createBlackPawn() {

		board.create();
		piece = board.findPiece("a7");
		assertEquals(piece, Pawn.create(Color.BLACK, new Position("a7")));
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




}
