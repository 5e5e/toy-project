package com.practices.Object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlank {
	private static Logger logger = LoggerFactory.getLogger(TestPiece.class);
	private Piece blank;

	@BeforeEach
	public void setup() {
		blank = new Blank();
	}

	@Test
	public void create() {
		blank = Blank.create();
		assertEquals(blank, Blank.create());
	}
}
