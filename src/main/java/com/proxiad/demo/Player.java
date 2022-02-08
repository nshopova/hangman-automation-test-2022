package com.proxiad.demo;

public class Player {
	private String name;
	private int currentScore;
	private int finalScore;

	public Player(String name, int initialScore) {
		this.name = name;
		this.currentScore = initialScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
}
