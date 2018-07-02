package com.audition.Objects;

public abstract class Hand {

	protected Card card1;
	protected Card card2;
	protected Card card3;
	protected Card card4;
	protected Card card5;

	public Card getCard1() {
		return card1;
	}

	public Card getCard2() {
		return card2;
	}

	public Card getCard3() {
		return card3;
	}

	public Card getCard4() {
		return card4;
	}

	public Card getCard5() {
		return card5;
	}

	@Override
	public String toString() {
		return card1 + " " + card2 + " " + card3 + " " + card4 + " " + card5;
	}
}
