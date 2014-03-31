import java.io.IOException;

public class TestTextGame {

  public static void main(String[] args) {
    try {
      Dictionary wordlist = new Dictionary("../piratewords.txt");
      TextGame model = new TextGame(wordlist);
      RunGame theGame = new RunGame(model);
    } catch (IOException e) {
      System.out.println("Error " + e);
    }
  }

}
