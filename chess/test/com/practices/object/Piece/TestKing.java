package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestKing {
	private static final Logger logger = LoggerFactory.getLogger(TestKing.class);
	private final Piece whiteTestKing = King.createWhiteKing();
	private final Piece blackTestKing = King.createBlackKing();

	@Test
	public void createWhiteTestKing() {
		assertEquals(whiteTestKing, King.create(Color.WHITE));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackTestKing, King.create(Color.BLACK));
	}

	@Test
	public void wrongColorException() {
		Exception exception = assertThrows(WrongPieceColorException.class, () -> King.create(Color.NO_COLOR));
		assertEquals("하얀색 또는 검은색 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void wrongPieceException() {
		Exception exception = assertThrows(WrongPieceTypeException.class, () -> King.create(Color.WHITE, Type.QUEEN));
		assertEquals("킹 기물만 생성할 수 있습니다", exception.getMessage());
	}
}