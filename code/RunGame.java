import java.util.Scanner;

public class RunGame {

  private TextGame m;
  Scanner reader = new Scanner(System.in);

  public RunGame(TextGame model) {
    m = model;
    System.out.println("I have picked a word, you have to guess it!");
    System.out.println("Here is the word: " + m.getVisible());
    System.out.print("Your guess: ");
    char c = reader.next().charAt(0);
    m.tryThis(c);
    System.out.println("Updated: " + m.getVisible());
  }

}

