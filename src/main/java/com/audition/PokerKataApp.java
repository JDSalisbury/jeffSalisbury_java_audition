package com.audition;

import java.io.IOException;
import java.util.List;

import com.audition.Input.InputToGameList;
import com.audition.Input.Report;
import com.audition.Player.PlayerOne;
import com.audition.Player.PlayerTwo;

public class PokerKataApp {

	public static void main(String[] args) throws IOException {

		List<PlayerOne> gamesOne = InputToGameList.playerOneStart();
		List<PlayerTwo> gamesTwo = InputToGameList.playerTwoStart();

		Report.reportPerLine(gamesOne, gamesTwo);

	}
}
