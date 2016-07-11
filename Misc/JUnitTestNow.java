import static org.junit.Assert.*;

import org.junit.*;
public class JUnitTestNow {

	public static int odd(int[] x) {
		// Effects: if x==null throw NullPointerException,
		// else return the number of elements in x that are odd
		int count = 0;
		for (int i =0; i < x.length; i++) {
		if (x[i]%2==1) {
		count++;
		}
		}
		return count;
		}
	
	@Before 
	public void setUp() {
		
	}
	@Test (expected=NullPointerException.class)
	public void test() 
	{
		odd(null);
		
	}
	
	@Test 
	public void test2() 
	{
		int[] arr = {2,4,6};
		int count = odd(arr);
		assertEquals(0,count);
	}
}
