package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

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
		board.create();
		piece = board.findPiece("f1");
		assertEquals(piece, Bishop.create(Color.WHITE, new Position("f1")));
	}

	@Test
	public void createBlackBishop() {
		board.create();
		piece = board.findPiece("f8");
		assertEquals(piece, Bishop.create(Color.BLACK, new Position("f8")));
	}

	@Test
	void validDirection() {
		board.createEmptyBoard();
		board.replacePiece(Bishop.create(Color.BLACK, new Position("a1")));
		piece = board.findPiece("a1");
		Piece target = board.findPiece("h8");
		assertTrue(piece.validDirection(target));
	}

	@Test
	void invalidDirection() {
		board.createEmptyBoard();
		board.replacePiece(Bishop.create(Color.BLACK, new Position("a1")));
		piece = board.findPiece("a1");
		Piece target = board.findPiece("a8");
		assertFalse(piece.validDirection(target));
	}
}
