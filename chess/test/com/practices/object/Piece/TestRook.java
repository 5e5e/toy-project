package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestRook {
	private static final Logger logger = LoggerFactory.getLogger(TestRook.class);
	private final Piece whiteRook = Rook.createWhiteRook();
	private final Piece blackRook = Rook.createBlackRook();

	@Test
	public void createWhiteRook() {
		assertEquals(whiteRook, Rook.create(Color.WHITE));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackRook, Rook.create(Color.BLACK));
	}

	@Test
	public void wrongColorException() {
		Exception exception = assertThrows(WrongPieceColorException.class, () -> Rook.create(Color.NO_COLOR));
		assertEquals("하얀색 또는 검은색 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void wrongPieceException() {
		Exception exception = assertThrows(WrongPieceTypeException.class, () -> Rook.create(Color.WHITE, Type.PAWN));
		assertEquals("룩 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void move() {
		Piece whiteRook = Rook.createWhiteRook("a1");
		assertTrue(whiteRook.move(new Position("a8")));
	}

	@Test
	public void moveFalse() {
		Piece whiteRook = Rook.createWhiteRook("a1");
		assertFalse(whiteRook.move(new Position("b2")));
	}

	@Test
	public void move2() {
		Piece whiteRook = Rook.createWhiteRook("d6");
		assertTrue(whiteRook.move(new Position("h6")));
	}

}
