import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Temp {
	public static void main(String args[]) {
	//	System.out.println(fib());
		Map<Character,Character> map = new HashMap<Character,Character>();
		map.put('{', '}');
		map.put('[',']');
		map.put('(',')');
		System.out.println(isMatching("[(])",map));
	}
	
	private static int mul35(int x) {
		int sum = 0;
		for(int i=1;i<x;i++) {
			if(i%3==0)
				sum += i;
			else if(i%5==0)
				sum += i;
		}
		return sum;
	}
	
	private static int fib() {
		int a = 1;
		int b = 2;
		int sum = 2;
		int result = 0;
		while(result<4*Math.pow(10, 6)) {
			if(result%2==0)
				sum = sum+result;
			result = a+b;
			a = b;
			b = result;
		}
		return sum;
	}
	
	
	private static boolean isMatching(String text, Map<Character,Character> map) {
		if(text == null || text.length() == 0) return true;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<text.length();i++) {
			char ch = text.charAt(i);
			if(map.containsKey(ch)) {
				stack.push(ch);
			}
			else  {
				if(stack.isEmpty()) return false;
				char pop = stack.pop();
				if(map.containsKey(pop) == false || map.get(pop) != ch) 
					return false;
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
}