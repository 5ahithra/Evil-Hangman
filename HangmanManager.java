//Sahithra Kesavan
//Period 4
import java.util.*;

public class HangmanManager 
{
	//Making variables to store needed information to use for later
    private Set<String> dictionary;
    private int length;
    private int max;
    private Set<Character> guessedChars; //The set im using to store the user's guessed characters
    private String pattern = "";
   
    
    public HangmanManager(List<String> dictionary, int length, int max) 
    {
    	//Initalizing this file with the variables
        this.dictionary = new HashSet<>();
        this.guessedChars = new HashSet<>();
        this.pattern = "";
        this.length = length;
        this.max = max;
        
       //Only adding words that are the length the user wanted to the dictionary
        for (String word : dictionary)
        {
            if (word.length() == length) 
            {
                this.dictionary.add(word);
            }
        }

        //Throwing an exception if there aren't any words of the length(if the legth is an unreal number like 0,-1)
        if (this.dictionary.isEmpty()) 
        {
            throw new IllegalArgumentException("No words found in the dictionary");
        }

        
    }

	public Set<String> words()
	{
		return new HashSet<>(dictionary); //Returning the words being used by this file
	}	
	
	public int guessesLeft()
	{
		return max - guesses().size(); //Returns the number of guesses the player has left
	}
		
	public Set<Character> guesses()
	{
		return guessedChars; //Returns the characters the players already guessed
	}
	
	// returns the current pattern being used for the game
	public String pattern() {
	    // Throws an exception if the set of words is empty
	    if (dictionary.isEmpty()) {
	        throw new IllegalStateException("Set of words is empty");
	    }
	    
	    else if (!pattern.isEmpty()) {
	        return pattern;
	    }

	    // Generates the pattern for each word in the dictionary and adds spaces 
	    for (String word : dictionary) 
	    {
	        String wordPat = ""; //will hold the pattern for the current word
	        for (int x = 0; x < word.length(); x++)//Checking each letter in the word
	        {
	            char holder = word.charAt(x);
	            //If the player guesses the letter it will add it to the pattern, if they don't it will add a dash "-"
	            if (guessedChars.contains(holder)) 
	            {
	                wordPat += holder;
	            } else {
	                wordPat += "-";
	            }
	        }
	        pattern += wordPat + " "; // Adds a space after each word's pattern
	    }

	    // Removes the space at the end of the pattern and then returns it
	    pattern = pattern.substring(0, pattern.length() - 1);
	    return pattern;
	}

	
	public int record(char guess) //Records the player's guess and updates the word set based on what the user guessed
	{
	    
	    if (max < 1 || dictionary.isEmpty()) //Throws an exception if the player runs out of guesses or theres no more words in the set
	    {
	        throw new IllegalStateException("No guesses left or set of words is empty.");
	    }

	    
	    if (guessedChars.contains(guess)) //Throws an exception if the letter is a repeat of somehting they already guessed
	    {
	        throw new IllegalArgumentException("You already guessed this letter: " + guess);
	    }

	    guessedChars.add(guess); //Adding the letter they guessed to the set of guessed chars

	    
	    Map<String, Set<String>> groups = new HashMap<>();//Used to group the words together
	    for (String word : dictionary)
	    {
	        String pattern = "";//Empty pattern to hold the word
	        for (int i = 0; i < word.length(); i++) //Going through the letters of the word and checking if the player guessed it
	        {
	            char letter = word.charAt(i);
	            //If the letter matches what the player guessed then it adds it to the pattern
	            if (letter == guess || guessedChars.contains(letter))
	            {
	                pattern += letter;
	            } else
	            {
	                pattern += "-"; //It adds a dash if the letter wasn't guessed
	            }
	        }
	        if (!groups.containsKey(pattern)) //Updating the groups based on the pattern
	        {
	            groups.put(pattern, new HashSet<>());
	        }
	        groups.get(pattern).add(word);
	    }

	   //Finding the pattern with the most words and choosing that as the new word set
	    String selection = "";
	    int maxWords = 0;
	    //Goign through the patterns and their word sets to choose the biggest pattern
	    for (Map.Entry<String, Set<String>> entry : groups.entrySet()) 
	    {
	        if (entry.getValue().size() > maxWords) 
	        { //Updating the current word set to the best pattern if it is the biggest
	            selection = entry.getKey();
	            maxWords = entry.getValue().size();
	        }
	    }

	    //Updating the word set and pattern
	    dictionary = groups.get(selection);
	    pattern = selection;

	  //Counting the number of times a guessed letter shows up in the new pattern
	    int Foundcases = 0;
	    for (int i = 0; i < selection.length(); i++) 
	    {
	    	
	        if (selection.charAt(i) == guess)
	        {
	            Foundcases++;
	        }
	    }
        //Decreasing the remaing guessed the user has
	    max--; 
	    return Foundcases; //Returning the number of times the guessed letter shows up
	}


	


}
