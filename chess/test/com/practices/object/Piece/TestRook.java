package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;
import com.practices.exception.WrongPieceColorException;
import com.practices.exception.WrongPieceTypeException;
import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRook {
	private static final Logger logger = LoggerFactory.getLogger(TestRook.class);
	private final Piece whiteRook = Rook.createWhiteRook();
	private final Piece blackRook = Rook.createBlackRook();
	private Board board;
	private Piece piece;

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

	@BeforeEach
	public void setup() {
		board = new Board();
	}

	@Test
	public void validMove() {
		piece = board.findPiece("h1");
		logger.debug(piece.moveList(new Position("h1")) + "");

	}
}
