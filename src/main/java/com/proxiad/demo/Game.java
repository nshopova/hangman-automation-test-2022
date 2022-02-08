package com.proxiad.demo;

import java.util.Set;
import java.util.TreeSet;

public class Game {
	private Dictionary dictionary;

	private Player player;

	private String word;
	private String maskedWord;

	private int tries;
	private Set<Character> lettersLeft;

	public Game(Dictionary dictionary, String playerName, boolean highScore) {
		this.dictionary = dictionary;
		int score = highScore ? dictionary.getHighScore() : dictionary.getDefaultScore();
		player = new Player(playerName, score);
		word = dictionary.getRandomWord(highScore);
		maskedWord = generateMaskedWord(word);
		lettersLeft = getLettersLeft(word, dictionary);
	}

	public void makeTry(Character letter) {
		if (!dictionary.getAlphabet().contains(letter)) {
			throw new IllegalArgumentException("Letter not in Alphabet");
		}
		if (!lettersLeft.contains(letter)) {
			throw new IllegalArgumentException("Letter already used");
		}
		if (tries >= dictionary.getMaxTries()) {
			throw new IllegalStateException("Reached the allowed number of tries");
		}
		if (maskedWord.equals(word)) {
			throw new IllegalStateException("Word already guessed");
		}

		checkLetter(letter);
		lettersLeft.remove(letter);
		tries++;

		if (maskedWord.equals(word)) {
			player.setFinalScore(player.getCurrentScore());
		}
	}

	public Player getPlayer() {
		return player;
	}

	public String getMaskedWord() {
		return maskedWord;
	}

	public int getTriesLeft() {
		return dictionary.getMaxTries() - tries;
	}

	private String generateMaskedWord(String word) {
		char fc = word.charAt(0);
		char lc = word.charAt(word.length() - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char current = word.charAt(i);
			char c = current == fc || current == lc ? current : '*';
			sb.append(c);
		}
		return sb.toString();
	}

	private Set<Character> getLettersLeft(String word, Dictionary dictionary) {
		char fc = word.charAt(0);
		char lc = word.charAt(word.length() - 1);

		Set<Character> letters = new TreeSet<Character>();
		for (char c : dictionary.getAlphabet()) {
			letters.add(c);
		}
		letters.remove(fc);
		letters.remove(lc);
		return letters;
	}

	private void checkLetter(Character ch) {
		StringBuilder sb = new StringBuilder();
		boolean hasMatch = false;
		for (int i = 0; i < word.length(); i++) {
			char current = word.charAt(i);
			char c = maskedWord.charAt(i);;
			if (current == ch) {
				c = current;
				hasMatch = true;
			}
			sb.append(c);
		}
		if (!hasMatch) {
			player.setCurrentScore(player.getCurrentScore() - 2);
		}
		maskedWord = sb.toString();
	}
}
