package com.practices;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDirection {
	private static final Logger logger = LoggerFactory.getLogger(TestDirection.class);

	@Test
	void testNorthWest() {
		assertEquals(Direction.NORTH_WEST, Direction.decide("h1", "a8"));
	}

	@Test
	void testNorthEast() {
		assertEquals(Direction.NORTH_EAST, Direction.decide("a1", "h8"));
	}

	@Test
	void testNorth() {
		assertEquals(Direction.NORTH, Direction.decide("a1", "a8"));
	}

	@Test
	void testSouth() {
		assertEquals(Direction.SOUTH, Direction.decide("a8", "a1"));
	}

	@Test
	void testEast() {
		assertEquals(Direction.EAST, Direction.decide("a4", "h4"));
	}

	@Test
	void testWest() {
		assertEquals(Direction.WEST, Direction.decide("h4", "a4"));
	}

	@Test
	void testSouthWest() {
		assertEquals(Direction.SOUTH_WEST, Direction.decide("h8", "a1"));
	}

	@Test
	void testSouthEast() {
		assertEquals(Direction.SOUTH_EAST, Direction.decide("a8", "h1"));
	}
}

