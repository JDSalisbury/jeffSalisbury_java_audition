package com.audition.Objects;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
	protected String name;
	protected List<PokerHand> cards = new ArrayList<>();

	public String getName() {
		return name;
	}

	public List<PokerHand> getHand() {
		return cards;
	}

	public void addHand(PokerHand card) {
		cards.add(card);
	}
}
