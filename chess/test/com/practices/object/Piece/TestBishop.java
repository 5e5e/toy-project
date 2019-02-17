package com.practices.object.Piece;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBishop {
	private static final Logger logger = LoggerFactory.getLogger(TestBishop.class);
	private final Piece whiteTestBishop = Bishop.createWhiteBishop();
	private final Piece blackTestBishop = Bishop.createBlackBishop();

	@Test
	public void createWhiteTestBishop() {
		assertEquals(whiteTestBishop, Bishop.create("white"));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackTestBishop, Bishop.create("black"));
	}

	@Test
	public void wrongColorException() {
		Exception exception = assertThrows(WrongPieceColorException.class, () -> Bishop.create("red"));
		assertEquals("하얀색 또는 검은색 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void wrongPieceException() {
		Exception exception = assertThrows(WrongPieceTypeException.class, () -> Bishop.create("white", "K"));
		assertEquals("비숍 기물만 생성할 수 있습니다", exception.getMessage());
	}
}
