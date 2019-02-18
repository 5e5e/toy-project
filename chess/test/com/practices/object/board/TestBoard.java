package com.practices.object.board;

import com.practices.object.Piece.Pawn;
import com.practices.object.Piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoard {
	private static final Logger logger = LoggerFactory.getLogger(TestBoard.class);
	private Board board;

	@BeforeEach
	public void setUp() {
		board = new Board();
	}

	@Test
	public void create() {
		assertEquals("  abcdefgh " + "\n" + "8 PPPPPPPP 8" + "\n" + "7 RNBQKBNR 7" + "\n"
				+ "6          6" + "\n" + "5          5" + "\n" + "4          4" + "\n" +
				"3          3" + "\n" + "2 pppppppp 2" + "\n" + "1 rnbqkbnr 1" + "\n"
				+ "  abcdefgh ", board.result());
	}

	@Test
	public void findPiece() {
		Piece newPiece = board.findPiece("a2");
		assertEquals(Pawn.createWhitePawn(), newPiece);
	}

}
