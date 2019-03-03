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

public class TestQueen {
	private static final Logger logger = LoggerFactory.getLogger(TestQueen.class);
	private final Piece whiteTestQueen = Queen.createWhiteQueen();
	private final Piece blackTestQueen = Queen.createBlackQueen();
	private Board board;
	private Piece piece;

	@Test
	public void createWhiteTestQueen() {
		assertEquals(whiteTestQueen, Queen.create(Color.WHITE));
	}

	@Test
	public void createBlackPawn() {
		assertEquals(blackTestQueen, Queen.create(Color.BLACK));
	}

	@Test
	public void wrongColorException() {
		Exception exception = assertThrows(WrongPieceColorException.class, () -> Queen.create(Color.NO_COLOR));
		assertEquals("하얀색 또는 검은색 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@Test
	public void wrongPieceException() {
		Exception exception = assertThrows(WrongPieceTypeException.class, () -> Queen.create(Color.WHITE, Type.KING));
		assertEquals("퀸 기물만 생성할 수 있습니다", exception.getMessage());
	}

	@BeforeEach
	public void setup() {
		board = new Board();
	}

	@Test
	public void validMove() {
		piece = board.findPiece("d1");
		logger.debug(piece.moveList(new Position("d1")) + "");

	}
}
