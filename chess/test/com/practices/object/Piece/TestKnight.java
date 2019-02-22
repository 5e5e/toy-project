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

public class TestKnight {
	private static final Logger logger = LoggerFactory.getLogger(TestKnight.class);
	private final Piece whiteTestKnight = Knight.createWhiteKnight();
	private final Piece blackTestKnight = Knight.createBlackKnight();

	@Test
	public void createWhiteTestKnight() {
		assertEquals(whiteTestKnight, Knight.create(Color.WHITE));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackTestKnight, Knight.create(Color.BLACK));
	}

	@Test
	public void wrongColorException() {
		Exception exception = assertThrows(WrongPieceColorException.class, () -> Knight.create(Color.NO_COLOR));
		assertEquals("하얀색 또는 검은색 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void wrongPieceException() {
		Exception exception = assertThrows(WrongPieceTypeException.class, () -> Knight.create(Color.WHITE, Type.ROOK));
		assertEquals("나이트 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void move() {
		Piece whiteKnight = Knight.createWhiteKnight("a8");
		assertTrue(whiteKnight.move(new Position("c7")));
	}
}
