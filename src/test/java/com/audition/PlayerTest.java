package com.audition;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.audition.Objects.Card;
import com.audition.Objects.PokerPlayer;
import com.audition.Objects.PokerHand;
import com.audition.Objects.Player;

public class PlayerTest {
	private Card card1 = new Card('9', 'H');
	private Card card2 = new Card('T', 'H');
	private Card card3 = new Card('J', 'H');
	private Card card4 = new Card('Q', 'H');
	private Card card5 = new Card('K', 'H');

	@Test
	public void shouldReturnPlayersHand() {
		Player underTest = new PokerPlayer("Mark");
		PokerHand testHand = new PokerHand(card1, card2, card3, card4, card5);
		underTest.addHand(testHand);
		assertThat(underTest.getHand(), contains(testHand));
	}

}
