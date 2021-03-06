import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.imageio.ImageIO;

public class SwingGame extends JFrame {

  private GameModel m;
  private JTextField inputArea1;
  private JLabel label1, label2, label3, pirateShip, pirate;
  private JDialog popup;
  private BufferedImage imagePirateShip, imagePirate;
  private int piratePos = 180, remainingGos;
  private String targetWord, usedLetters;

  public SwingGame(GameModel model) {

    m = model;
    targetWord = m.getVisible();
    remainingGos = m.guessLeft();
    createGui();

  }

  private Void submitGuess() {

    String guess = inputArea1.getText();
 
    if(guess.length() >1) {
      if(!m.tryWord(guess)) {
	piratePos += -70;
      }
    } else if (!guess.isEmpty()) {
      if(!m.tryThis(guess.charAt(0))) {
	piratePos += -14;
      }
    }
 
    updateText();
    pirate.setBounds(piratePos,125,22,44);
    inputArea1.setText("");
 
    if(m.won())
      popUp("Congratulations, you have won!");
    else if(m.guessLeft() == 0)
      loseGame();

    return null;

  }

  private Void resetGame() {

    inputArea1.setText("");

    while(!m.selectNewWord()){
      m.selectNewWord();
    }

    pirate.setBounds(180,125,22,44);
    piratePos = 180;
    updateText();
    if(popup != null)
      popup.dispose();

    return null;

  }

  private void loseGame() {

    int pos = 125;
    pirate.setBounds(piratePos,pos+50,22,44);
    popUp("Sorry you lost! Better luck next time!");

  }


  private Void exit() {

    System.exit(0);
    return null;

  }


  private JButton AddButton(int x, int y, int w, int h, String name, Callable<Void> function) {

    final Callable<Void> runThis = function;
    JButton button = new JButton(name);
    button.setBounds(x, y, w, h); 

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        try {
	  runThis.call();
        } catch (Exception e) {
          System.out.println("Error: " + e);
        }
      }
    });
    
    return button;

  }

  private void updateText() {

    targetWord = m.getVisible();
    label1.setText(targetWord);

    usedLetters = m.getLetters();
    label2.setText(usedLetters);

    remainingGos = m.guessLeft();
    label3.setText(Integer.toString(remainingGos));
    inputArea1.requestFocusInWindow();

  }

  private void popUp(String message) {

    JButton quitButton = AddButton(0, 0, 120, 25, "Quit",  new Callable<Void>() {
      @Override
      public Void call() {
        return exit();
      }
    });

    JButton retryButton = AddButton(0, 0, 120, 25, "Try Again?",  new Callable<Void>() {
      @Override
      public Void call() {
        return resetGame();
      }
    });

    JLabel infoMessage = new JLabel(message);
    infoMessage.setBounds(0, 0, 100, 30);

    JPanel dialogPanel = new JPanel();
    dialogPanel.add(infoMessage);
    dialogPanel.add(retryButton);
    dialogPanel.add(quitButton);

    popup = new JDialog();
    popup.setSize(300,70);
    popup.setResizable(false);
    popup.setUndecorated(true);
    popup.setLocationRelativeTo(this);
    Point p = getLocationOnScreen();
    popup.setLocation(p.x + 20, p.y + 220);
    popup.add(dialogPanel);
    popup.setVisible(true);

  }

  private void createGui() {

    // Window settings
    setTitle("Pirate Hangman!");
    setSize(340, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);        
    setResizable(false);

    // Create panel
    JPanel panel = new JPanel();
    getContentPane().add(panel);
    panel.setLayout(null);

    // Create input field
    inputArea1 = new JTextField();
    inputArea1.setBounds(0, 300, 220, 25);
    panel.add(inputArea1);
  
    // Create label for targetWord
    label1 = new JLabel(targetWord);
    label1.setBounds(0,324,200,30);
    panel.add(label1);

    // Create label for usedLetters
    label2 = new JLabel(usedLetters);
    label2.setBounds(0,375,200,30);
    panel.add(label2);

    // Create label for remainingGos
    label3 = new JLabel(Integer.toString(remainingGos));
    label3.setBounds(320,375,100,30);
    panel.add(label3);

    // Create label for Lives left 
    JLabel label4 = new JLabel("Lives Left");
    label4.setBounds(270,355,100,30);
    panel.add(label4);

    // Create label for Wrong Letters
    JLabel label5 = new JLabel("Wrong Letters");
    label5.setBounds(0,355,200,30);
    panel.add(label5);

    JSeparator line = new JSeparator();
    line.setBounds(0,360,340,2);
    panel.add(line);


    // Create submit button
    JButton submitButton = AddButton(220, 299, 120, 25, "Submit",  new Callable<Void>() {
      @Override
      public Void call() {
        return submitGuess();
      }
    });

    // Add  the submit button
    panel.add(submitButton);
    getRootPane().setDefaultButton(submitButton);

    // Create the reset button
    JButton resetButton = AddButton(220, 324, 120, 25, "Reset",  new Callable<Void>() {
      @Override
      public Void call() {
      	return resetGame();
      }
    });

    // Add  the reset button
    panel.add(resetButton);

    // Add images
    try {                
      imagePirateShip = ImageIO.read(new File("../img/ship.png"));
      imagePirate = ImageIO.read(new File("../img/pirate.png"));
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    pirateShip = new JLabel(new ImageIcon(imagePirateShip));
    pirate = new JLabel(new ImageIcon(imagePirate));
    pirateShip.setBounds(0,0,340,299);
    pirate.setBounds(180,125,22,44);

    panel.add(pirateShip);
    panel.add(pirate);
    panel.setComponentZOrder(pirate, 0); // Draw last

  }
}
