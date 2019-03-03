package com.practices;

import com.practices.object.Piece.*;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestMove {
	private static final Logger logger = LoggerFactory.getLogger(TestMove.class);
	private Board board;
	@BeforeEach
	public void setUp() {
		board = new Board();
		board.create();
	}

	@Test
	public void movePawn() {
		Piece whitePawn = Pawn.createWhitePawn(new Position("a2"));
		assertTrue(whitePawn.move(new Position("a3")));
	}

	@Test
	public void movePawnFalse() {
		Piece whitePawn = Pawn.createWhitePawn(new Position("a2"));
		assertFalse(whitePawn.move(new Position("b2")));
	}

	@Test
	public void moveKnight() {
		Piece whiteKnight = Knight.createWhiteKnight("a8");
		assertTrue(whiteKnight.move(new Position("c7")));
	}

	@Test void moveKnightFalse() {
		Piece whiteKnight = Knight.createWhiteKnight("a8");
		assertFalse(whiteKnight.move(new Position("a7")));
	}

	@Test
	public void moveRook() {
		Piece whiteRook = Rook.createWhiteRook("a1");
		assertTrue(whiteRook.move(new Position("a8")));
	}

	@Test
	public void moveRookFalse() {
		Piece whiteRook = Rook.createWhiteRook("a1");
		assertFalse(whiteRook.move(new Position("b2")));
	}

	@Test
	public void moveBishop() {
		Piece whiteBishop = Bishop.createWhiteBishop("d5");
		assertTrue(whiteBishop.move(new Position("e4")));
	}@Test
	public void moveBishopFalse() {
		Piece whiteBishop = Bishop.createWhiteBishop("c1");
		assertFalse(whiteBishop.move(new Position("e5")));
	}

	@Test
	public void moveQueen() {
		Piece whiteQueen = Queen.createWhiteQueen("d8");
		assertTrue(whiteQueen.move(new Position("h8")));
	}

	@Test
	public void moveQueenFalse() {
		Piece whiteQueen = Queen.createWhiteQueen("c1");
		assertFalse(whiteQueen.move(new Position("e6")));
	}

	@Test
	public void moveKing() {
		Piece whiteKing = King.createWhiteKing("d5");
		assertTrue(whiteKing.move(new Position("c4")));
	}

	@Test
	public void moveKingFalse() {
		Piece whiteKing = King.createWhiteKing("c1");
		assertFalse(whiteKing.move(new Position("e5")));
	}
}
