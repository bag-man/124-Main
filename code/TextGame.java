import java.util.Scanner;

public class TextGame {

  private GameModel m;
  Scanner reader = new Scanner(System.in);

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
      else
	m.tryThis(guess.charAt(0)); //Crashes if there is no input

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
