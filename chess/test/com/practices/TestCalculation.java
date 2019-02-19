package com.practices;

import com.practices.object.Piece.Piece;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculation {
	private static final Logger logger = LoggerFactory.getLogger(TestCalculation.class);
	private Calculation calculation;
	private Board board;

	@BeforeEach
	public void setUp() {
		board = new Board();
		calculation = new Calculation();
	}

	@Test
	public void whitePiecePoint() {
		double point = calculation.whitePieceCalculation(board.findBlackPiece());
		assertEquals(38, point);

	}

	@Test
	public void blackPiecePoint() {
		double point = calculation.blackPieceCalculation(board.findWhitePiece());
		assertEquals(38, point);
	}

	@Test
	public void duplicatePawnPoint() {
		board.move("b2", "a3");
		board.move("c2", "a4");
		board.move("d2", "a5");
		board.move("e2", "a6");
		board.move("f2", "a7");
		board.move("g2", "a8");
		logger.debug(board.result());
		double whitePieces = board.whitePieceCalculation();
//		double blackPieces = board.blackPieceCalculation();
		assertEquals(34.5, whitePieces, 0.01);
//		assertEquals(32, blackPieces, 0.01);
	}
}
