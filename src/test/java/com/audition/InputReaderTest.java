package com.audition;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.audition.Objects.PlayerOne;
import com.audition.Objects.PokerHand;

public class InputReaderTest {

	private String inputFile = "input.txt";
	private List<PlayerOne> gamesBlack = InputReader.readPlayerOneFromInputFile(inputFile);
	private List<PokerHand> handsBlack = InputReader.readPlayerOnesCards(inputFile);

	@Test
	public void shouldReadInputAndGrabAllOfPlayerOnesGames() {
		assertThat(gamesBlack.size(), is(not(0)));
	}

	@Test
	public void shouldReadInputAndGrabAllOfPlayerOnesHands() {
		assertThat(handsBlack.size(), is(not(0)));
	}

	@Test
	public void shouldAddHandsToPlayer() throws IOException {
		InputReader.addHandToPlayerOne(gamesBlack, handsBlack, inputFile);
		List<PokerHand> lastGameInInputFile = null;
		for (PlayerOne games : gamesBlack) {
			lastGameInInputFile = games.getHand();
		}
		assertThat(lastGameInInputFile.size(), is(not(0)));
	}
}
