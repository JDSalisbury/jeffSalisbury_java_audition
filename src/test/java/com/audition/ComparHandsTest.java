package com.audition;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.audition.Objects.Card;
import com.audition.Objects.CompareHands;
import com.audition.Objects.PokerHand;
import com.audition.Player.PlayerOne;
import com.audition.Player.PlayerTwo;

public class ComparHandsTest {
	private Card card1 = new Card('9', 'H');
	private Card card2 = new Card('T', 'H');
	private Card card3 = new Card('J', 'H');
	private Card card4 = new Card('Q', 'H');
	private Card card5 = new Card('K', 'H');
	private Card card6 = new Card('7', 'H');
	private Card card7 = new Card('8', 'H');
	private PlayerOne mark = new PlayerOne("Mark");
	private PlayerTwo tom = new PlayerTwo("Tom");
	private ByteArrayOutputStream out = new ByteArrayOutputStream();
	private PokerHand testTiedHand = new PokerHand(card1, card2, card3, card4, card5);

	@Test
	public void shouldCompareHandsToSeeWhosWasTheWinner() {
		System.setOut(new PrintStream(out));
		PokerHand testHandForPlayerOne = new PokerHand(card1, card2, card3, card4, card5);
		PokerHand testHandForPlayerTwo = new PokerHand(card1, card2, card3, card4, card6);
		mark.addHand(testHandForPlayerOne);
		tom.addHand(testHandForPlayerTwo);
		CompareHands.comparePlayerHands(mark, tom);
		assertThat(out.toString(), is("Mark wins - with StraightFlush! KH high\n"));
	}

	@Test
	public void shouldCompareHandsToSeeWhosWasTheWinnerShouldBeTom() {
		System.setOut(new PrintStream(out));
		PokerHand testHandForPlayerOne = new PokerHand(card1, card2, card3, card4, card5);
		PokerHand testHandForPlayerTwo = new PokerHand(card1, card2, card3, card4, card6);
		tom.addHand(testHandForPlayerOne);
		mark.addHand(testHandForPlayerTwo);
		CompareHands.comparePlayerHands(mark, tom);
		assertThat(out.toString(), is("Tom wins - with StraightFlush! KH high\n"));
	}

	@Test
	public void shouldCompareHandsToSeeIfTheyAreTied() {
		System.setOut(new PrintStream(out));
		mark.addHand(testTiedHand);
		tom.addHand(testTiedHand);
		CompareHands.comparePlayerHands(mark, tom);
		assertThat(out.toString(), is("Tie.\n"));

	}

	@Test
	public void shouldCompareHandsToSeeWhoWinsOnATieShouldGoToNextHighCard() {
		System.setOut(new PrintStream(out));
		PokerHand testHandForPlayerOne = new PokerHand(card1, card2, card3, card4, card5);
		PokerHand testHandForPlayerTwo = new PokerHand(card1, card2, card3, card6, card7);
		mark.addHand(testHandForPlayerOne);
		tom.addHand(testHandForPlayerTwo);
		CompareHands.comparePlayerHands(mark, tom);
		assertThat(out.toString(), is("Mark Ties with Tom - with StraightFlush! KH high Mark wins with KH high\n"));
	}

	@Test
	public void shouldCompareHandsToSeeWhoWinsInATieWith4OfAKind() {
		System.setOut(new PrintStream(out));
		PokerHand testHandForPlayerOne = new PokerHand(card1, card5, card5, card5, card5);
		PokerHand testHandForPlayerTwo = new PokerHand(card1, card7, card7, card7, card7);
		mark.addHand(testHandForPlayerOne);
		tom.addHand(testHandForPlayerTwo);
		CompareHands.comparePlayerHands(mark, tom);
		assertThat(out.toString(), is("Mark Ties with Tom - with Four of a Kind! Mark wins with 13 high\n"));
	}

}
