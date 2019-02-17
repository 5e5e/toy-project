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
		for (Rank index : ranks) {
			stringBuilder.append(index.result());
		}
		return stringBuilder.toString();
	}
}
