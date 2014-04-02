import java.awt.event.ActionEvent;
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

    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(0, 0, 120, 30); //X, Y, W, H

    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        System.out.println("Perform an action here!");
      }
    });

    panel.add(submitButton);

  }

}
