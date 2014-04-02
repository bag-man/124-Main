import java.awt.event.ActionEvent;
import java.util.concurrent.Callable;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Remember to turn on window decor!!! */

public class SwingGame extends JFrame {

  private GameModel m;
  private JTextField inputArea1;
  private JLabel label1;

  public SwingGame(GameModel model) {
    m = model;

    setTitle("Pirate Hangman!");
    setSize(500, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);        

    JPanel panel = new JPanel();
    getContentPane().add(panel);
    panel.setLayout(null);

    inputArea1 = new JTextField();
    inputArea1.setBounds(0, 0, 150, 25);
    panel.add(inputArea1);
  
    label1 = new JLabel("This is a pirate hangman game." + m.getVisible());
    label1.setBounds(0,30,500,200);
    panel.add(label1);

    panel.add(
      AddButton(150, 0, 120, 25, "Submit",  new Callable<Void>() {
	@Override
	 public Void call() {
	   return submitGuess();
	 }
      })
    );
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
