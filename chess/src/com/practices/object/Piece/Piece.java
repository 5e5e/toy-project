package com.practices.object.Piece;

import com.practices.Color;
import com.practices.Position;
import com.practices.Type;

import java.util.Objects;

public abstract class Piece {
	private final String blank = " ";
	private Color color;
	private Type type;
	private Position position;

	public Piece() {

	}

	public Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}

	public Piece(Color color, Type type, Position position) {
		this.color = color;
		this.type = type;
		this.position = position;
	}

	public static boolean isBlack(Color color) {
		return color.equals(Color.BLACK);
	}

	public static boolean isWhite(Color color) {
		return color.equals(Color.WHITE);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Piece)) return false;
		Piece piece = (Piece) o;
		return color == piece.color &&
				type == piece.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, type);
	}

	@Override
	public String toString() {
		return "Piece{" +
				"piece='" + type + '\'' +
				'}';
	}

	public Type presentation() {
		return type;
	}
}
