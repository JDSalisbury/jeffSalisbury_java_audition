package com.audition.Objects;

import java.util.ArrayList;
import java.util.List;

public abstract class PokerRuleable {

	protected List<Card> cards = new ArrayList<>();
	protected Card card1;
	protected Card card2;
	protected Card card3;
	protected Card card4;
	protected Card card5;

	public void addCardsInHandToList() {
		if (cards.size() == 0) {
			cards.add(card1);
			cards.add(card2);
			cards.add(card3);
			cards.add(card4);
			cards.add(card5);
		}
	}

	public Card getHighCard() {
		addCardsInHandToList();
		char rank = 0;
		char suit = 0;
		int highCard = 0;
		for (Card card : cards) {
			if (card.getValue() >= highCard) {
				highCard = card.getValue();
			}
			if (card.getValue() == highCard) {
				rank = card.getRank();
				suit = card.getSuit();
			}
		}
		Card highestCard = new Card(rank, suit);
		return highestCard;
	}

}
