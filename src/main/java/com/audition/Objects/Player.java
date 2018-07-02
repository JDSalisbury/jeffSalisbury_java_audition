package com.audition.Objects;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Hand> cards = new ArrayList<>();

	public Player(String name) {
	}

	public List<Hand> getHand() {
		return cards;
	}

	public void addHand(Hand card) {
		cards.add(card);
	}

}
