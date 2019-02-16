package com.practices.Object;

import com.practices.exception.WrongPieceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPawn {
	private static Logger logger = LoggerFactory.getLogger(TestPawn.class);
	private Piece pawn;

	@BeforeEach
	public void setup() {
		pawn = new Pawn();
	}

	@Test
	public void createWhitePawn() {
		assertEquals(Pawn.createWhite(), Pawn.create("white"));
	}

	@Test
	public void createWhitePawnException() {
		Exception exception = assertThrows(WrongPieceException.class, () -> Pawn.create("dfjsfbsk"));
		assertEquals("폰 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void createBlackPawn() {
		assertEquals(Pawn.createBlack(), Pawn.create("black"));
	}

	@Test
	public void createWhiteBlackException() {
		Exception exception = assertThrows(WrongPieceException.class, () -> Pawn.create("dfjsfbsk"));
		assertEquals("폰 기물만 생성할 수 있습니다", exception.getMessage());
	}
}
