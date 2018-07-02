package com.audition;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.audition.Objects.Card;
import com.audition.Objects.Hand;
import com.audition.Objects.PlayerOne;

public class InputReader {
	public static List<PlayerOne> readPlayerOneFromInputFile(String fileName) {
		List<PlayerOne> playerOnesGames = new ArrayList<>();

		Path pathToFile = Paths.get(fileName);
		try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
			String line = reader.readLine();

			while (line != null) {
				String[] setUp = line.split(" ");
				PlayerOne black = setUpPlayerOne(setUp);
				playerOnesGames.add(black);

				line = reader.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		return playerOnesGames;
	}

	private static PlayerOne setUpPlayerOne(String[] meta) {
		String name = meta[0];
		return new PlayerOne(name);
	}

	public static List<Hand> readPlayerOnesCards(String fileName) {
		List<Hand> cards = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
			String line = reader.readLine();
			while (line != null) {
				String[] setUp = line.split(" ");
				Hand hand = setUpHandBlack(setUp);
				cards.add(hand);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cards;
	}

	private static Hand setUpHandBlack(String[] meta) {
		Card card1 = new Card(meta[1].charAt(0), meta[1].charAt(1));
		Card card2 = new Card(meta[2].charAt(0), meta[2].charAt(1));
		Card card3 = new Card(meta[3].charAt(0), meta[3].charAt(1));
		Card card4 = new Card(meta[4].charAt(0), meta[4].charAt(1));
		Card card5 = new Card(meta[5].charAt(0), meta[5].charAt(1));
		return new Hand(card1, card2, card3, card4, card5);
	}

	public static void addHandToPlayerOne(List<PlayerOne> games, List<Hand> hands, String fileName) throws IOException {
		Path pathToFile = Paths.get(fileName);
		List<String> linesInFile = Files.readAllLines(pathToFile);
		int indexLine = 0;

		for (PlayerOne game : games) {
			for (Hand hand : hands) {
				if (linesInFile.get(indexLine).toString().contains(game.getName())
						&& linesInFile.get(indexLine).toString().contains(hand.toString())
						&& game.getHand().isEmpty()) {
					game.addHand(hand);
					if (indexLine < linesInFile.size() - 1)
						indexLine++;
				}

			}

		}

	}

}
