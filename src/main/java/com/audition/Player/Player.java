package com.audition.Player;

import java.util.ArrayList;
import java.util.List;

import com.audition.Objects.PokerHand;

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
