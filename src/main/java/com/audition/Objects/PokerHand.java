package com.audition.Objects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PokerHand extends Hand {
	private List<Card> cards = new ArrayList<>();

	private Map<String, Integer> occurences = new TreeMap<>();
	private int entries = 0;

	public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
	}

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

	public boolean checkForTwoPairs() {
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

	public boolean checkForFourOfAKind() {
		addCardsInHandToList();
		addCardsToMapCounter();
		return occurences.containsValue(4);
	}

	public boolean checkForFullHouse() {
		addCardsInHandToList();
		addCardsToMapCounter();
		return occurences.containsValue(2) && occurences.containsValue(3);
	}

	public boolean checkForFlush() {
		addCardsInHandToList();
		int hCount = 0;
		int dCount = 0;
		int sCount = 0;
		int cCount = 0;
		for (Card card : cards) {
			if (card.getSuit() == 'H') {
				hCount++;
			}
			if (card.getSuit() == 'D') {
				dCount++;
			}
			if (card.getSuit() == 'S') {
				sCount++;
			}
			if (card.getSuit() == 'C') {
				cCount++;
			}
		}
		return hCount == 5 || dCount == 5 || sCount == 5 || cCount == 5;
	}

	public boolean checkForStraight() {
		int checkValue = 0;
		addCardsInHandToList();
		cards.sort(Comparator.comparing(Card::getValue).reversed());
		if (cards.get(0).getValue() - cards.get(1).getValue() == 1) {
			checkValue++;
		}
		if (cards.get(1).getValue() - cards.get(2).getValue() == 1) {
			checkValue++;
		}
		if (cards.get(2).getValue() - cards.get(3).getValue() == 1) {
			checkValue++;
		}
		if (cards.get(3).getValue() - cards.get(4).getValue() == 1) {
			checkValue++;
		}
		return checkValue == 4;
	}

	public boolean checkForStraightFlush() {
		return checkForStraight() && checkForFlush();
	}

	public int checkValueForTieInFourOfAKind() {
		int keyNumber = 0;
		for (Map.Entry<String, Integer> entry : occurences.entrySet()) {
			if (entry.getValue() == 4) {
				keyNumber = Integer.parseInt(entry.getKey());
			} else {
				continue;
			}
		}
		return keyNumber;
	}

}
