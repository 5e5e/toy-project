package com.practices.object.Piece;

import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPawn {
	private static Logger logger = LoggerFactory.getLogger(TestPawn.class);
	private final Piece whitePawn = Pawn.createWhitePawn();
	private final Piece blackPawn = Pawn.createBlackPawn();

	@Test
	public void createWhitePawn() {
		assertEquals(whitePawn, Pawn.create("white"));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackPawn, Pawn.create("black"));
	}

	@Test
	public void wrongColorException() {
		Exception exception = assertThrows(WrongPieceColorException.class, () -> Pawn.create("red"));
		assertEquals("하얀색 또는 검은색 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void wrongPieceException() {
		Exception exception = assertThrows(WrongPieceTypeException.class, () -> Pawn.create("white", "1"));
		assertEquals("폰 기물만 생성할 수 있습니다", exception.getMessage());
	}
}
