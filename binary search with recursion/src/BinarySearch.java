
public class BinarySearch {
	public int search(int[] arr, int value, int low, int high)
	{
		if(low > high)
		{
			return - 1;
		}
		
		int middlePoint = (low + high) / 2;
		
		if(arr[middlePoint] > value)
		{
			return search(arr, value, low, middlePoint - 1);
		}
		else if(arr[middlePoint] < value)
		{
			return search(arr, value, middlePoint + 1, high);
		}
		else
		{
			return middlePoint;
		}
	}
}
