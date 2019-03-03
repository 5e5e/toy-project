package com.practices.object.Piece;

import com.practices.Position;
import com.practices.exception.WrongPositionException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBlank {
	private static Logger logger = LoggerFactory.getLogger(TestBlank.class);
	private final Piece blank = Blank.create();

	@Test
	public void create() {
		assertEquals(blank, Blank.create());

	}

	@Test
	public void move() {
		Piece blank = Blank.create();
		assertThrows(WrongPositionException.class, () -> blank.move(new Position("a1")));
	}


}
