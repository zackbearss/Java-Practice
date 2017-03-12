
public class BinarySearch {
	
	/*
	 * Search for value in arr
	 * @param arr Array of integers
	 * @param value THe value to search for
	 * @return The index of the value, if not found it will return -1
	 */
	public int search(int[] arr, int value)
	{
		int min = 0;
		int max = arr.length - 1;
		
		while(min <= max)
		{
			int middlePoint = (min + max) / 2;
			if(arr[middlePoint] == value)
			{
				return middlePoint;
			}
			else if(arr[middlePoint] > value)
			{
				max = middlePoint - 1;
			}
			else
			{
				min = middlePoint + 1;
			}
		}
		return -1;
	}
}
