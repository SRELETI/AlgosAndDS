import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.*;



public class RemoveDupsJUnit {

	public RemoveDuplicates rem; 
	
	@Before
	public void setUp() {
		rem = new RemoveDuplicates();
	}
	
	@After
	public void cleanUp() {
		rem = null;
	}
	
	@Test
	public void test1() {
		char[] str = {'a','a','a','a','a'};
		char[] res = rem.removeLast(str);
		char[] expected = {'a'};
		
		org.junit.Assert.assertArrayEquals(expected, res);
	}
	
	@Test
	public void test2() {
		char[] str = {'a','b','c','d','e'};
		char[] res = rem.removeLast(str);
		char[] expected = {'a','b','c','d','e'};
		
		org.junit.Assert.assertArrayEquals(expected, res);
	}
	
	@Test
	public void test3() {
		char[] str = {'a','b','b','b','b'};
		char[] res = rem.removeLast(str);
		char[] expected = {'a','b'};
		
		org.junit.Assert.assertArrayEquals(expected, res);
	}
	
	@Test
	public void test4() {
		char[] str = {'a','a','a','a','b'};
		char[] res = rem.removeLast(str);
		char[] expected = {'a','b'};
		
		org.junit.Assert.assertArrayEquals(expected, res);
	}
	
	@Test
	public void test5() {
		char[] str = {'a','b','a','b','a','b'};
		char[] res = rem.removeLast(str);
		char[] expected = {'a','b'};
		
		org.junit.Assert.assertArrayEquals(expected, res);
	}
	
	
}
