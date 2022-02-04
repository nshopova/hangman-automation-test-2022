package com.proxiad.demo;

import static com.proxiad.demo.Configuration.ALPHABET;
import static com.proxiad.demo.Configuration.DEFAULT_SCORE;
import static com.proxiad.demo.Configuration.HIGH_SCORE;
import static com.proxiad.demo.Configuration.HIGH_SCORE_WORDS;
import static com.proxiad.demo.Configuration.MAX_TRIES;
import static com.proxiad.demo.Configuration.WORDS;

import java.util.Random;
import java.util.Set;

public class Dictionary {

	public String getRandomWord(boolean highScore) {
		String[] words = highScore ? HIGH_SCORE_WORDS : WORDS;
		int index = new Random().nextInt(words.length);
		return words[index];
	}
	
	public Set<Character> getAlphabet() {
		return ALPHABET;
	}

	public int getDefaultScore() {
		return DEFAULT_SCORE;
	}

	public int getHighScore() {
		return HIGH_SCORE;
	}

	public int getMaxTries() {
		return MAX_TRIES;
	}
	
}
