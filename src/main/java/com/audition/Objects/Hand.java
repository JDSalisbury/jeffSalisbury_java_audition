package com.audition.Objects;

public class Hand extends PokerRuleable {

	public Hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
	}

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
