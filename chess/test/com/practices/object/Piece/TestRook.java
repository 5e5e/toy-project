package com.practices.object.Piece;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRook {
	private static final Logger logger = LoggerFactory.getLogger(TestRook.class);
	private final Piece whiteRook = Rook.createWhiteRook();
	private final Piece blackRook = Rook.createBlackRook();

	@Test
	public void createWhiteRook() {
		assertEquals(whiteRook, Rook.create("white"));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackRook, Rook.create("black"));
	}

	@Test
	public void wrongColorException() {
		Exception exception = assertThrows(WrongPieceColorException.class, () -> Rook.create("red"));
		assertEquals("하얀색 또는 검은색 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void wrongPieceException() {
		Exception exception = assertThrows(WrongPieceTypeException.class, () -> Rook.create("white", "p"));
		assertEquals("룩 기물만 생성할 수 있습니다", exception.getMessage());
	}

}
