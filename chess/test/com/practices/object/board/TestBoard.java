package com.practices.object.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoard {
	private static final Logger logger = LoggerFactory.getLogger(TestBoard.class);
	private Board board;

	@BeforeEach
	public void setUp() {
		board = new Board();
	}

	@Test
	public void create() {
		board.create();
		assertEquals("rnbqkbnrpppppppp                                RNBQKBNRPPPPPPPP", board.result());
	}

}
