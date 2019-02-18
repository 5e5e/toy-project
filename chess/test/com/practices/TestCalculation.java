package com.practices;

import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		double point = calculation.whitePieceCalculation(board);
		assertEquals(38, point);

	}

	@Test
	public void blackPiecePoint() {
		double point = calculation.blackPieceCalculation(board);
		assertEquals(38, point);
	}
}
