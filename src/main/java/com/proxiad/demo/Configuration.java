package com.proxiad.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Configuration {
	public static final int MAX_TRIES = 10;

	public static final int DEFAULT_SCORE = 20;
	public static final int HIGH_SCORE = 40;

	private static final List<Character> letters = Arrays.asList(new Character[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' });
	public static final Set<Character> ALPHABET = new TreeSet<Character>(letters);

	public static final String[] HIGH_SCORE_WORDS = { "Armadillo", "Capybara", "Caracal", "Cheetah", "Guanaco",
			"Peaflow", "Rattlesnake" };

	public static final String[] WORDS = { "Penguin", "Goose", "Tortoise", "Anaconda", "Condor", "Antelope", "Turkey",
			"Eagle", "Beetle", "Boa", "Bonobo", "Owl", "Butterfly", "Camel", "Chameleon", "Chimpanzee", "Chinchilla",
			"Salamander", "Leopard", "Cobra", "Dolphin", "Dragonfly", "Elephant", "Emu", "Flamingo", "Panda", "Giraffe",
			"Goat", "Sheep", "Gorilla", "Hedgehog", "Hippopotamus", "Hummingbird", "Iguana", "Jaguar", "Kangaroo",
			"Kiwi", "Koala", "Ladybug", "Lemur", "Gecko", "Shark", "Lion", "Lizard", "Orangutan", "Ostrich", "Otter",
			"Opossum", "Peccary", "Raccon", "Reindeer", "Rhinoceros", "Scorpion", "Crocodile", "Hyena", "Whale" };
}
