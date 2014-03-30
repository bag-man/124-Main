public class TextGame implements GameModelInterface {

  private char[] letters;

  public TextGame(Dictionary wordlist) {
    letters = wordlist.selectRandomWord().toCharArray();
  }

  public String getVisible() {
    return "string";

  };

  public String getHidden() {
    return "string";

  };

  public int guessLeft() {
    return 1;
  };

  public String getLetters() {
    return "string";

  };

  public boolean tryThis(char letter){
    return true;
  };

  public boolean tryWord(String guess) {
    return true;
  };

}
