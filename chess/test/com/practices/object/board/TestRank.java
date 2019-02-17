package com.practices.object.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRank {
	private static final Logger logger = LoggerFactory.getLogger(TestRank.class);
	private Rank rank;

	@BeforeEach
	public void setUp() {
		rank = new Rank();
	}

	@Test
	public void createWhitePawnRank() {
		rank.createWhitePawnRank();
		assertEquals("pppppppp", rank.result());
	}

	@Test
	public void createWhiteOthersPiecesRank() {
		rank.createWhiteOthersPiecesRank();
		assertEquals("rnbqkbnr", rank.result());
	}

	@Test
	public void createBlackPawnRank() {
		rank.createBlackPawnRank();
		assertEquals("PPPPPPPP", rank.result());
	}

	@Test
	public void createBlackOthersPiecesRank() {
		rank.createBlackOthersPiecesRank();
		assertEquals("RNBQKBNR", rank.result());
	}

	@Test
	public void createBlankRank() {
		rank.createBlankRank();
		assertEquals("        ", rank.result());
	}
}
