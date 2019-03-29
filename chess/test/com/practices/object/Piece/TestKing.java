package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestKing {
	private static final Logger logger = LoggerFactory.getLogger(TestKing.class);
	private Board board;
	private Piece piece;

	@BeforeEach
	public void setup() {
		board = new Board();
	}

	@Test
	public void createWhiteTestKing() {
		board.create();
		piece = board.findPiece("e1");
		assertEquals(piece, King.create(Color.WHITE, new Position("e1")));
	}

	@Test
	public void createBlackKing() {
		board.create();
		piece = board.findPiece("e8");
		assertEquals(piece, King.create(Color.BLACK, new Position("e8")));	}


	@Test
	public void validDirection() {
		board.create();
		piece = board.findPiece("e1");
		Piece target = board.findPiece("e2");
		assertTrue(piece.validDirection(target));
	}
}
