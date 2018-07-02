package com.audition;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.audition.Objects.Hand;
import com.audition.Objects.PlayerOne;

public class InputReaderTest {

	private List<PlayerOne> gamesBlack = InputReader.readPlayerOneFromInputFile("input.txt");
	private List<Hand> handsBlack = InputReader.readPlayerOnesCards("input.txt");

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
		InputReader.addHandToPlayerOne(gamesBlack, handsBlack, "input.txt");
		List<Hand> lastGameInInputFile = null;
		for (PlayerOne games : gamesBlack) {
			lastGameInInputFile = games.getHand();
		}
		assertThat(lastGameInInputFile.size(), is(1));

	}
}
