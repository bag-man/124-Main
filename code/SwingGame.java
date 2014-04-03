import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

public class SwingGame extends JFrame {

  private GameModel m;
  private JTextField inputArea1;
  private JLabel label1, label2, label3, pirateShip, pirate;
  private BufferedImage imagePirateShip, imagePirate;
  private int piratePos = 180, remainingGos;
  private String targetWord, usedLetters;

  public SwingGame(GameModel model) {
    m = model;
    targetWord = m.getVisible();
    remainingGos = m.guessLeft();

    // Window settings
    setTitle("Pirate Hangman!");
    setSize(340, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);        

    // Create panel
    JPanel panel = new JPanel();
    getContentPane().add(panel);
    panel.setLayout(null);

    // Create input field
    inputArea1 = new JTextField();
    inputArea1.setBounds(0, 0, 150, 25);
    panel.add(inputArea1);
  
    // Create label for targetWord
    label1 = new JLabel(targetWord);
    label1.setBounds(0,30,200,30);
    panel.add(label1);

    // Create label for usedLetters
    label2 = new JLabel(usedLetters);
    label2.setBounds(130,375,100,30);
    panel.add(label2);

    // Create label for remainingGos
    label3 = new JLabel(Integer.toString(remainingGos));
    label3.setBounds(200,375,100,30);
    panel.add(label3);

    // Add  the submit button
    panel.add(
      AddButton(150, 0, 120, 25, "Submit",  new Callable<Void>() {
	@Override
	 public Void call() {
	   return submitGuess();
	 }
      })
    );

    // Add  the reset button
    panel.add(
      AddButton(0, 375, 120, 25, "Reset",  new Callable<Void>() {
	@Override
	 public Void call() {
	   return resetGame();
	 }
      })
    );

    // Add images
    try {                
      imagePirateShip = ImageIO.read(new File("../img/ship.png"));
      imagePirate = ImageIO.read(new File("../img/pirate.png"));
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    pirateShip = new JLabel(new ImageIcon(imagePirateShip));
    pirate = new JLabel(new ImageIcon(imagePirate));
    pirateShip.setBounds(0,60,340,299);
    pirate.setBounds(180,185,22,44);

    panel.add(pirateShip);
    panel.add(pirate);
    panel.setComponentZOrder(pirate, 0); // Draw last

  }

  private JButton AddButton(int x, int y, int w, int h, String name, Callable<Void> function) {
    final Callable<Void> runThis = function;
    JButton submitButton = new JButton(name);
    submitButton.setBounds(x, y, w, h); 

    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        try {
	  runThis.call();
        } catch (Exception e) {
          System.out.println("Error: " + e);
        }
      }
    });
    
    return submitButton;
  }

  public Void resetGame() {
    inputArea1.setText("");
    while(!m.selectNewWord()){
      m.selectNewWord();
    }
    pirate.setBounds(180,185,22,44);
    piratePos = 180;
    targetWord = m.getVisible();
    label1.setText(targetWord);
    return null;
  }

  public Void submitGuess() {
    String guess = inputArea1.getText();
 
    if(guess.length() >1) {
      if(!m.tryWord(guess)) {
	piratePos += -5;
      }
    } else if (!guess.isEmpty()) {
      if(!m.tryThis(guess.charAt(0))) {
	piratePos += -5;
      }
    }
 
    targetWord = m.getVisible();
    label1.setText(targetWord);

    usedLetters = m.getLetters();
    label2.setText(usedLetters);

    remainingGos = m.guessLeft();
    label3.setText(Integer.toString(remainingGos));

    pirate.setBounds(piratePos,185,22,44);

    inputArea1.setText("");
    return null;
  }
}
