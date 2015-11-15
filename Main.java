package bg.uni_sofia.fmi.wordsearch;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	private static Scanner input;

	public static void main(String[] args) throws Exception {

		input = new Scanner(System.in);
		Path chosenPath = Paths.get(input.nextLine());

		int wordsNum = input.nextInt();
		String[] words = new String[wordsNum];
		for (int i = 0; i < words.length; i++) {
			words[i] = input.next();
		}

		try (FindWords fW = new FindWords(chosenPath, words)) {
		}
	}
}
