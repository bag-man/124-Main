import java.io.IOException;

public class TestTextGame {

  public static void main(String[] args) {
    try {
      Dictionary wordlist = new Dictionary("../piratewords.txt");
      TextGame newGame = new TextGame(wordlist);
      System.out.println(newGame.getLetters());
      System.out.println("Guessing 'e'");
      newGame.tryThis('e');
      System.out.println(newGame.getLetters());
    } catch (IOException e) {
      System.out.println("Error " + e);
    }
  }

}
