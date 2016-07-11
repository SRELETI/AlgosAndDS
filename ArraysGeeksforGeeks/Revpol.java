import java.util.HashMap;
import java.util.Stack;


	public class Revpol {
	    public int evalRPN(String[] tokens) {
	        Stack<Integer> s = new Stack<Integer>();
	        
	        for(int i=0;i<tokens.length;i++)
	        {
	            if(!tokens[i].equals("+") && !tokens[i].equals("/") && !tokens[i].equals("*") && !tokens[i].equals("-"))
	                s.push(Integer.parseInt(tokens[i]));
	            else
	                {
	                    int num1 = s.pop();
	                    int num2 = s.pop();
	                    int result = getAns(num2,num1,tokens[i]);
	               //     System.out.println(result);
	                    s.push(result);
	                }
	        }
	        return s.pop();
	        
	    }
	    
	    private int getAns(int num1, int num2, String op)
	    {
	        int result = 0;
	        switch(op)
	        {
	            case "+":
	                result =num1 + num2;
	                break;
	            case "/":
	                result = num1/num2;
	                break;
	            case "*":
	                result = num1 * num2;
	                break;
	            case "-":
	                result = num1 * num2;
	                break;
	        }
	        return result;
	    }
	    public static void main(String args[])
	    {
	    	Revpol r = new Revpol();
	    	String[] s = {"0","3","/"};
	    	System.out.println(r.evalRPN(s));
	    }
	}
