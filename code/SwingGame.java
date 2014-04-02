import javax.swing.JFrame;

/* Remember to turn on window decor!!! */

public class SwingGame extends JFrame {

  private GameModel m;

  public SwingGame(GameModel model) {
    m = model;

    setTitle("Pirate Hangman!");
    setSize(500, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);        

  }

}
