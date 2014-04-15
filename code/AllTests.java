import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;

public class AllTests {

  private GameModel model;
  private Dictionary wordlist;

  @Before
  public void init() {

    try {
      wordlist = new Dictionary("../word.txt"); //This file contains a single word, "ahoy".
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    model = new GameModel(wordlist);

  }

  @Test
  public void testVisible() { 
    assertEquals("Word has not been censored.", model.getVisible(), "****");
    model.tryThis('a');
    assertEquals("Word has not had a character revealed.", model.getVisible(), "a***");
  }

  @Test
  public void testHidden() { 
    assertEquals("Word has not loaded correctly.", model.getHidden(), "ahoy");
  }

  @Test
  public void testGuessLeft() { 
    assertEquals("Guesses haven't been set at 10.", model.guessLeft(), 10);
    model.tryThis('x');
    assertEquals("Guesses haven't been reduced.", model.guessLeft(), 9);
  }

  @Test
  public void testGetLetters() { 
    model.tryThis('x');
    assertEquals("Incorrect guess not added to string.", model.getLetters(), "x ");
    model.tryThis('z');
    assertEquals("Incorrect guess not added to string.", model.getLetters(), "x z ");
  }

  @Test
  public void testTryThis() { 
    assertEquals("Character has not been found.", model.tryThis('a'), true);
  }

  @Test
  public void testTryWord() { 
    assertEquals("Word has not been found.", model.tryWord("ahoy"), true);
  }

  @Test
  public void testWon() { 
    model.tryWord("ahoy");
    assertEquals("Game has not been won.", model.won(), true);
  }

}
