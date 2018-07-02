package com.audition;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.audition.Objects.Card;
import com.audition.Objects.PokerHand;

public class PokerHandTest {

	private Card card1 = new Card('9', 'H');
	private Card card2 = new Card('T', 'H');
	private Card card3 = new Card('J', 'H');
	private Card card4 = new Card('Q', 'H');
	private Card card5 = new Card('K', 'H');
	private Card card6 = new Card('K', 'D');
	private Card card7 = new Card('Q', 'D');
	private Card card8 = new Card('Q', 'S');
	private Card card9 = new Card('Q', 'C');
	private PokerHand testHand = new PokerHand(card1, card2, card3, card4, card5);

	@Test
	public void shouldReturnHighCardInHand() {
		Card theHighCardInHand = testHand.getHighCard();
		assertThat(theHighCardInHand, is(card5));
	}

	@Test
	public void shouldReturn2ndHighestCardInHand() {
		Card theSecondHighest = testHand.getNextHighestCard();
		assertThat(theSecondHighest, is(card4));
	}

	@Test
	public void shouldLookForTwoOfAKind() {
		PokerHand twoOfAKind = new PokerHand(card1, card2, card3, card5, card6);

		assertThat(twoOfAKind.checkForTwoOfAKind(), is(true));
	}

	@Test
	public void shouldLookForTwoPairs() {
		PokerHand twoPairs = new PokerHand(card7, card4, card3, card5, card6);
		assertThat(twoPairs.checkForTwoPairs(), is(true));
	}

	@Test
	public void shouldLookForThreeOfAKind() {
		PokerHand threeOfAKind = new PokerHand(card7, card4, card3, card8, card6);
		assertThat(threeOfAKind.checkForThreeOfAKind(), is(true));
	}

	@Test
	public void shouldLookForFourOfAKind() {
		PokerHand fourOfAKind = new PokerHand(card7, card4, card9, card8, card6);
		assertThat(fourOfAKind.checkForFourOfAKind(), is(true));
	}

	@Test
	public void shouldLookForFullHouse() {
		PokerHand fullHouse = new PokerHand(card5, card6, card7, card8, card9);
		assertThat(fullHouse.checkForFullHouse(), is(true));
	}

	@Test
	public void shouldLookForFlush() {
		assertThat(testHand.checkForFlush(), is(true));
	}

	@Test
	public void shouldlookForStraight() {
		assertThat(testHand.checkForStraight(), is(true));
	}

	@Test
	public void shouldlookForStraightFlush() {
		assertThat(testHand.checkForStraightFlush(), is(true));
	}
}
