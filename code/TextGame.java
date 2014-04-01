import java.util.Scanner;

public class TextGame {

  private GameModel m;
  Scanner reader = new Scanner(System.in);

  public TextGame(GameModel model) {
    m = model;

    while(!m.won()) {
      System.out.println("I have picked a word, you have to guess it!");
      System.out.println("Here is the word: " + m.getVisible());
      System.out.print("Your guess: ");
      String guess = reader.nextLine();

      if(guess.length() >1)
	m.tryWord(guess);
      else
	m.tryThis(guess.charAt(0));

      System.out.println("Updated: " + m.getVisible());
      System.out.print("\033c"); //Clear screen in bash
    }
    System.out.println("Updated: " + m.getVisible());
    System.out.println("You have won!");
  }
}
