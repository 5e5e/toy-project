package com.paractice;

import com.practices.Object.Piece;
import com.practices.exception.WrongPieceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
	private static Logger logger = LoggerFactory.getLogger(PieceTest.class);
	Piece piece;

	@BeforeEach
	public void setUp() {
		piece = new Piece();
	}

	@Test
	public void test_blank() {
		Piece blank = piece.makeBlank();
		assertEquals(blank, piece.makePiece(" "));
	}

	@Test
	public void test_blank_exception() {
		assertThrows(WrongPieceException.class,
				() -> piece.makePiece("!"), "이거 어디에 나오는데");
	}


	@Test
	public void test_whitePawn() {

	}
}
