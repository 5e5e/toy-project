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
	private Board board;

	@BeforeEach
	public void setUp() {
		board = new Board();
		board.create();
	}

	@Test
	public void whitePiecePoint() {
		double point = board.whitePieceCalculation();
		assertEquals(38, point);

	}

	@Test
	public void blackPiecePoint() {
		double point = board.blackPieceCalculation();
		assertEquals(38, point);
	}

	@Test
	public void duplicatePawnPoint() {
		board.move("b2", "a3");
		board.move("c2", "d3");
		board.move("d3", "c4");
		logger.debug(board.result());
		double whitePieces = board.whitePieceCalculation();
		double blackPieces = board.blackPieceCalculation();
		assertEquals(37, whitePieces, 0.01);
		assertEquals(38, blackPieces, 0.01);
	}
}
