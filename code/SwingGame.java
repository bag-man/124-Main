import java.awt.event.ActionEvent;
import java.util.concurrent.Callable;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

/* Remember to turn on window decor!!! */

public class SwingGame extends JFrame {

  private GameModel m;

  public SwingGame(GameModel model) {
    m = model;

    setTitle("Pirate Hangman!");
    setSize(500, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);        

    JPanel panel = new JPanel();
    getContentPane().add(panel);
    panel.setLayout(null);

    panel.add(
      AddButton(0, 0, 100, 100, "NAME",  new Callable<Integer>() {
	@Override
	 public Integer call() {
	   return methodToPass();
	 }
      })
    );
  }

  private JButton AddButton(int x, int y, int w, int h, String name, Callable<Integer> function) {
    JButton submitButton = new JButton(name);
    submitButton.setBounds(x, y, w, h); //X, Y, W, H

    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        function.call();
      }
    });
    
    return submitButton;
  }

  public int methodToPass() {
    System.out.println("Perform an Action here!");
    return 1;
  }
}
