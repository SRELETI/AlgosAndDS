
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class MiddleStackClient {

	public static void main(String args[]) {
		MiddleStack middle = new MiddleStack();
		System.out.println(middle.deleteMiddle());
		System.out.println(middle.getMiddle());
		middle.push(5);
	//	System.out.println(middle.getMiddle());
		middle.push(4);
	//	System.out.println(middle.getMiddle());
		middle.push(3);
	//	System.out.println(middle.getMiddle());
		middle.push(2);
	//	System.out.println(middle.getMiddle());
		middle.push(1);
	//	System.out.println(middle.getMiddle());
		
		System.out.println(middle.deleteMiddle());
		System.out.println(middle.deleteMiddle());
	//	System.out.println(middle.getMiddle());
		middle.push(0);
		middle.push(-1);
		System.out.println(middle.getMiddle());
	/*	System.out.println(middle.pop());
		System.out.println(middle.getMiddle());
		System.out.println(middle.pop());
		System.out.println(middle.getMiddle());
		System.out.println(middle.pop());
		System.out.println(middle.getMiddle());
		System.out.println(middle.pop());
		System.out.println(middle.getMiddle());
		System.out.println(middle.pop());
		System.out.println(middle.getMiddle());
		System.out.println(middle.isEmpty());
		*/
	}
}
