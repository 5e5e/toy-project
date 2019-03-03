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
		board.create();
		logger.debug(board.result());
		String[] positions;
		while (true) {
			logger.warn("이동할 곳을 입력하세요 :  ex) move a1 a2, end");
			String command = scanner.nextLine();
			if (command.startsWith("move")) {
				positions = command.split(" ");
				board.move(positions[1], positions[2]);
			} else if (command.startsWith("end")) break;
			logger.debug(board.result());
			logger.info("흰색 점수 " + board.whitePieceCalculation());
			logger.info("검은색 점수 " + board.blackPieceCalculation());
		}
		if (board.blackPieceCalculation() > board.whitePieceCalculation()) logger.info("검은색 승리");
		else logger.info("흰색 승리");
	}
}
