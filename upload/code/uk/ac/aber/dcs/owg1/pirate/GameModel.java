package uk.ac.aber.dcs.owg1.pirate;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Class GameModel.
 */
public class GameModel implements GameModelInterface {

  /** The letters. */
  private ArrayList<Character> letters = new ArrayList<Character>();
  
  /** The found. */
  private ArrayList<Boolean> found = new ArrayList<Boolean>();
  
  /** The word. */
  private String word;
  
  /** The guesses. */
  private String guesses;
  
  /** The length. */
  private int length;
  
  /** The num guesses left. */
  private int numGuessesLeft;
  
  /** The wordlist. */
  private Dictionary wordlist;

  /**
   * Instantiates a new game model.
   *
   * @param w is the wordlist
   */
  public GameModel(Dictionary w) {
    wordlist = w;
    word = wordlist.selectRandomWord();
    initialise(word);
  }

  /**
   * Initialise.
   *
   * @param w the word
   */
  public void initialise(String w) {
    guesses = "";
    word = w;
    numGuessesLeft = 10;
    letters.clear();
    found.clear();
    for (char c : w.toCharArray()) {
      letters.add(c);
      if(c == ' ')
	found.add(true);
      else 
	found.add(false);
    }
    length = letters.size();
  }

  /* 
   * @see uk.ac.aber.dcs.owg1.pirate.GameModelInterface#getVisible()
   */
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

  /* 
   * @see uk.ac.aber.dcs.owg1.pirate.GameModelInterface#getHidden()
   */
  public String getHidden() {
    return word;
  };

  /* 
   * @see uk.ac.aber.dcs.owg1.pirate.GameModelInterface#guessLeft()
   */
  public int guessLeft() {
    return numGuessesLeft;
  };

  /* 
   * @see uk.ac.aber.dcs.owg1.pirate.GameModelInterface#getLetters()
   */
  public String getLetters() {
    return guesses;
  }

  /* 
   * @see uk.ac.aber.dcs.owg1.pirate.GameModelInterface#tryThis(char)
   */
  public boolean tryThis(char letter){
    int i;
    boolean correct = false;

    for(i = 0; i<length; i++) {
      if(letters.get(i) == letter) {
	found.set(i, true);
        correct = true;
      } 
    }

    if(!correct && guesses.indexOf(letter) == -1 ){
      numGuessesLeft--;
      guesses += letter + " ";
    } else {
      correct = true;
    }

    return correct;
  };

  /* 
   * @see uk.ac.aber.dcs.owg1.pirate.GameModelInterface#tryWord(java.lang.String)
   */
  public boolean tryWord(String guess) {
    if(guess.equals(word)) {
      Collections.fill(found, Boolean.TRUE);
      return true;
    } else {
      numGuessesLeft += -5;
      return false;
    }
  };

  /**
   * Won.
   *
   * @return true, if successful
   */
  public boolean won() {
    for (boolean correct : found) {
      if (!correct)
        return false;
    }
    return true;
  }

  /**
   * Select new word.
   *
   * @return true, if successful
   */
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
