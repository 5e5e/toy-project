package com.practices;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDirection {
	private static final Logger logger = LoggerFactory.getLogger(TestDirection.class);

	@Test
	void testNorthWest() {
		assertEquals(Direction.NORTH_WEST, Direction.calculateRoute(new Position("h1"), new Position("a8")));
	}

	@Test
	void testNorthEast() {
		assertEquals(Direction.NORTH_EAST, Direction.calculateRoute(new Position("a1"), new Position("h8")));
	}

	@Test
	void testNorth() {
		assertEquals(Direction.NORTH, Direction.calculateRoute(new Position("a1"), new Position("a8")));
	}

	@Test
	void testSouth() {
		assertEquals(Direction.SOUTH, Direction.calculateRoute(new Position("a8"), new Position("a1")));
	}

	@Test
	void testEast() {
		assertEquals(Direction.EAST, Direction.calculateRoute(new Position("a4"), new Position("h4")));
	}

	@Test
	void testWest() {
		assertEquals(Direction.WEST, Direction.calculateRoute(new Position("h4"), new Position("a4")));
	}

	@Test
	void testSouthWest() {
		assertEquals(Direction.SOUTH_WEST, Direction.calculateRoute(new Position("h8"), new Position("a1")));
	}

	@Test
	void testSouthEast() {
		assertEquals(Direction.SOUTH_EAST, Direction.calculateRoute(new Position("a8"), new Position("h1")));
	}

	@Test
	void testNorthNorthWest() {
		assertEquals(Direction.NORTH_NORTH_WEST, Direction.calculateRoute(new Position("b1"), new Position("a3")));
	}

	@Test
	void testNorthNorthEast() {
		assertEquals(Direction.NORTH_NORTH_EAST, Direction.calculateRoute(new Position("b1"), new Position("c3")));
	}

	@Test
	void testEastEastNorth() {
		assertEquals(Direction.EAST_EAST_NORTH, Direction.calculateRoute(new Position("d5"), new Position("f6")));
	}

	@Test
	void testEastEastSouth() {
		assertEquals(Direction.EAST_EAST_SOUTH, Direction.calculateRoute(new Position("d5"), new Position("f4")));
	}

	@Test
	void testSouthSouthEast() {
		assertEquals(Direction.SOUTH_SOUTH_EAST, Direction.calculateRoute(new Position("d5"), new Position("e3")));
	}

	@Test
	void testSouthSouthWest() {
		assertEquals(Direction.SOUTH_SOUTH_WEST, Direction.calculateRoute(new Position("d5"), new Position("c3")));
	}

	@Test
	void testWestWestNorth() {
		assertEquals(Direction.WEST_WEST_NORTH, Direction.calculateRoute(new Position("d5"), new Position("b6")));
	}

	@Test
	void testWestWestSouth() {
		assertEquals(Direction.WEST_WEST_SOUTH, Direction.calculateRoute(new Position("d5"), new Position("b4")));
	}
}

