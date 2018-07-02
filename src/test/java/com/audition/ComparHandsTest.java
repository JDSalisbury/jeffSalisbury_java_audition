package com.audition;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.audition.Objects.Card;
import com.audition.Objects.PlayerOne;
import com.audition.Objects.PlayerTwo;
import com.audition.Objects.PokerHand;

public class ComparHandsTest {
	private Card card1 = new Card('9', 'H');
	private Card card2 = new Card('T', 'H');
	private Card card3 = new Card('J', 'H');
	private Card card4 = new Card('Q', 'H');
	private Card card5 = new Card('K', 'H');
	private Card card6 = new Card('7', 'D');
	private PokerHand testHandForPlayerOne = new PokerHand(card1, card2, card3, card4, card5);
	private PokerHand testHandForPlayerTwo = new PokerHand(card1, card2, card3, card4, card6);

	@Test
	public void shouldCompareHandsToSeeWhosWasTheWinner() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		PlayerOne mark = new PlayerOne("Mark");
		PlayerTwo tom = new PlayerTwo("Tom");
		mark.addHand(testHandForPlayerOne);
		tom.addHand(testHandForPlayerTwo);
		CompareHands.comparePlayerHands(mark, tom);
		assertThat(out.toString(), is("Mark wins. - with StraightFlush! KH high"));
	}

}
