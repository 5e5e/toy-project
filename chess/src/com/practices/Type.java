package com.practices;

public enum Type {
	PAWN("p", 1), ROOK("r", 5), KNIGHT("n", 2.5), BISHOP("b", 3),
	QUEEN("q", 9), KING("k", 0), BLANK(".", 0);
	private String type;
	private double score;

	Type(String type, double score) {
		this.type = type;
		this.score = score;
	}

	public String getWhiteType() {
		return type;
	}

	public String getBlackType() {
		return type.toUpperCase();
	}

	public double getScore() {
		return score;
	}
}
