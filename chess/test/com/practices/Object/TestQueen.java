package com.practices.Object;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestQueen {
	private static final Logger logger = LoggerFactory.getLogger(TestQueen.class);
	private final Piece whiteTestQueen = new Piece("white", "q");
	private final Piece blackTestQueen = new Piece("black", "Q");

	@Test
	public void createWhiteTestQueen() {
		assertEquals(whiteTestQueen, Queen.create("white"));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackTestQueen, Queen.create("black"));
	}

	@Test
	public void wrongColorException() {
		Exception exception = assertThrows(WrongPieceColorException.class, () -> Queen.create("red"));
		assertEquals("하얀색 또는 검은색 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void wrongPieceException() {
		Exception exception = assertThrows(WrongPieceTypeException.class, () -> Queen.create("white", "K"));
		assertEquals("퀸 기물만 생성할 수 있습니다", exception.getMessage());
	}
}
