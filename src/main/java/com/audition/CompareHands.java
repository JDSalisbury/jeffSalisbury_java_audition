package com.audition;

import com.audition.Player.PlayerOne;
import com.audition.Player.PlayerTwo;

public class CompareHands {

	protected static int playerOneHandValue = 0;
	protected static int playerTwoHandValue = 0;
	protected static String oneWinCon = "";
	protected static String twoWinCon = "";

	public static void comparePlayerHands(PlayerOne name, PlayerTwo name2) {

		playerOneWinConsAndHandValues(name);
		playerTwoWinConsAndHandValues(name2);
		decideVictor(name, name2);
	}

	public static void decideVictor(PlayerOne name, PlayerTwo name2) {

		if (playerOneHandValue > playerTwoHandValue) {
			System.out.print(name.getName() + " wins. - with " + oneWinCon);
		} else if (playerOneHandValue < playerTwoHandValue) {
			System.out.print(name2.getName() + " wins. - with " + twoWinCon);
		} else if (playerOneHandValue == playerTwoHandValue) {
			resolveTie(name, name2);

		}
	}

	private static void resolveTie(PlayerOne name, PlayerTwo name2) {
		tieOnStraightFlush(name, name2);

	}

	private static void tieOnStraightFlush(PlayerOne name, PlayerTwo name2) {
		if (playerOneHandValue == 22 && playerTwoHandValue == 22) {
			tieWithNothing(name, name2);
		}
	}

	private static void tieWithNothing(PlayerOne name, PlayerTwo name2) {
		int playerOneTieHandValue = 0;
		int playerTwoTieHandValue = 0;
		playerOneTieHandValue = name.getHighCardInHand().getValue();
		playerTwoTieHandValue = name2.getHighCardInHand().getValue();
		if (playerOneTieHandValue > playerTwoTieHandValue) {
			System.out.print(name.getName() + " Ties with " + name2.getName() + ". - with " + oneWinCon + ". "
					+ name.getName() + " wins with " + name.getHighCardInHand() + " high");
		} else if (playerOneTieHandValue < playerTwoTieHandValue) {
			System.out.print(name2.getName() + " Ties with " + name.getName() + ". - with " + twoWinCon + ". "
					+ name2.getName() + " wins with " + name2.getHighCardInHand() + " high");
		} else if (playerOneTieHandValue == playerTwoTieHandValue && playerOneTieHandValue > 0
				&& playerTwoTieHandValue > 0) {
			nextHighestCard(name, name2);

		}
	}

	private static void nextHighestCard(PlayerOne name, PlayerTwo name2) {
		int playerOneTieHandValue;
		int playerTwoTieHandValue;
		playerOneTieHandValue = name.getNextHighestCardInHand().getValue();
		playerTwoTieHandValue = name2.getNextHighestCardInHand().getValue();
		if (playerOneTieHandValue > playerTwoTieHandValue) {
			System.out.print(name.getName() + " Ties with " + name2.getName() + ". - with " + oneWinCon + ". "
					+ name.getName() + " wins with " + name.getNextHighestCardInHand() + " high");
		} else if (playerOneTieHandValue < playerTwoTieHandValue) {
			System.out.print(name2.getName() + " Ties with " + name2.getName() + ". - with " + twoWinCon + ". "
					+ name2.getName() + " wins with " + name2.getNextHighestCardInHand() + " high");
		} else if (playerOneTieHandValue == playerTwoTieHandValue) {
			System.out.print("Tie.");

		}
	}

	public static void playerOneWinConsAndHandValues(PlayerOne name) {
		if (name.hasStraightFlush()) {
			oneWinCon = "StraightFlush!" + " " + name.getHighCardInHand() + " high";
			playerOneHandValue = 22;
		} else if (name.hasFourOfAKind()) {
			oneWinCon = "Four of a Kind!";
			playerOneHandValue = 21;
		} else if (name.hasFullHouse()) {
			oneWinCon = "Full House!";
			playerOneHandValue = 20;
		} else if (name.hasFlush()) {
			oneWinCon = "Flush!" + " " + name.getHighCardInHand() + " high";
			playerOneHandValue = 19;
		} else if (name.hasStraight()) {
			oneWinCon = "Straight!" + " " + name.getHighCardInHand() + " high";
			playerOneHandValue = 18;
		} else if (name.hasThreeOfAKind()) {
			oneWinCon = "Three of a Kind!";
			playerOneHandValue = 17;
		} else if (name.hasTwoPairs()) {
			oneWinCon = "2 Pairs!";
			playerOneHandValue = 16;
		} else if (name.hasPair()) {
			oneWinCon = "Pair!";
			playerOneHandValue = 15;
		} else {
			oneWinCon = name.getHighCardInHand() + " high";
			playerOneHandValue = name.getHighCardInHand().getValue();
		}
	}

	public static void playerTwoWinConsAndHandValues(PlayerTwo name2) {
		if (name2.hasStraightFlush()) {
			twoWinCon = "StraightFlush!" + " " + name2.getHighCardInHand() + " high";
			playerTwoHandValue = 22;
		} else if (name2.hasFourOfAKind()) {
			twoWinCon = "Four of a Kind!";
			playerTwoHandValue = 21;
		} else if (name2.hasFullHouse()) {
			twoWinCon = "Full House!";
			playerTwoHandValue = 20;
		} else if (name2.hasFlush()) {
			twoWinCon = "Flush!" + " " + name2.getHighCardInHand() + " high";
			playerTwoHandValue = 19;
		} else if (name2.hasStraight()) {
			twoWinCon = "Straight!" + " " + name2.getHighCardInHand() + " high";
			playerTwoHandValue = 18;
		} else if (name2.hasThreeOfAKind()) {
			twoWinCon = "Three of a Kind!";
			playerTwoHandValue = 17;
		} else if (name2.hasTwoPairs()) {
			twoWinCon = "2 Pairs!";
			playerTwoHandValue = 16;
		} else if (name2.hasPair()) {
			twoWinCon = "Pair!";
			playerTwoHandValue = 15;
		} else {
			twoWinCon = name2.getHighCardInHand() + " high";
			playerTwoHandValue = name2.getHighCardInHand().getValue();
		}
	}

}
