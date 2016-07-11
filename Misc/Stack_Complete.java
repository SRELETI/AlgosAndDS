import java.util.Arrays;
import java.util.Stack;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class Stack_Complete {

	private static int evalInfixWithoutBrackets(String infix) {
		if(infix == null || infix.length()==0) return 0;
		int prevVal = 0;
		int curVal = 0;
		int result = 0;
		int i=0;
		char sign = '+';
		while(i < infix.length()) {
			curVal = 0;
			while(i<infix.length() && infix.charAt(i)>=48 && infix.charAt(i)<=57) {
				curVal = curVal*10 + infix.charAt(i)-'0';
				i++;
			}
			if(sign == '+') {
				result += prevVal;
				prevVal = curVal;
			}
			else if(sign == '-') {
				result += prevVal;
				prevVal = -curVal;
			}
			else if(sign == '*') {
				prevVal = prevVal*curVal;
			}
			else if(sign == '/') {
				prevVal = prevVal/curVal;
			}
			if(i<infix.length()) {
				sign = infix.charAt(i);
				i++;
			}
		}
		result += prevVal;
		return result;
	}
	
	
	private static int evalInfixWithBrackets(String infix) {
		if(infix == null || infix.length() == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int sign = 1;
		int result = 0;
		int number = 0;
		for(int i=0;i<infix.length();i++) {
			if(infix.charAt(i)>=48 && infix.charAt(i)<=57) {
				number = number*10+infix.charAt(i)-'0';
			}
			else if(infix.charAt(i)=='+') {
				result += sign*number;
				sign = 1;
				number = 0;
			}
			else if(infix.charAt(i)=='-') {
				result += sign*number;
				sign = -1;
				number = 0;
			}
			else if(infix.charAt(i)=='(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			}
			else if(infix.charAt(i)==')') {
				result += sign*number;
				number = 0;
				result *= stack.pop();
				result += stack.pop();
			}
		}
		if(number != 0) {
			result += sign*number;
		}
		return result;
	}
	
	
	private static String infixToPostFix(String infix) {
		if(infix == null || infix.length() == 0) return "";
		Stack<Character> stack = new Stack<Character>();
		StringBuilder output = new StringBuilder();
		for(int i=0;i<infix.length();i++) {
			char ch = infix.charAt(i);
			if(ch=='(') {
				stack.push(ch);
			}
			else if(ch==')') {
				while(!stack.isEmpty() && stack.peek()!= '(') {
					output.append(stack.pop());
				}
				if(stack.isEmpty()) return "";
				stack.pop();
			}
			else if(isOperand(ch)) {
				output.append(ch);
			}
			else {
				while(!stack.isEmpty() && getPrec(stack.peek())>= getPrec(ch)) {
					output.append(stack.pop());
				}
				stack.push(ch);
			}
				
		}
		while(!stack.isEmpty()) 
			output.append(stack.pop());
		return output.toString();
	}
	
	private static int postFixEval(String postFix) {
		if(postFix == null || postFix.length() == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<postFix.length();i++) {
			char ch = postFix.charAt(i);
			if(ch>= 48 && ch<=57) {
				stack.push(ch-'0');
			}
			else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result = 0;
				if(ch == '+') 
					result = num1 + num2;
				else if(ch == '-') 
					result = num2 - num1;
				else if(ch == '*')
					result = num2 * num1;
				else if(ch == '/')
					result = num2/num1;
				else 
					result = (int)Math.pow(num2, num1);
				stack.push(result);
			}
		}
		return stack.pop();
	}
	
	private static int getPrec(char ch) {
		if(ch=='+' || ch=='-')
			return 1;
		if(ch=='*' || ch=='/')
			return 2;
		if(ch=='^')
			return 3;
		return 0;
	}
	
	private static boolean isOperand(char ch) {
		if((ch>=48 && ch<=57)) 
				return true;
		return false;
	}
	
	
	private static void stockSpan(int[] arr) {
		if(arr == null || arr.length == 0) return;
		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
				stack.pop();
			}
			result[i] = stack.isEmpty() ? i+1 : i-stack.peek();
			stack.push(i);
		}
		System.out.println(Arrays.toString(result));
	}
	
	private static int histogramMax(int[] arr) {
		if(arr == null || arr.length==0) return 0;
		int overallMax =0;
		for(int i=0;i<arr.length;i++) {
			int j = i+1;
			int max = arr[i];
			while(j<arr.length) {
				max = Math.min(max, arr[j]);
				overallMax = Math.max(overallMax, (j-i+1)*max);
				j++;
			}
		}
		return overallMax;
		
	}
	
	public static void main(String args[]) {
		Stack_Complete stack = new Stack_Complete();
		String infix = "1+2*(4+5)-2";
	//	System.out.println(evalInfixWithoutBrackets(infix));
	//	System.out.println(evalInfixWithBrackets(infix));
	//	String postFix = infixToPostFix(infix);
	//	System.out.println(postFix);
	//	System.out.println(postFixEval(postFix));
	//	int[] arr = {100,80,60,70,60,75,85};
	//	stockSpan(arr);
		int[] arr = {6, 2, 5, 4, 5, 1, 6};
		System.out.println(histogramMax(arr));
	}
	
}
