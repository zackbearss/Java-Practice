import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTesting {

	@Test
	public void testSearch() {
		BinarySearch bs = new BinarySearch();
		int[] arr = {0, 1, 2, 3, 4, 5};
		assertEquals(4, bs.search(arr, 4, 0, arr.length - 1));	
		assertEquals(-1, bs.search(arr, 6, 0, arr.length - 1));
		arr = new int[] { 0, 23, 143, 235, 435, 545, 989};
		assertEquals(1, bs.search(arr, 23, 0, arr.length - 1));	
		assertEquals(6, bs.search(arr, 989, 0, arr.length - 1));
		assertEquals(0, bs.search(arr, 0, 0, arr.length - 1));
	}
}
