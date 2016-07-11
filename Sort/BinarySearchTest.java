import static org.junit.Assert.*;

import org.junit.Test;


public class BinarySearchTest {

	@Test
	public void testBinarySearch() {
		BinarySearch b = new BinarySearch();
		int[] arr = {2, 3, 4, 10, 40};
		int element = 40;
		int result = b.binarySearch(arr, 0, arr.length-1, element);
		
		assertEquals(4,result,0.0);
	}
	
	@Test
	public void testBinarySearchIter() {
		BinarySearch b = new BinarySearch();
		int[] arr = {2, 3, 4, 10, 40};
		int element = 40;
		int result = b.binarySearchIterative(arr, element);
		
		assertEquals(4,result,0.0);
	}

}
