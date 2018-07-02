package com.audition.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class PokerRuleable {

	protected List<Card> cards = new ArrayList<>();
	protected Map<String, Integer> occurences = new TreeMap<>();
	protected int entries = 0;
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

	public void addCardsToMapCounter() {
		for (Card card : cards) {
			String cardOc = Integer.toString(card.getValue());
			if (entries < 5) {
				if (occurences.containsKey(cardOc)) {
					occurences.put(cardOc, occurences.get(cardOc) + 1);
					entries++;
				} else {
					occurences.put(cardOc, 1);
					entries++;
				}
			}
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

	public Card getNextHighestCard() {
		addCardsInHandToList();
		Card highCard = getHighCard();
		char rank = 0;
		char suit = 0;
		int almostHighCard = 0;
		for (Card card : cards) {
			if (card.getValue() >= almostHighCard && card.getValue() != highCard.getValue()) {
				rank = card.getRank();
				suit = card.getSuit();
			}
		}
		Card highestCard = new Card(rank, suit);
		return highestCard;
	}

	public boolean checkForTwoOfAKind() {
		addCardsInHandToList();
		addCardsToMapCounter();
		return occurences.containsValue(2);
	}

	public boolean checkFor2Pairs() {
		addCardsInHandToList();
		addCardsToMapCounter();
		int counter = 0;
		for (Map.Entry<String, Integer> pair : occurences.entrySet()) {
			if (pair.getValue() == 2) {
				counter++;
			}
		}
		return counter == 2;
	}

	public boolean checkForThreeOfAKind() {
		addCardsInHandToList();
		addCardsToMapCounter();
		return occurences.containsValue(3);
	}

}
