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

/* Remember to turn on window decor!!! */

public class SwingGame extends JFrame {

  private GameModel m;
  private JTextField inputArea1;
  private JLabel label1, pirateShip, pirate;
  private BufferedImage imagePirateShip, imagePirate;

  public SwingGame(GameModel model) {
    m = model;

    // Window settings
    setTitle("Pirate Hangman!");
    setSize(500, 500);
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
  
    // Create label
    label1 = new JLabel("This is a pirate hangman game." + m.getVisible());
    label1.setBounds(0,30,500,30);
    panel.add(label1);

    // Add  the submit button
    panel.add(
      AddButton(150, 0, 120, 25, "Submit",  new Callable<Void>() {
	@Override
	 public Void call() {
	   return submitGuess();
	 }
      })
    );

    try {                
      imagePirateShip = ImageIO.read(new File("../img/ship.jpg"));
      imagePirate = ImageIO.read(new File("../img/pirate.jpg"));
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }
    pirateShip = new JLabel(new ImageIcon(imagePirateShip));
    pirate = new JLabel(new ImageIcon(imagePirate));
    pirateShip.setBounds(60,0,100,100);
    pirate.setBounds(170,0,100,100);

    panel.add(pirateShip);
    panel.add(pirate);

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

  public Void submitGuess() {
    String guess = inputArea1.getText();
 
    if(guess.length() >1)
      m.tryWord(guess);
    else if (!guess.isEmpty())
      m.tryThis(guess.charAt(0));
 
    label1.setText("This is the updated result: " + m.getVisible());

    return null;
  }
}