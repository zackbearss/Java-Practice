import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class StringHelper {
	public String Compress(String text)
	{
		String compressedString = "";
		ArrayList<Integer> al = new ArrayList<>();
		int arrayCounter = 0;
		//loop through and save the count of each char
		char startOfChar = text.charAt(0);
		al.add(1);
		for(int i = 1; i < text.length(); i++)
		{
			if(startOfChar == text.charAt(i))
			{
				al.set(arrayCounter, al.get(arrayCounter) + 1);	//update count
			}
			else
			{
				startOfChar = text.charAt(i);
				arrayCounter++;
				al.add(1);
			}
		}
		//calculate if the compressed string will be shorter
		int calculatedLength = al.size() * 2;
		if(text.length() <= calculatedLength)
		{
			return text;
		}
		//compress string
		int j = 0;	//regular string counter
		for(int i = 0; i < al.size(); i++)
		{
			compressedString += Character.toString(text.charAt(j)) + al.get(i);
			j += al.get(i);
		}
		
		return compressedString;
	}
}
