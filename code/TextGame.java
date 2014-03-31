public class TextGame implements GameModelInterface {

  private char[] letters;
  private boolean[] found;
  private int length;
  private int numGuessesLeft = 10;

  public TextGame(Dictionary wordlist) {
    letters = wordlist.selectRandomWord().toCharArray();
    length = letters.length;
    found = new boolean[length];
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
    String result = "";
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
    for(int i = 0; i<length; i++) {
      if(letters[i] == letter)
	found[i] = true;
    }
    return true;
  };

  public boolean tryWord(String guess) {
    return true;
  };


}
