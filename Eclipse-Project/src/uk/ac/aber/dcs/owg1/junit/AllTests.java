package uk.ac.aber.dcs.owg1.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

import uk.ac.aber.dcs.owg1.pirate.GameModel;
import uk.ac.aber.dcs.owg1.pirate.Dictionary;

import java.io.IOException;

/* To run these tests, at the command line run; "java org.junit.runner.JUnitCore AllTests", and ensure that junit.jar is in your classpath. */

/**
 * The Class AllTests.
 */
public class AllTests {

  /** The model. */
  private GameModel model;
  
  /** The wordlist. */
  private Dictionary wordlist;

  /**
   * Initialises the tests
   */
  @Before
  public void init() {

    try {
      wordlist = new Dictionary("src/uk/ac/aber/dcs/owg1/junit/word.txt"); //This file contains a single word, "ahoy".
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    model = new GameModel(wordlist);

  }

  /**
   * Test visible.
   */
  @Test
  public void testVisible() { 
    assertEquals("Word has not been censored.", model.getVisible(), "****");
    model.tryThis('a');
    assertEquals("Word has not had a character revealed.", model.getVisible(), "a***");
  }

  /**
   * Test hidden.
   */
  @Test
  public void testHidden() { 
    assertEquals("Word has not loaded correctly.", model.getHidden(), "ahoy");
  }

  /**
   * Test guess left.
   */
  @Test
  public void testGuessLeft() { 
    assertEquals("Guesses haven't been set at 10.", model.guessLeft(), 10);
    model.tryThis('x');
    assertEquals("Guesses haven't been reduced.", model.guessLeft(), 9);
  }

  /**
   * Test get letters.
   */
  @Test
  public void testGetLetters() { 
    model.tryThis('x');
    assertEquals("Incorrect guess not added to string.", model.getLetters(), "x ");
    model.tryThis('z');
    assertEquals("Incorrect guess not added to string.", model.getLetters(), "x z ");
  }

  /**
   * Test try this.
   */
  @Test
  public void testTryThis() { 
    assertEquals("Character has not been found.", model.tryThis('a'), true);
  }

  /**
   * Test try word.
   */
  @Test
  public void testTryWord() { 
    assertEquals("Word has not been found.", model.tryWord("ahoy"), true);
  }

  /**
   * Test won.
   */
  @Test
  public void testWon() { 
    model.tryWord("ahoy");
    assertEquals("Game has not been won.", model.won(), true);
  }

}
