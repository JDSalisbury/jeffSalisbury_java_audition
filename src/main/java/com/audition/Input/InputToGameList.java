package com.audition.Input;

import java.io.IOException;
import java.util.List;

import com.audition.Objects.PokerHand;
import com.audition.Player.PlayerOne;
import com.audition.Player.PlayerTwo;

public class InputToGameList {

	public static List<PlayerOne> playerOneStart() throws IOException {
		List<PlayerOne> games = InputReader.readPlayerOneFromInputFile("input.txt");
		List<PokerHand> hands = InputReader.readPlayerOnesCards("input.txt");
		InputReader.addHandToPlayerOne(games, hands, "input.txt");
		return games;
	}

	public static List<PlayerTwo> playerTwoStart() throws IOException {
		List<PlayerTwo> games = InputReader.readPlayerTwoFromInputFile("input.txt");
		List<PokerHand> hands = InputReader.readPlayerTwosCards("input.txt");
		InputReader.addHandToPlayerTwo(games, hands, "input.txt");
		return games;
	}

}
