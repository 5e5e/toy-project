package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestKnight {
	private static final Logger logger = LoggerFactory.getLogger(TestKnight.class);
	private Board board;
	private Piece piece;

	@Test
	public void createWhiteKnight() {
		board.create();
		piece = board.findPiece("b1");
		assertEquals(piece, Knight.create(Color.WHITE, new Position("b1")));
	}

	@Test
	public void createBlackKnight() {
		board.create();
		piece = board.findPiece("b8");
		assertEquals(piece, Knight.create(Color.BLACK, new Position("b8")));
	}

	@BeforeEach
	public void setup() {
		board = new Board();
	}


}
