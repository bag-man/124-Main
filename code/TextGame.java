public class TextGame implements GameModelInterface {

  private char[] letters;
  private int length;
  private boolean[] found;
  private int numGuessesLeft = 10;

  public TextGame(Dictionary wordlist) {
    letters = wordlist.selectRandomWord().toCharArray();
    length = letters.length;
    for(int i = 0; i<length; i++) {
      found[i] = false; //Null pointer
    }
  }

  public String getVisible() {
    return "string";

  };

  public String getHidden() {
    return "string";

  };

  public int guessLeft() {
    return numGuessesLeft;
  };

  public String getLetters() {
    String result = "TEST";

    for(int i=0; i<length; i++)
    {
      if(found[i])
	result += letters[i];
      else
	result += "*";
    }
    return result;
  };

  public boolean tryThis(char letter){
    return true;
  };

  public boolean tryWord(String guess) {
    return true;
  };


}
