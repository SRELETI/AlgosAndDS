import java.util.Stack;

public class MinStack {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    public void push(int x) {
    
        if(s1.isEmpty())
        {
            s1.push(x);
            s2.push(x);
        }
        else
        {
            s1.push(x);
            int p = getMin();
            if(p>x)
            {
                s2.push(x);
            }
            else
                s2.push(p);
        }
    }

    public void pop() {
       if(s1.isEmpty())
            return;
       s1.pop();
       s2.pop();
    }

    public int top() {
       return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }


  
    
    public static void main(String args[]) {
    	MinStack m = new MinStack();
    	m.push(4);
    	m.push(3);
    	m.push(6);
    	m.push(1);
    	m.pop();
    	System.out.println(m.getMin());
    }
}
