import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AllTests {

  private GameModel model;

  public AllTests(Dictionary wordlist) {

    GameModel model = new GameModel(wordlist);

  }

  @Test
  public void visibleWord() { 

    System.out.println("Testing if the word has loaded correctly.") ;
    assertTrue(model.getVisible().equals("****"));

  }

}
