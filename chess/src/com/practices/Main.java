package com.practices;

import com.practices.object.board.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		Board board = new Board();
		Scanner scanner = new Scanner(System.in);
		logger.debug(board.result());
		String[] positions;
		while (true) {
			logger.warn("이동할 곳을 입력하세요 :  ex) move a1 a2, end");
			String command = scanner.nextLine();
			if (command.startsWith("move")) {
				positions = command.split(" ");
				logger.debug("departure : " + positions[1]);
				logger.debug("arrive : " + positions[2]);
				board.move(positions[1], positions[2]);
			} else if (command.startsWith("end")) break;
			logger.debug(board.result());
		}
	}
}
