package com.proxiad.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameInitializationTest {
	private Game game;
	
	@BeforeEach
	public void init() {
		Dictionary dictionary = new Dictionary();
		game = new Game(dictionary, "Niki", false);
	}

	@Test
	public void testNewGame() {
		
		assertNotNull(game.getPlayer());
		assertEquals(20, game.getPlayer().getCurrentScore());
		assertEquals(0, game.getPlayer().getFinalScore());
		assertEquals("Niki", game.getPlayer().getName());
		assertEquals(10, game.getTriesLeft());
	}
	
	@Test
	public void testMakeTry() {
		game.makeTry('x');
		
		assertEquals(18, game.getPlayer().getCurrentScore());
		assertEquals(0, game.getPlayer().getFinalScore());
		assertEquals(9, game.getTriesLeft());
	}
	
	@Test
	public void testInvalidLetter() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> game.makeTry('1'));
		assertEquals("Letter not in Alphabet", ex.getMessage());
	}
	
	@Test
	public void testDuplicateLetter() {
		game.makeTry('x');
		
		Exception ex = assertThrows(IllegalArgumentException.class, () -> game.makeTry('x'));
		assertNotEquals("Letter not in Alphabet", ex.getMessage());
	}
	
}
