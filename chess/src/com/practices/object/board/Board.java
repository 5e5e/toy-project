package com.practices.object.board;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Rank> ranks = new ArrayList<>();

	public List<Rank> create() {
		ranks.add(Rank.createWhiteOthersPiecesRank());
		ranks.add(Rank.createWhitePawnRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlankRank());
		ranks.add(Rank.createBlackOthersPiecesRank());
		ranks.add(Rank.createBlackPawnRank());
		return ranks;
	}

	public String result() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("  abcdefgh ");
		stringBuilder.append("\n");
		for (int i = ranks.size() - 1; i >= 0; i--) {
			stringBuilder.append((i + 1) + " " + ranks.get(i).result() + " " + (i + 1));
			stringBuilder.append("\n");
		}
		stringBuilder.append("  abcdefgh ");
		return stringBuilder.toString();
	}
}
