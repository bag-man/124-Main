import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AllTests {

  private GameModel model;

  public AllTests(Dictionary w) {

    model = new GameModel(w);

  }

  @Test
  public void hiddenWord() { 

    assertEquals("Word has not loaded correctly.", model.getHidden(), "ahoy");

  }

}
