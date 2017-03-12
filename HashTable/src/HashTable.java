
public class HashTable {
	HashEntry[] arr;
	int size; 
	public HashTable(int size)
	{
		arr = new HashEntry[size];
		this.size = size;
	}
	
	private int hash(String key, int m)
	{
		//hashing string, multiplying by a prime number makes it more
		//likely to generate unique hashes
		//http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
		//using the djb2 function
		//http://www.cse.yorku.ca/~oz/hash.html
		long hash = 5381;
		for(int i = 0; i < key.length(); i++)
		{
			hash = ((hash << 5) + hash) + key.charAt(i);
		}
		return (int)(hash % size);
	}
	
	public void add(String key, int value)
	{
		 int index = hash(key, size);
		 
		 while(arr[index] != null)
		 {
			 //value was deleted
			 if(arr[index].IsDeleted())
				 break;
			 index = (index == size - 1) ? 0 : index + 1;
		 }
		 
		 arr[index] = new HashEntry(key, value);
	}
	
	public boolean exists(String key)
	{
		 int index = hash(key, size);
		 
		 while(arr[index] != null)
		 {
			 if(arr[index].getKey() == key)
				 return true;
			 //value was deleted
			 if(arr[index].IsDeleted())
				 break;
			 index = (index == size - 1) ? 0 : index + 1;
		 }
		return false;
	}
	
	public int get(String key)
	{
		 int index = hash(key, size);
		 
		 while(arr[index] != null)
		 {
			 if(arr[index].getKey() == key)
				 return arr[index].getValue();
			 //value was deleted
			 if(arr[index].IsDeleted())
				 break;
			 index = (index == size - 1) ? 0 : index + 1;
		 }
		return -1;
	}
	
	public void remove(String key)
	{
		 int index = hash(key, size);
		 
		 while(arr[index] != null)
		 {
			 if(arr[index].getKey() == key)
				 arr[index].DeleteEntry();
			 //value was deleted
			 if(arr[index].IsDeleted())
				 break;
			 index = (index == size - 1) ? 0 : index + 1;
		 }
		return;
	}
}
