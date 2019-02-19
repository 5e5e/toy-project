package com.practices;

import com.practices.object.Piece.*;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMove {
	private static final Logger logger = LoggerFactory.getLogger(TestMove.class);
	private Board board;

	@BeforeEach
	public void setup() {
		board = new Board();
	}

	@Test
	public void movePawn() {
		board.move("a2", "a4");
		Piece blank = board.findPiece("a2");
		Piece whitePawn = board.findPiece("a4");
		assertEquals(Pawn.createWhitePawn(new Position("a4")), whitePawn);
		assertEquals(Blank.create(), blank);
	}

	@Test
	public void moveKnight() {
		board.move("b1", "a3");
		Piece blank = board.findPiece("b1");
		Piece whiteKnight = board.findPiece("a3");
		assertEquals(Knight.createWhiteKnight("a3"), whiteKnight);
		assertEquals(Blank.create(), blank);
	}

	@Test
	public void moveRook() {
		board.move("a1", "a8");
		Piece blank = board.findPiece("a1");
		Piece whiteRook = board.findPiece("a8");
		assertEquals(Rook.createWhiteRook("a8"), whiteRook);
		assertEquals(Blank.create(), blank);
	}

	@Test
	public void moveBishop() {
		board.move("c1", "c6");
		Piece blank = board.findPiece("c1");
		Piece whiteBishop = board.findPiece("c6");
		assertEquals(Bishop.createWhiteBishop("c6"), whiteBishop);
		assertEquals(Blank.create(), blank);
		board.move("f1", "f6");
		Piece blank2 = board.findPiece("f1");
		Piece whiteBishop2 = board.findPiece("f6");
		assertEquals(Bishop.createWhiteBishop("f6"), whiteBishop2);
		assertEquals(Blank.create(), blank2);
	}

	@Test
	public void moveQueen() {
		board.move("d1", "d5");
		Piece blank = board.findPiece("d1");
		Piece whiteQueen = board.findPiece("d5");
		assertEquals(Queen.createWhiteQueen("d5"), whiteQueen);
		assertEquals(Blank.create(), blank);
	}

	@Test
	public void moveKing() {
		board.move("e1", "e2");
		Piece blank = board.findPiece("e1");
		Piece whiteKing = board.findPiece("e2");
		assertEquals(King.createWhiteKing("e2"), whiteKing);
		assertEquals(Blank.create(), blank);
	}
}
