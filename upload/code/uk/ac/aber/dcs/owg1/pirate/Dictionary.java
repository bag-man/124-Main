package uk.ac.aber.dcs.owg1.pirate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * The Class Dictionary.
 */
public class Dictionary {

  /** The num records. */
  private int numRecords;
  
  /** The wordlist. */
  private ArrayList<String> wordlist = new ArrayList<String>();
  
  /** The rand. */
  private Random rand = new Random();

  /**
   * Instantiates a new dictionary.
   *
   * @param fileName the file name
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public Dictionary(String fileName) throws IOException {
    BufferedReader file = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
    numRecords = Integer.parseInt(file.readLine());

    for(int i=0; i < numRecords; i++) {
      String word = file.readLine();
      wordlist.add(word);
    }

    file.close();
  }    

  /**
   * Select random word.
   *
   * @return the string
   */
  public String selectRandomWord() {
    int position = rand.nextInt(wordlist.size());
    return wordlist.get(position);
  } 

} 
