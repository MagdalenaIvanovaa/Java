package bg.uni_sofia.fmi.wordsearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FindWords implements AutoCloseable {

	private Path chosenPath;
	private HashMap<String, HashSet<String>> foundWords;
	private HashSet<String> set;
	private BufferedReader bufferReader;

	public FindWords(Path chosenPath, String[] arr) throws IOException {
		this.chosenPath = chosenPath;
		this.searchForWords(chosenPath, arr);
	}

	private void searchForWords(Path chosenPath, String[] arr) throws IOException {

		foundWords = new HashMap<>();
		set = null;

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(chosenPath)) {
			for (Path p : directoryStream) {
				this.bufferReader = new BufferedReader(new FileReader(p.toString()));
				String line;
				while ((line = bufferReader.readLine()) != null) {
					for (int i = 0; i < arr.length; i++) {
						if (line.contains(arr[i])) {
							set = foundWords.get(arr[i]);
							if (set == null) {
								set = new HashSet<String>();
							}
							set.add(p.getFileName().toString());
							foundWords.put(arr[i], set);
						}

					}
				}
			}
			for (int i = 0; i < arr.length; i++) {
				if (foundWords.containsKey(arr[i])) {
					continue;
				} else {
					set = foundWords.get(arr[i]);
					if (set == null) {
						set = new HashSet<String>();
					}
					set.add("not found");
					foundWords.put(arr[i], set);
				}
			}
		}

		this.display(foundWords, set);
	}

	private void display(HashMap<String, HashSet<String>> foundWords, HashSet<String> set) {
		Set<String> keys = foundWords.keySet();

		TreeSet<String> sortedKeys = new TreeSet<>(keys);

		for (String key : sortedKeys) {
			String files = foundWords.get(key).toString().replaceAll("(^\\[|\\]$)", "").replace(",", "");
			System.out.print(key + " - " + files);
			System.out.println();
		}
	}

	public void close() throws Exception {
		this.bufferReader.close();
	}

}
