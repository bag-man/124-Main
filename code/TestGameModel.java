import java.io.IOException;

public class TestGameModel {

  private static Dictionary wordlist;

  public static void main(String[] args) {

    try {
      wordlist = new Dictionary("../word.txt"); //This file contains a single word, "ahoy".
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }

    AllTests test = new AllTests(wordlist);

    test.visibleWord();

  }


}
