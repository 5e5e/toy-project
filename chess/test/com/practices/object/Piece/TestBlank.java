package com.practices.object.Piece;

import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestBlank {
	private static Logger logger = LoggerFactory.getLogger(TestBlank.class);
	private Board board;
	private Piece blank;

	@BeforeEach
	void setUp() {
		board = new Board();
	}

	@Test
	public void create() {
		board.createEmptyBoard();
		blank = board.findPiece("a1");
		assertEquals(blank, Blank.create(0,0));
	}

	@Test
	void invalidDirection() {
		board.createEmptyBoard();
		blank = board.findPiece("a1");
		Piece target  = board.findPiece("a2");
		assertFalse(blank.validDirection(target));
	}
}
