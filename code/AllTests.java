import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.IOException;

public class AllTests {

  private GameModel model;
  private Dictionary wordlist;

  public AllTests() {

    try {
      wordlist = new Dictionary("../word.txt"); //This file contains a single word, "ahoy".
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    model = new GameModel(wordlist);

  }

  @Test
  public void hiddenWord() { 

    assertEquals("Word has not loaded correctly.", model.getHidden(), "ahoy");

  }

}
