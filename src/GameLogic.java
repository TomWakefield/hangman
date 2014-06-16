import java.util.HashSet;
import java.util.Set;

public class GameLogic {
	
	private final Dictionary dict;
	
    private String word;
    private Set<Character> lettersNotFound;
    private int wrongGuesses;
    
    /**
     * Constructor
     */
    public GameLogic() {
    	this.dict = new Dictionary("src/dict/dictionary.txt");
    }
    
    public String newGame() {
    	this.word = this.dict.getRandomWord();
        this.lettersNotFound = new HashSet<>();
        this.lettersNotFound = this.populateLetters();
        this.wrongGuesses = 0;
        return this.getWord(false);
    }
    
    /**
     * Returns the number of incorrect guesses made
     * @return the number of incorrect guesses made
     */
    public int getWrongGuesses() {
    	return wrongGuesses;
    }
    
    /**
     * If the input letter exists in the HashSet, it is removed, and true is
     * returned, otherwise false is returned
     * @param letter
     */
    public boolean guessLetter(char letter) {
        if (lettersNotFound.remove(letter) == false) { 
		    this.wrongGuesses++;
		    return false;
		}
        return true;
    }
    
    /**
     * Returns the target string
     * @param isVisible whether unguessed letters are displayed
     * @return If isVisible is true then returns the target string in plain,
     *         otherwise returns the target string with the unguessed letters
     *         replaced with asterisks.
     */
    public String getWord(boolean isVisible)
    {
    	if (isVisible) { return this.word; }
        String hint = this.word;
        for (Character letter : this.lettersNotFound) {
             hint = hint.replace((char) letter, '*');
        }
        return hint;
    }
        
    /**
     * Returns the game state
     * @return 1 if the game has been won
     *        -1 if the game has been lost
     *         0 otherwise
     */
    public int getGameState() {
        if (this.lettersNotFound.isEmpty()) { return 1; }
        if (this.wrongGuesses == 10) { return -1; }
        return 0;
    }
    
    /**
     * Returns a set of all unique letters in an input word
     * @return a HashSet of all letters existing in fillWord 
     */
    private Set<Character> populateLetters() {
    	Set<Character> letters = new HashSet<>();
    	for (int i = 0; i < this.word.length(); i++) {
            letters.add(this.word.charAt(i));
        }
    	return letters;  
    }
    

    
}