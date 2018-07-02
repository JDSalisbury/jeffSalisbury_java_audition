package com.audition.Objects;

import java.util.ArrayList;
import java.util.List;

public class Player {

	protected List<Hand> cards = new ArrayList<>();
	protected String name;

	public Player(String name) {
		this.name = name;
	}

	public List<Hand> getHand() {
		return cards;
	}

	public void addHand(Hand card) {
		cards.add(card);
	}

}
