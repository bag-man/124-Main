import java.io.IOException;

public class TestGameView {

  public static void main(String[] args) {
    try {
      Dictionary wordlist = new Dictionary("../piratewords.txt");
      GameModel model = new GameModel(wordlist);
      //TextGame theGame = new TextGame(model);
      SwingGame theGame = new SwingGame(model);
    } catch (IOException e) {
      System.out.println("Error " + e);
    }
  }

}
