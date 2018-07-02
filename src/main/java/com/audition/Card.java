package com.audition;

public class Card {

	private char suit;
	private char rank;

	public Card(char rank, char suit) {
		this.suit = suit;
		this.rank = rank;
	}

	public char getSuit() {
		return suit;
	}

	public char getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return Character.toString(rank) + Character.toString(suit);
	}

}
