import java.io.IOException;
import javax.swing.SwingUtilities;

public class TestGameView {
   
  private static Dictionary wordlist;
  private static GameModel model;

  public static void main(String[] args) {

    try {
      wordlist = new Dictionary("../piratewords.txt");
    } catch (IOException e) {
      System.out.println("Error " + e);
    }

    model = new GameModel(wordlist);

    //TextGame theGame = new TextGame(model); 

    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
	SwingGame theGame = new SwingGame(model);
	theGame.setVisible(true);
      }

    });

  }

}
