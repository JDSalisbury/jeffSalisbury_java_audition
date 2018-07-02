package com.audition.Player;

public class PlayerOne extends PokerPlayer {

	public PlayerOne(String name) {
		super(name);
	}

	public String toString() {
		return name + " " + getHand().toString().substring(1, getHand().toString().length() - 1);
	}

}
