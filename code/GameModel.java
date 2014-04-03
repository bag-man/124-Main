import java.util.ArrayList;
import java.util.Collections;

public class GameModel implements GameModelInterface {

  private ArrayList<Character> letters = new ArrayList<Character>();
  private ArrayList<Boolean> found = new ArrayList<Boolean>();
  private String word;
  private String guesses;
  private int length;
  private int numGuessesLeft;
  private Dictionary wordlist;

  public GameModel(Dictionary w) {
    wordlist = w;
    word = wordlist.selectRandomWord();
    initialise(word);
  }

  public void initialise(String w) {
    guesses = "";
    numGuessesLeft = 10;
    letters.clear();
    found.clear();
    for (char c : w.toCharArray()) {
      letters.add(c);
      found.add(false);
    }
    length = letters.size();
  }

  public String getVisible() {
    String result = "";
    for(int i=0; i<length; i++) {
      if(letters.get(i) == ' ')
	result += " ";
      else if(found.get(i))
	result += letters.get(i);
      else
	result += "*";
    }
    return result;
  };

  public String getHidden() {
    return word;
  };

  public int guessLeft() {
    return numGuessesLeft;
  };

  public String getLetters() {
    return guesses;
  }

  public boolean tryThis(char letter){
    numGuessesLeft--;
    guesses += letter + " ";
    int i;
    boolean correct = false;

    for(i = 0; i<length; i++) {
      if(letters.get(i) == letter) {
	found.set(i, true);
        correct = true;
      }
    }
    return correct;
  };

  public boolean tryWord(String guess) {
    numGuessesLeft--;
    if(guess.equals(word)) {
      Collections.fill(found, Boolean.TRUE);
      return true;
    } else
      return false;
  };

  public boolean won() {
    for (boolean correct : found) {
      if (!correct)
        return false;
    }
    return true;
  }

  public boolean selectNewWord() {
    String newWord = wordlist.selectRandomWord();
    if(!word.equals(newWord)) {
      initialise(newWord);
      return true;
    } else {
      return false;
    }
  }

}
