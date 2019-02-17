package com.practices.Object;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlank {
	private static Logger logger = LoggerFactory.getLogger(TestBlank.class);
	private final Piece blank = Blank.create();


	@Test
	public void create() {
		assertEquals(blank, Blank.create());
	}
}
