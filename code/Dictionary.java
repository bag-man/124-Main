import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {

  private int numRecords;
  private ArrayList<String> wordlist = new ArrayList<String>();
  private Random rand = new Random();

  public Dictionary(String fileName) throws IOException {
    BufferedReader file = new BufferedReader(new FileReader(fileName));
    numRecords = Integer.parseInt(file.readLine());

    for(int i=0; i < numRecords; i++)
    {
      String word = file.readLine();
      wordlist.add(word);
    }

    file.close();
  }    

  public String selectRandomWord() {
    int position = rand.nextInt(wordlist.size());
    return wordlist.get(position);
  } 

} 
