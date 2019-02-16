package com.practices.Object;

import com.practices.exception.WrongPieceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPiece {
	private static Logger logger = LoggerFactory.getLogger(TestPiece.class);
	private Piece piece;

	@BeforeEach
	public void setup() {
		piece = new Piece();
	}

	@Test
	public void test_blank() {
		Piece blank = piece.makeBlank();
		assertEquals(" ", blank.getPiece());
	}

	@Test
	public void test_blank_exception() {
		assertThrows(WrongPieceException.class,
				() -> piece.makePiece("!"));
	}


	@Test
	public void testMakeWhitePawn() {
		Piece whitePawn = piece.makeWhitePawn();
		assertEquals("p", whitePawn.getPiece());
	}

	@Test
	public void testMakeWhitePawnException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeWhitePawn("P"));
	}

	@Test
	public void testMakeWhiteRook() {
		Piece whiteRook = piece.makeWhiteRook();
		assertEquals("r", whiteRook.getPiece());
	}

	@Test
	public void testMakeWhiteRookException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeWhiteRook("R"));
	}

	@Test
	public void testMakeWhiteKnight() {
		Piece whiteKnight = piece.makeWhiteKnight();
		assertEquals("n", whiteKnight.getPiece());
	}

	@Test
	public void testMakeWhiteKnightException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeWhiteKnight("N"));
	}

	@Test
	public void testMakeWhiteBishop() {
		Piece whiteBishop = piece.makeWhiteBishop();
		assertEquals("b", whiteBishop.getPiece());
	}

	@Test
	public void testMakeWhiteBishopException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeWhiteBishop("B"));
	}

	@Test
	public void testMakeWhiteQueen() {
		Piece whiteBishop = piece.makeWhiteQueen();
		assertEquals("q", whiteBishop.getPiece());
	}

	@Test
	public void testMakeWhiteQueenException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeWhiteQueen("Q"));
	}

	@Test
	public void testMakeWhiteKing() {
		Piece whiteBishop = piece.makeWhiteKing();
		assertEquals("k", whiteBishop.getPiece());
	}

	@Test
	public void testMakeWhiteKingException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeWhiteKing("K"));
	}

	@Test
	public void testMakeBlackPawn() {
		Piece blackPawn = piece.makeBlackPawn();
		assertEquals("P", blackPawn.getPiece());
	}

	@Test
	public void testMakeBlackPawnException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeBlackPawn("p"));
	}

	@Test
	public void testMakeBlackRook() {
		Piece blackRook = piece.makeBlackRook();
		assertEquals("R", blackRook.getPiece());
	}

	@Test
	public void testMakeBlackRookException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeBlackRook("r"));
	}

	@Test
	public void testMakeBlackKnight() {
		Piece whiteKnight = piece.makeBlackKnight();
		assertEquals("N", whiteKnight.getPiece());
	}

	@Test
	public void testMakeBlackKnightException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeBlackKnight("N"));
	}

	@Test
	public void testMakeBlackBishop() {
		Piece whiteBishop = piece.makeBlackBishop();
		assertEquals("B", whiteBishop.getPiece());
	}

	@Test
	public void testMakeBlackBishopException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeBlackBishop("b"));
	}

	@Test
	public void testMakeBlackQueen() {
		Piece whiteBishop = piece.makeBlackQueen();
		assertEquals("Q", whiteBishop.getPiece());
	}

	@Test
	public void testMakeBlackQueenException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeBlackQueen("q"));
	}

	@Test
	public void testMakeBlackKing() {
		Piece whiteBishop = piece.makeBlackKing();
		assertEquals("K", whiteBishop.getPiece());
	}

	@Test
	public void testMakeBlackKingException() {
		assertThrows(WrongPieceException.class,
				() -> piece.makeBlackKing("k"));
	}
}
