import java.io.IOException;

public class TestTextGame {

  public static void main(String[] args) {
    try {
      Dictionary wordlist = new Dictionary("../piratewords.txt");
      TextGame newGame = new TextGame(wordlist);
    } catch (IOException e) {
      System.out.println("Error " + e);
    }
  }

}
