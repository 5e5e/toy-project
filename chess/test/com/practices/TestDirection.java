package com.practices;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDirection {
	private static final Logger logger = LoggerFactory.getLogger(TestDirection.class);

	@Test
	void testDecideDirection() {
		assertEquals(Direction.NORTH_WEST, Direction.decide("a4", "c5"));
	}
}
