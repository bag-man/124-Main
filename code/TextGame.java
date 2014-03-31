public class TextGame implements GameModelInterface {

  private char[] letters;
  private boolean[] found;
  private String word;
  private int length;
  private int numGuessesLeft = 10;

  public TextGame(Dictionary wordlist) {
    word = wordlist.selectRandomWord();
    letters = word.toCharArray();
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
      if(letters[i] == ' ')
	result += " ";
      else if(found[i])
	result += letters[i];
      else
	result += "*";
    }
    return result;
  };

  public boolean tryThis(char letter){
    int i;
    for(i = 0; i<length; i++) {
      if(letters[i] == letter)
	found[i] = true;
    }
    return found[i];
  };

  public boolean tryWord(String guess) {
    if(guess.equals(word))
      return true;
    else
      return false;
  };

}
