package com.audition;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.audition.Objects.Card;
import com.audition.Objects.Hand;
import com.audition.Objects.Player;
import com.audition.Objects.PlayerOne;
import com.audition.Objects.PlayerTwo;

public class ComparHandsTest {
	private Card card1 = new Card('9', 'H');
	private Card card2 = new Card('T', 'H');
	private Card card3 = new Card('J', 'H');
	private Card card4 = new Card('Q', 'H');
	private Card card5 = new Card('K', 'H');
	private Card card6 = new Card('7', 'D');
	private Hand testHandForPlayerOne = new Hand(card1, card2, card3, card4, card5);
	private Hand testHandForPlayerTwo = new Hand(card1, card2, card3, card4, card6);

	@Test
	public void shouldCompareHandsToSeeWhosWasTheWinner() {
		Player mark = new PlayerOne("Mark");
		Player tom = new PlayerTwo("Tom");
		mark.addHand(testHandForPlayerOne);
		tom.addHand(testHandForPlayerTwo);
		String victoryMessage = CompareHands.comparePlayerHands(mark, tom);
		assertThat(victoryMessage, is("Mark wins. - with StraightFlush! KH high"));
	}
}
