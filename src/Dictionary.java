import java.io.*;
import java.util.*;

public class Dictionary
{
	private List<String> words;
	
	public Dictionary(String filepath)
	{
		this.words = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(filepath)));
			String line = reader.readLine();
			while (line != null) {
				if (!line.startsWith("#")) { // # used to denote comments in text file
					this.words.add(line);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
    /**
     * Generates a random word
     * @return a random word from the ArrayList 'words'
     */
	public String getRandomWord()
	{
		int rand = new Random().nextInt(this.words.size());
		return this.words.get(rand).toUpperCase();
	}   

}