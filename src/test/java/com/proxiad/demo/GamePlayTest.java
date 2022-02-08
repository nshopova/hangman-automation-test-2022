package com.proxiad.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePlayTest {
	private Dictionary dictionary;
	
	@BeforeEach
	public void init() {
		dictionary = mock(Dictionary.class);
		when(dictionary.getDefaultScore()).thenCallRealMethod();
		when(dictionary.getRandomWord(anyBoolean())).thenReturn("Penguin");
		when(dictionary.getAlphabet()).thenCallRealMethod();
		when(dictionary.getMaxTries()).thenReturn(10);
	}
	
	@Test
	public void testMaskedWord() {
//		when(dictionary.getRandomWord(anyBoolean())).thenReturn("Penguin");
		
		when(dictionary.getRandomWord(eq(true))).thenReturn("Penguin");
		when(dictionary.getRandomWord(eq(false))).thenReturn("Cat");
		
		Game game = new Game(dictionary, "Niki", false);
		
		assertEquals("C*t", game.getMaskedWord());
		
		Game game2 = new Game(dictionary, "Petar", true);
		
		assertEquals("P*n***n", game2.getMaskedWord());
		
	}
	
	@Test
	public void initGame() {
		Game game = new Game(dictionary, "Niki", false);
		
		verify(dictionary, never()).getHighScore();
		verify(dictionary, times(1)).getRandomWord(false);
		
		assertEquals("P*n***n", game.getMaskedWord());
		assertEquals(20, game.getPlayer().getCurrentScore());
		
	}
	
	@Test
	public void makeTry() {
		Game game = new Game(dictionary, "Niki", false);
		game.makeTry('u');
		
		assertEquals("P*n*u*n", game.getMaskedWord());
		assertEquals(20, game.getPlayer().getCurrentScore());
		assertEquals(0, game.getPlayer().getFinalScore());
		assertEquals(9, game.getTriesLeft());
	}
	
	@Test
	public void makeTry_wrongLetter() {
		Game game = new Game(dictionary, "Niki", false);
		game.makeTry('r');
		
		assertEquals("P*n***n", game.getMaskedWord());
		assertEquals(18, game.getPlayer().getCurrentScore());
		assertEquals(0, game.getPlayer().getFinalScore());
		assertEquals(9, game.getTriesLeft());
	}
}
