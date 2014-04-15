//import org.junit.Test;
//import static org.junit.Assert.assertTrue;

public class AllTests {

  private GameModel model;

  public AllTests(Dictionary wordlist) {

    GameModel model = new GameModel(wordlist);

  }

  //@Test
  public void hiddenWord() { 

    System.out.println("Testing if the word has loaded correctly.");
    String visible = model.getHidden(); //Null pointer out of no where...
    //assertTrue(model.getVisible().equals("****"));

  }

}
