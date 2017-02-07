import java.util.Hashtable;
import java.util.Set;

public class StringBuilder {
	private String text;
	
	StringBuilder(String text)
	{
		this.text = text;
	}
	
	private Hashtable<Character, Integer> CharacterMap(String text)
	{
		Hashtable<Character, Integer> ht = new Hashtable<>();
		
		for(int i = 0; i < text.length(); i++)
		{
			char key = text.charAt(i);
			if(ht.containsKey(key))
			{
				ht.put(key, ht.get(key) + 1);
			}
			else
			{
				ht.put(key, 1);
			}
		}
		
		return ht;
	}
	
	public boolean IsPermutation(String permutation)
	{
		//O(3N) -> O(N) run time
		//O(3N) -> O(N) space
		//could sort it first and compare strings, that is O(N log N)
		//better way of doing it this way is to have one hash, add to it with textHash, subtract
		//from it with permutation, make sure it is all 0
		Hashtable<Character, Integer> textHash = CharacterMap(this.text);
		Hashtable<Character, Integer> permutationHash = CharacterMap(permutation);
		
		//if different amount of letters, can't be a permutation
		if(textHash.size() != permutationHash.size())
		{
			return false;
		}
		
		//iterate hash table to see if 
		Set<Character> keys = textHash.keySet();
		for(char key: keys)
		{
			//letter doesn't exist, can't be a permutation
			if(!permutationHash.containsKey(key))
			{
				return false;
			}
			//letter wasn't used in the same amount, can't be a permutation
			if(textHash.get(key) != permutationHash.get(key))
			{
				return false;
			}
		}
		
		return true;
	}

}
