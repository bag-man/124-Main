import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AllTests {

  private GameModel model;

  public AllTests(Dictionary w) {

    model = new GameModel(w);

  }

  @Test
  public void hiddenWord() { 

    System.out.println("Testing if the word has loaded correctly.");
    assertTrue(model.getVisible().equals("****"));

  }

}
