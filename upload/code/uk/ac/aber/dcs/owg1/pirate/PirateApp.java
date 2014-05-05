package uk.ac.aber.dcs.owg1.pirate;

import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 * The Class PirateApp.
 */
public class PirateApp {
   
  /** The wordlist. */
  private static Dictionary wordlist;
  
  /** The model. */
  private static GameModel model;

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {

    try {
      wordlist = new Dictionary("piratewords.txt");
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    model = new GameModel(wordlist);

    if(args.length != 0 && args[0].equals("-text")) {
      TextGame theGame = new TextGame(model); 
    } else {
    
      SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
	      SwingGame theGame = new SwingGame(model);
    	  theGame.setVisible(true);
	    }
      });

    }

  }

}
