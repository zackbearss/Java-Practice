
public class HashEntry{
	private String key;
	private int value;
	private boolean deleteFlag;
	
	public HashEntry(String key, int value)
	{
		this.key = key;
		this.value = value;
		this.deleteFlag = false;
	}
	
	String getKey()
	{
		return this.key;
	}
	
	int getValue()
	{
		return this.value;
	}
	
	void DeleteEntry()
	{
		this.deleteFlag = true;
	}
	
	boolean IsDeleted()
	{
		return this.deleteFlag;
	}
}
