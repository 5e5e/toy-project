package com.practices.grobal;

import com.practices.object.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManager {
	private static final Logger logger = LoggerFactory.getLogger(TestManager.class);
	private Manager manager;
	private Board board;

	@BeforeEach
	void setUp() {
		manager = new Manager();
		board = new Board();
	}

	@Test
	void boardToMap() {
		board.create();
		board.toMap();
		assertEquals(32, Manager.chessMap.size());
		logger.debug(" Manager.chessMap : " +  Manager.chessMap);
	}
}
