package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBishop {
	private static final Logger logger = LoggerFactory.getLogger(TestBishop.class);
	private Board board;
	private Piece piece;

	@BeforeEach
	public void setup() {
		board = new Board();
	}

	@Test
	public void createWhiteBishop() {
		piece = board.findPiece("f1");
		assertEquals(piece, Bishop.create(Color.WHITE, new Position("f1")));
	}

	@Test
	public void createBlackBishop() {
		piece = board.findPiece("f8");
		assertEquals(piece, Bishop.create(Color.BLACK, new Position("f8")));
	}

	@Test
	public void validMove() {
		piece = board.findPiece("f1");

	}

	@Test
	public void validMoveOpponent() {

	}

	@Test
	public void invalidMoveWrongPosition() {

	}

	@Test
	public void invalidMoveSameColor() {

	}

	@Test
	public void moveWarning() {
		// 차후
	}
}
