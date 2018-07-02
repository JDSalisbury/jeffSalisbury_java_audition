package com.audition;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.audition.Objects.Hand;
import com.audition.Objects.PlayerOne;

public class InputReaderTest {

	@Test
	public void shouldReadInputAndGrabAllOfPlayerOnesGames() {
		List<PlayerOne> gamesBlack = InputReader.readPlayerOneFromInputFile("input.txt");
		assertThat(gamesBlack.size(), is(not(0)));
	}

	@Test
	public void shouldReadInputAndGrabAllOfPlayerOnesHands() {
		List<Hand> handsBlack = InputReader.readPlayerOnesCards("input.txt");
		assertThat(handsBlack.size(), is(not(0)));
	}
}
