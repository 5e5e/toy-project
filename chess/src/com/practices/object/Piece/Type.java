package com.practices.object.Piece;

public enum Type {
	PAWN("p"), ROOK("r"), KNIGHT("n"), BISHOP("b"), QUEEN("q"), KING("k");
	private String type;

	Type(String type) {
		this.type = type;
	}


}
