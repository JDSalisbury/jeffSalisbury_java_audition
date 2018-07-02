package com.audition;

import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void shouldGetPlayersHand() {
		Player underTest = new Player("Mark");

		assertThat(underTest.getHand(), containsInAnyOrder("9H", "TH", "JH", "QH", "KH"));
	}
}
