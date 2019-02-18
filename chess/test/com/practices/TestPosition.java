package com.practices;

import com.practices.exception.WrongPositionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPosition {
	private static final Logger logger = LoggerFactory.getLogger(TestPosition.class);

	@BeforeEach
	public void setUp() {
	}


	@Test
	public void invalidPosition() {
		Exception exception = assertThrows(WrongPositionException.class, () -> new Position(-1, 1));
		logger.debug(exception.getMessage());
		assertEquals("x 또는 y가 유효한 값이 아닙니다.", exception.getMessage());
	}

}
