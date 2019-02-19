package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;
import com.practices.exception.WrongPositionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPawn {
	private static Logger logger = LoggerFactory.getLogger(TestPawn.class);
	private Piece whitePawn;
	private Piece blackPawn;

	@BeforeEach
	public void setup() {
		whitePawn = Pawn.createWhitePawn();
		blackPawn = Pawn.createBlackPawn();
	}

	@Test
	public void createWhitePawn() {
		assertEquals(whitePawn, Pawn.create(Color.WHITE));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackPawn, Pawn.create(Color.BLACK));
	}

	@Test
	public void createPawn() {
		Piece testPawn1 = Pawn.createWhitePawn(new Position("a1"));
		Piece testPawn2 = Pawn.createWhitePawn(new Position("a8"));
		Piece testPawn3 = Pawn.createWhitePawn(new Position("h8"));
		Piece testPawn4 = Pawn.createWhitePawn(new Position("h1"));
		assertEquals(whitePawn, testPawn1);
		assertEquals(whitePawn, testPawn2);
		assertEquals(whitePawn, testPawn3);
		assertEquals(whitePawn, testPawn4);
	}

	@Test
	public void WrongCreatePawnException() {
		assertThrows(WrongPositionException.class, () -> Pawn.createWhitePawn(new Position("a9")));
		assertThrows(WrongPositionException.class, () -> Pawn.createWhitePawn(new Position("`1")));
		assertThrows(WrongPositionException.class, () -> Pawn.createWhitePawn(new Position("i1")));
		assertThrows(WrongPositionException.class, () -> Pawn.createWhitePawn(new Position("a0")));
	}

	@Test
	public void wrongColorException() {
		Exception exception = assertThrows(WrongPieceColorException.class, () -> Pawn.create(Color.NO_COLOR));
		assertEquals("하얀색 또는 검은색 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void wrongPieceException() {
		Exception exception = assertThrows(WrongPieceTypeException.class, () -> Pawn.create(Color.BLACK, Type.QUEEN));
		assertEquals("폰 기물만 생성할 수 있습니다", exception.getMessage());
	}


}