import java.io.IOException;

public class TestTextGame {

  public static void main(String[] args) {
    try {
      Dictionary wordlist = new Dictionary("../piratewords.txt");
    } catch (IOException e) {
      System.out.println("Error " + e);
    }
    TextGame newGame = new TextGame(wordlist);
  }

}
