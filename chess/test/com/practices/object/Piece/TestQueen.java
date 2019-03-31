package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestQueen {
	private static final Logger logger = LoggerFactory.getLogger(TestQueen.class);
	private Board board;
	private Piece piece;

	@Test
	public void createWhiteTestQueen() {
		board.create();
		piece = board.findPiece("d1");
		assertEquals(piece, Queen.create(Color.WHITE, new Position("d1")));
	}

	@Test
	public void createBlackTestQueen() {
		board.create();
		piece = board.findPiece("d8");
		assertEquals(piece, Queen.create(Color.BLACK, new Position("d8")));
	}

	@BeforeEach
	public void setup() {
		board = new Board();
	}


}
