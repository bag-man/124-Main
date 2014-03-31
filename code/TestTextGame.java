import java.io.IOException;

public class TestTextGame {

  public static void main(String[] args) {
    try {
      Dictionary wordlist = new Dictionary("../piratewords.txt");
      TextGame newGame = new TextGame(wordlist);
      RunGame theGame = new RunGame(newGame);
    } catch (IOException e) {
      System.out.println("Error " + e);
    }
  }

}
