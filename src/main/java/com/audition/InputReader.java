package com.audition;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
}
