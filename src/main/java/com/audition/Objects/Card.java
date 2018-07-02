package com.audition.Objects;

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

	public int getValue() {
		int value = 0;
		if (rank == '2')
			value = 2;
		if (rank == '3')
			value = 3;
		if (rank == '4')
			value = 4;
		if (rank == '5')
			value = 5;
		if (rank == '6')
			value = 6;
		if (rank == '7')
			value = 7;
		if (rank == '8')
			value = 8;
		if (rank == '9')
			value = 9;
		if (rank == 'T')
			value = 10;
		if (rank == 'J')
			value = 11;
		if (rank == 'Q')
			value = 12;
		if (rank == 'K')
			value = 13;
		if (rank == 'A')
			value = 14;

		return value;
	}

	@Override
	public String toString() {
		return Character.toString(rank) + Character.toString(suit);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		result = prime * result + suit;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}
