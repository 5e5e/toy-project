package com.practices.object.board;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRank {
	private static final Logger logger = LoggerFactory.getLogger(TestRank.class);

	@Test
	public void createWhitePawnRank() {
		assertEquals("pppppppp", Rank.createWhitePawnRank().result());
	}

	@Test
	public void createWhiteOthersPiecesRank() {
		assertEquals("rnbqkbnr", Rank.createWhiteOthersPiecesRank().result());
	}

	@Test
	public void createBlackPawnRank() {
		assertEquals("PPPPPPPP", Rank.createBlackPawnRank().result());
	}

	@Test
	public void createBlackOthersPiecesRank() {
		assertEquals("RNBQKBNR", Rank.createBlackOthersPiecesRank().result());
	}

	@Test
	public void createBlankRank() {
		assertEquals("        ", Rank.createBlankRank().result());
	}
}
