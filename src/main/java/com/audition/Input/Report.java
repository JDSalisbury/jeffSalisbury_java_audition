package com.audition.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.audition.Objects.CompareHands;
import com.audition.Player.PlayerOne;
import com.audition.Player.PlayerTwo;

public class Report {

	public static void reportPerLine(List<PlayerOne> gamesOne, List<PlayerTwo> gamesTwo) throws IOException {
		int locationInFile = 0;
		Path pathToFile = Paths.get("input.txt");
		List<String> linesInFile = Files.readAllLines(pathToFile);
		for (PlayerOne name : gamesOne) {
			for (PlayerTwo name2 : gamesTwo) {
				if (linesInFile.get(locationInFile).toString().contains(name.toString())
						&& linesInFile.get(locationInFile).toString().contains(name2.toString())) {
					CompareHands.comparePlayerHands(name, name2);
					if (locationInFile < linesInFile.size() - 1)
						locationInFile++;
				}

			}
		}
	}

}
