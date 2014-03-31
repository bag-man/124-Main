import java.util.Scanner;

public class RunGame {

  private TextGame m;
  Scanner reader = new Scanner(System.in);

  public RunGame(TextGame model) {
    m = model;
    System.out.println("I have picked a word, you have to guess it!");
    System.out.print("Your guess: ");
    char c = reader.next().charAt(0);
    System.out.println("Well that happened.");
  }

}

