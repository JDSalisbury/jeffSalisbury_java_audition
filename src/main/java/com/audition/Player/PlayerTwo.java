package com.audition.Player;

public class PlayerTwo extends PokerPlayer {

	public PlayerTwo(String name) {
		super(name);
	}

	public String toString() {
		return name + " " + getHand().toString().substring(1, getHand().toString().length() - 1);
	}

}
