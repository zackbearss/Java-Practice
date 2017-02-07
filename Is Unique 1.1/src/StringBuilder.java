import java.util.Hashtable;
import java.util.Set;

public class StringBuilder {
	private String text;
	
	StringBuilder(String text)
	{
		this.text = text;
	}
	
	public boolean IsUnique()
	{	
		//O(n^2) runtime
		//O(1) space
		for(int i = 0; i < text.length(); i++)
		{
			for(int j = i+1; j < text.length(); j++)
			{
				if(text.charAt(i) == text.charAt(j))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean IsUnique2()
	{
		Hashtable<Character, Integer> ht = new Hashtable<>();
		
		//O(n) runtime
		//O(n) space
		
		//save vars in hash table
		for(int i = 0; i < text.length(); i++)
		{
			char key = text.charAt(i);
			if(ht.containsKey(key))
			{
				//ht.put(key, ht.get(key) + 1);
				return false;
			}
			else
			{
				ht.put(key, 1);
			}
		}
		
		//iterate hash table to see if 
//		Set<Character> keys = ht.keySet();
//		for(char key: keys)
//		{
//			if(ht.get(key) > 1)
//			{
//				return false;
//			}
//		}
		
		return true;
	}
	
	public boolean IsUnique3()
	{
		//using bit vector to keep track of letters, this is assuming all letters are lowercase
		//O(n) runtime
		//O(1) space
		int checker = 0;
		for(int i = 0; i < text.length(); i++)
		{
			int value = text.charAt(i) - 'a';
			
			if((checker & (1 << value)) > 0)
			{
				return false;
			}
			else
			{
				checker |= (1 << value);
			}
		}
		
		return true;
	}

}
