package com.proxiad.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FinishedGameTest {
	@Mock
	private Dictionary dictionary;
	
	@BeforeEach
	public void init() {
		when(dictionary.getDefaultScore()).thenCallRealMethod();
		when(dictionary.getRandomWord(anyBoolean())).thenReturn("Penguin");
		when(dictionary.getAlphabet()).thenCallRealMethod();
		when(dictionary.getMaxTries()).thenReturn(10);
	}
	
	@Test
	public void guessTheWord() {
		Game game = new Game(dictionary, "Niki", false);
		
		game.makeTry('u');
		game.makeTry('e');
		game.makeTry('g');
		game.makeTry('i');
		
		Assertions.assertThat(game.getMaskedWord()).isEqualTo("Penguin");
		Assertions.assertThat(game.getPlayer().getFinalScore()).isEqualTo(20);
	}
	
	@Test
	public void wordAlreadyGuessed() {
		Game game = new Game(dictionary, "Niki", false);
		
		game.makeTry('u');
		game.makeTry('e');
		game.makeTry('g');
		game.makeTry('i');
		
		assertThrows(IllegalStateException.class, () -> game.makeTry('w'));
		
	}
	
	@DisplayName("Test that we cannot exceed max number of tries")
	@Test
	public void reachMaxTries() {
		when(dictionary.getMaxTries()).thenReturn(2);
		
		Game game = new Game(dictionary, "Niki", false);
		
		game.makeTry('u');
		game.makeTry('e');
		
		assertThrows(IllegalStateException.class, () -> game.makeTry('g'));
		assertEquals(0, game.getPlayer().getFinalScore());
	}
}
