package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRook {
	private static final Logger logger = LoggerFactory.getLogger(TestRook.class);

	private Board board;
	private Piece piece;

	@Test
	public void createWhiteRook() {
		board.create();
		piece = board.findPiece("a1");
		assertEquals(piece, Rook.create(Color.WHITE, new Position("a1")));
	}

	@Test
	public void createBlackPawn() {
		board.create();
		piece = board.findPiece("a8");
		assertEquals(piece, Rook.create(Color.BLACK, new Position("a8")));
	}


	@BeforeEach
	public void setup() {
		board = new Board();
	}

	@Test
	public void validDirection() {
		board.create();
		piece = board.findPiece("h1");
		Piece target = board.findPiece("a1");
		assertTrue(piece.validDirection(target));
	}
}
