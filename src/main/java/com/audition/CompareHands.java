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
			System.out.println(name.getName() + " wins. - with " + oneWinCon);
		} else if (playerOneHandValue < playerTwoHandValue) {
			System.out.println(name2.getName() + " wins. - with " + twoWinCon);
		} else if (playerOneHandValue == playerTwoHandValue) {
			resolveTie(name, name2);

		}
	}

	private static void resolveTie(PlayerOne name, PlayerTwo name2) {
		tieOnStraightFlush(name, name2);
		tieOnFourOfAKind(name, name2);
		tieOnFullHouse(name, name2);
		tieOnFlush(name, name2);
		tieOnStraight(name, name2);
		tieOnThreeOfAKind(name, name2);
		tieOn2Pair(name, name2);
		tieOnPair(name, name2);
		if (playerOneHandValue < 15 && playerTwoHandValue < 15)
			nextHighestCard(name, name2);

	}

	private static void tieOnStraightFlush(PlayerOne name, PlayerTwo name2) {
		if (playerOneHandValue == 22 && playerTwoHandValue == 22) {
			tieWithNothing(name, name2);
		}
	}

	private static void tieOnFourOfAKind(PlayerOne name, PlayerTwo name2) {
		if (playerOneHandValue == 21 && playerTwoHandValue == 21) {
			if (name.getFourOfAKindTieValue() > name2.getFourOfAKindTieValue()) {
				System.out.println(name.getName() + " Ties with " + name2.getName() + ". - with " + oneWinCon + " "
						+ name.getName() + " wins with " + name.getFourOfAKindTieValue() + " high");
			} else if (name.getFourOfAKindTieValue() < name2.getFourOfAKindTieValue()) {
				System.out.println(name2.getName() + " Ties with " + name.getName() + ". - with " + twoWinCon + " "
						+ name2.getName() + " wins with " + name2.getFourOfAKindTieValue() + " high");
			} else if (name.getFourOfAKindTieValue() == name2.getFourOfAKindTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieOnFullHouse(PlayerOne name, PlayerTwo name2) {
		if (playerOneHandValue == 20 && playerTwoHandValue == 20) {
			if (name.getThreeOfAKindTieValue() > name2.getThreeOfAKindTieValue()) {
				System.out.println(name.getName() + " Ties with " + name2.getName() + ". - with " + oneWinCon + " "
						+ name.getName() + " wins with " + name.getThreeOfAKindTieValue() + " high");
			} else if (name.getThreeOfAKindTieValue() < name2.getThreeOfAKindTieValue()) {
				System.out.println(name2.getName() + " Ties with " + name.getName() + ". - with " + twoWinCon + " "
						+ name2.getName() + " wins with " + name2.getThreeOfAKindTieValue() + " high");
			} else if (name.getThreeOfAKindTieValue() == name2.getThreeOfAKindTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieOnFlush(PlayerOne name, PlayerTwo name2) {
		if (playerOneHandValue == 19 && playerTwoHandValue == 19) {
			tieWithNothing(name, name2);
		}
	}

	private static void tieOnStraight(PlayerOne name, PlayerTwo name2) {
		if (playerOneHandValue == 18 && playerTwoHandValue == 18) {
			tieWithNothing(name, name2);
		}
	}

	private static void tieOnThreeOfAKind(PlayerOne name, PlayerTwo name2) {
		if (playerOneHandValue == 17 && playerTwoHandValue == 17) {
			if (name.getThreeOfAKindTieValue() > name2.getThreeOfAKindTieValue()) {
				System.out.println(name.getName() + " Ties with " + name2.getName() + ". - with " + oneWinCon + " "
						+ name.getName() + " wins with " + name.getThreeOfAKindTieValue() + " high");
			} else if (name.getThreeOfAKindTieValue() < name2.getThreeOfAKindTieValue()) {
				System.out.println(name2.getName() + " Ties with " + name.getName() + ". - with " + twoWinCon + " "
						+ name2.getName() + " wins with " + name2.getThreeOfAKindTieValue() + " high");
			} else if (name.getThreeOfAKindTieValue() == name2.getThreeOfAKindTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieOn2Pair(PlayerOne name, PlayerTwo name2) {
		if (playerOneHandValue == 16 && playerTwoHandValue == 16) {
			if (name.get2PairTieValue() > name2.get2PairTieValue()) {
				System.out.println(name.getName() + " Ties with " + name2.getName() + ". - with " + oneWinCon + " "
						+ name.getName() + " wins with " + name.get2PairTieValue() + " high");
			} else if (name.get2PairTieValue() < name2.get2PairTieValue()) {
				System.out.println(name2.getName() + " Ties with " + name.getName() + ". - with " + twoWinCon + " "
						+ name2.getName() + " wins with " + name2.get2PairTieValue() + " high");
			} else if (name.get2PairTieValue() == name2.get2PairTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieOnPair(PlayerOne name, PlayerTwo name2) {
		if (playerOneHandValue == 15 && playerTwoHandValue == 15) {
			if (name.getPairTieValue() > name2.getPairTieValue()) {
				System.out.println(name.getName() + " Ties with " + name2.getName() + ". - with " + oneWinCon + " "
						+ name.getName() + " wins with " + name.getPairTieValue() + " high");
			} else if (name.getPairTieValue() < name2.getPairTieValue()) {
				System.out.println(name2.getName() + " Ties with " + name.getName() + ". - with " + twoWinCon + " "
						+ name2.getName() + " wins with " + name2.getPairTieValue() + " high");
			} else if (name.getPairTieValue() == name2.getPairTieValue()) {
				tieWithNothing(name, name2);
			}
		}
	}

	private static void tieWithNothing(PlayerOne name, PlayerTwo name2) {
		int playerOneTieHandValue = 0;
		int playerTwoTieHandValue = 0;
		playerOneTieHandValue = name.getHighCardInHand().getValue();
		playerTwoTieHandValue = name2.getHighCardInHand().getValue();
		if (playerOneTieHandValue > playerTwoTieHandValue) {
			System.out.println(name.getName() + " Ties with " + name2.getName() + ". - with " + oneWinCon + ". "
					+ name.getName() + " wins with " + name.getHighCardInHand() + " high");
		} else if (playerOneTieHandValue < playerTwoTieHandValue) {
			System.out.println(name2.getName() + " Ties with " + name.getName() + ". - with " + twoWinCon + ". "
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
			System.out.println(name.getName() + " Ties with " + name2.getName() + ". - with " + oneWinCon + ". "
					+ name.getName() + " wins with " + name.getNextHighestCardInHand() + " high");
		} else if (playerOneTieHandValue < playerTwoTieHandValue) {
			System.out.println(name2.getName() + " Ties with " + name2.getName() + ". - with " + twoWinCon + ". "
					+ name2.getName() + " wins with " + name2.getNextHighestCardInHand() + " high");
		} else if (playerOneTieHandValue == playerTwoTieHandValue) {
			System.out.println("Tie.");

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
