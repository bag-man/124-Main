package uk.ac.aber.dcs.owg1.pirate;
import java.util.Scanner;

/**
 * The Class TextGame.
 */
public class TextGame {

  /** The m is short hand for Model */
  private GameModel m;
  
  /** The reader. */
  Scanner reader = new Scanner(System.in);

  /**
   * Instantiates a new text game.
   *
   * @param model the model
   */
  public TextGame(GameModel model) {
    m = model;

    while(!m.won() && m.guessLeft() != 0) {
      System.out.println("I have picked a pirate word, you have to guess it! Hint: it may use punctuation!");
      System.out.println("Here is the word: " + m.getVisible());
      System.out.println("You have " + m.guessLeft() + " guesses left");
      System.out.print("Your guess: ");
      String guess = reader.nextLine();

      if(guess.length() >1)
	m.tryWord(guess);
      else if (!guess.isEmpty())
	m.tryThis(guess.charAt(0));

      System.out.println("The word: " + m.getVisible());
      System.out.print("\033c"); //Clear screen in bash
    }
    if(m.won()) {
      System.out.println("Updated: " + m.getVisible());
      System.out.println("You have won!");
    } else {
      System.out.println("Sorry you lost! The word was: " + m.getHidden());
    }
  }
}
