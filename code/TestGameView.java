import java.io.IOException;
import javax.swing.SwingUtilities;

public class TestGameView {

  public static void main(String[] args) {
    try {


      SwingUtilities.invokeLater(new Runnable() {

	Dictionary wordlist = new Dictionary("../piratewords.txt");
	GameModel model = new GameModel(wordlist);

	@Override
	public void run() {
	  SwingGame theGame = new SwingGame(model);
	  theGame.setVisible(true);
	}

      });


    } catch (IOException e) {
      System.out.println("Error " + e);
    }
  }

}
