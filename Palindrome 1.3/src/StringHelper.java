import java.util.Hashtable;
import java.util.Set;

public class StringHelper {
	public boolean PermutationIsAPalindrome(String text)
	{
		//assume ascii letters only 
		Hashtable<Character, Integer> ht = new Hashtable<>();
		//enter hash table
		for(int i = 0; i < text.length(); i++)
		{
			char key = Character.toLowerCase(text.charAt(i));
			if(ht.containsKey(key))
			{
				ht.put(key, ht.get(key) + 1);
			}
			else
			{
				ht.put(key, 1);
			}
		}
		
		boolean foundOddLetterInstance = false;
		Set<Character> keys = ht.keySet();
		for(char key : keys)
		{
			//ignore anything that isn't a lower case letter
			if(key < 97 || key > 122)
			{
				continue;
			}
			//check for an odd count of letters, can only happen for one letter to not be a palindrome
			if(ht.get(key) % 2 == 1)
			{
				if(foundOddLetterInstance)
				{
					return false;
				}
				else
				{
					foundOddLetterInstance = true;
				}
			}
		}
		
		return true;
	}
}
