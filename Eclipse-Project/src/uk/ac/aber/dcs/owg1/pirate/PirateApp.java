package uk.ac.aber.dcs.owg1.pirate;

import java.io.IOException;
import javax.swing.SwingUtilities;

public class PirateApp {
   
  private static Dictionary wordlist;
  private static GameModel model;

  public static void main(String[] args) {

    try {
      wordlist = new Dictionary("piratewords.txt");
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    model = new GameModel(wordlist);

    if(args.length == 0) {
      System.out.println("You must specify -text or -GUI");
      System.exit(1);
    } else if(args[0].equals("-text")) {
      TextGame theGame = new TextGame(model); 
    } else if(args[0].equals("-GUI")) {
    
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
