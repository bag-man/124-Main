public class TextGame implements GameModelInterface {

  private String word;

  public TextGame(Dictionary wordlist) {
    word = wordlist.selectRandomWord();
  }

  public String getVisible() {

  };

  public String getHidden() {

  };

  public int guessLeft() {
  };

  public String getLetters() {

  };

  public boolean tryThis(char letter){

  };

  public boolean tryWord(String guess) {

  };

}
