import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestGameModel {

  private static Dictionary wordlist;

  public static void main(String[] args) {

    try {
      wordlist = new Dictionary("../word.txt"); //This file contains a single word, "ahoy".
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    testVisibleWord();

  }

  @Test
  public void testVisibleWord() { //Is it okay to make this static? A: No! I shall make some test classes. Yippee. 

    System.out.println("Testing if the word has loaded correctly.") ;
    GameModel model = new GameModel(wordlist);
    assertTrue(model.getVisible().equals("****"));

  }

}
