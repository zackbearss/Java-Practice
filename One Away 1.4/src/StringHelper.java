
public class StringHelper {
	public boolean IsOneAway(String text, String OneAwayText)
	{
		//if zero edits away
		if(text == OneAwayText)
		{
			return true;
		}
		//if too many removes away
		if(OneAwayText.length() > text.length() + 1)
		{
			return false;
		}
		//if too many inserts away
		if(OneAwayText.length() < text.length() - 1)
		{
			return false;
		}
		//check remove
		if(OneAwayText.length() == text.length() + 1)
		{
			return CheckRemove(text, OneAwayText);
		}
		//check insert 
		if(OneAwayText.length() == text.length() - 1)
		{
			return CheckInsert(text, OneAwayText);
		}
		
		//check replace 
		if(OneAwayText.length() == text.length())
		{
			return CheckReplace(text, OneAwayText);
		}
		
		return false;
	}
	
	/*
	 * Checks if all characters are the same besides the one character that needs to be inserted
	 */
	private boolean CheckInsert(String text, String OneAwayText)
	{
		boolean differenceFound = false;
		
		for(int i = 0; i < text.length(); i++)
		{
			int j = (differenceFound) ? i - 1 : i;
			if(text.charAt(i) != OneAwayText.charAt(j))
			{
				if(differenceFound)
				{
					return false;
				}
				differenceFound = true;
			}
		}
		
		return true;
	}
	
	/*
	 * Checks if all characters are the same besides the one character that needs to be removed
	 */
	private boolean CheckRemove(String text, String OneAwayText)
	{
		boolean differenceFound = false;
		
		for(int i = 0; i < text.length(); i++)
		{
			int j = (differenceFound) ? i - 1 : i;
			if(text.charAt(j) != OneAwayText.charAt(i))
			{
				if(differenceFound)
				{
					return false;
				}
				differenceFound = true;
			}
		}
		
		return true;
	}
	
	/*
	 * Checks if all characters are the same besides the one character that needs to be replaced
	 */
	private boolean CheckReplace(String text, String OneAwayText)
	{
		boolean differenceFound = false;
		
		for(int i = 0; i < text.length(); i++)
		{
			if(text.charAt(i) != OneAwayText.charAt(i))
			{
				if(differenceFound)
				{
					return false;
				}
				differenceFound = true;
			}
		}
		
		return true;
	}
}
