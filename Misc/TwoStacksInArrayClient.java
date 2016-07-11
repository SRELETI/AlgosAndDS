
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class TwoStacksInArrayClient {

	public static void main(String args[]) {
		TwoStacksInArray stacks = new TwoStacksInArray(5);
		System.out.println(stacks.isEmpty1());
		stacks.push1(111);
		stacks.push1(222);
		stacks.push1(333);
		stacks.push1(555);
		stacks.push1(444);
		stacks.push1(777);
		System.out.println(stacks.isFull());
		System.out.println(stacks.pop1());
		stacks.pop2();
		stacks.push1(888);
		stacks.push1(999);
		stacks.push1(000);
	}
}
