package com.audition;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.audition.Objects.Card;
import com.audition.Objects.Hand;

public class HandTest {

	private Card card1 = new Card('9', 'H');
	private Card card2 = new Card('T', 'H');
	private Card card3 = new Card('J', 'H');
	private Card card4 = new Card('Q', 'H');
	private Card card5 = new Card('K', 'H');
	private Card card6 = new Card('K', 'D');
	private Hand testHand = new Hand(card1, card2, card3, card4, card5);
	private Hand twoOfAKind = new Hand(card1, card2, card3, card5, card6);

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
		assertThat(twoOfAKind.checkForTwoOfAKind(), is(true));
	}

}
