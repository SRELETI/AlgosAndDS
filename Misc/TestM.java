/* author: Sudeep Eleti */
import org.junit.*;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TestM {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
	private M obj;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(output));
	    System.setErr(new PrintStream(errorOutput));
	    obj = new M();
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	    obj = null;
	}
	
	/* In all the 4 scenarios, we are not going to worry about the node 3 and the edges connecting it, as it is not reachable. */
	
	/* Scenario: 1 - Node Coverage but not Edge Coverage */
	
	/* Below Three set of test cases cover all the nodes but doesnt cover the edge(5,9). testNCCase0 goes through node 6 in switch, testNCCase1 goes through node 7, testNCCase2Default goes
	 * through node 8,9. Hence all the nodes are covered by the test cases, but an Edge is not covered. 
	 */

	@Test 
	public void testNCCase0() {
		obj.m("", 1);
		assertEquals("zero\r\n",output.toString());
	}
	@Test
	public void testNCCase1() {
		obj.m("a", 1);
		assertEquals("a\r\n",output.toString());
	}
	@Test 
	public void testNCCase2Default() {
		obj.m("ab", 1);
		assertEquals("b\r\n",output.toString());
	}
	
	/* Scenario: 2 - Edge Coverage but not Edge Pair Coverage */
	
	/* I think there is no test case which satisfies Edge Coverage but not Edge Pair Coverage. All the Edges are satisfied by the following
	 * test paths {1,2,4,5,6,11}, {1,2,4,5,7,10,11}, {1,2,4,5,8,9,10,11}, {1,2,4,5,9,10,11}. This test paths also cover all the Edge pairs.
	 * So I think in this CFG, if Edge coverage is achieved then Edge Pair Coverage can also be achieved using the same test paths
	 */

	/* Scenario: 3 - Edge Pair Coverage but not Prime Path Coverage */
	
	/* Even for this scenario, I think there is no test case which satisfies only Edge pair Coverage but not Primepath Coverage. All the Edge
	 * pairs are satisfied by the following test paths {1,2,4,5,6,11}, {1,2,4,5,7,10,11}, {1,2,4,5,8,9,10,11}, {1,2,4,5,9,10,11}. This paths
	 * are same as prime paths. So I think in this CFG, if Edge Pair coverage is achieved then Primepath Coverage can also be achieved using the same 
	 * test paths.
	 */
	
	/* Scenario: 4 - Prime Path Coverage */
	
	/* Below 4 test cases will cover all the four primePaths. testPPCCas0 will cover primepath going through node 6, testPPCCase1 will cover primepath
	 * going through node 7, testPPCCase2 will cover primepath going through node 8, testPPCCaseDefault will cover primePath going through node 9 and edge(5,9).  
	 */
	@Test 
	public void testPPCCase0() {
		obj.m("", 1);
		assertEquals("zero\r\n",output.toString());
	}
	@Test
	public void testPCCCase1() {
		obj.m("a", 1);
		assertEquals("a\r\n",output.toString());
	}
	@Test 
	public void testPPCCase2() {
		obj.m("ab", 1);
		assertEquals("b\r\n",output.toString());
	}
	@Test
	public void testPPCDefault() {
		obj.m("abc", 1);
		assertEquals("b\r\n",output.toString());
	}
}


/* M Class */

class M {
	public static void main(String [] argv){
		M obj = new M();
		if (argv.length > 0)
			obj.m(argv[0], argv.length);
	}
	
	public void m(String arg, int i) {
		int q = 1;
		A o = null;
		Impossible nothing = new Impossible();
		if (i == 0)
			q = 4;
		q++;
		switch (arg.length()) {
			case 0: q /= 2; break;
			case 1: o = new A(); new B(); q = 25; break;
			case 2: o = new A(); q = q * 100;
			default: o = new B(); break; 
		}
		if (arg.length() > 0) {
			o.m();
		} else {
			System.out.println("zero");
		}
		nothing.happened();
	}
}

class A {
	public void m() { 
		System.out.println("a");
	}
}

class B extends A {
	public void m() { 
		System.out.println("b");
	}
}

class Impossible{
	public void happened() {
		// "2b||!2b?", whatever the answer nothing happens here
	}
}
