package com.audition.Player;

import com.audition.Objects.Card;
import com.audition.Objects.PokerHand;

public class PokerPlayer extends Player {

	public PokerPlayer(String name) {
		this.name = name;
	}

	public boolean hasPair() {
		int x = 0;
		for (PokerHand hand : cards) {
			if (hand.checkForTwoOfAKind()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean hasTwoPairs() {
		int x = 0;
		for (PokerHand hand : cards) {
			if (hand.checkForTwoPairs()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean hasThreeOfAKind() {
		int x = 0;
		for (PokerHand hand : cards) {
			if (hand.checkForThreeOfAKind()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean hasFourOfAKind() {
		int x = 0;
		for (PokerHand hand : cards) {
			if (hand.checkForFourOfAKind()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean hasFullHouse() {
		int x = 0;
		for (PokerHand hand : cards) {
			if (hand.checkForFullHouse()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean hasFlush() {
		int x = 0;
		for (PokerHand hand : cards) {
			if (hand.checkForFlush()) {
				x++;
			}
		}
		return x == 1;
	}

	public boolean hasStraight() {
		int x = 0;
		for (PokerHand hand : cards) {
			if (hand.checkForStraight()) {
				x++;
			}
		}

		return x == 1;
	}

	public boolean hasStraightFlush() {
		int x = 0;
		for (PokerHand hand : cards) {
			if (hand.checkForStraightFlush()) {
				x++;
			}
		}
		return x == 1;
	}

	public Card getHighCardInHand() {
		Card answer = null;
		for (PokerHand cards : cards) {
			answer = cards.getHighCard();

		}
		return answer;

	}

	public Card getNextHighestCardInHand() {
		Card answer = null;
		for (PokerHand cards : cards) {
			answer = cards.getNextHighestCard();

		}
		return answer;
	}

}
