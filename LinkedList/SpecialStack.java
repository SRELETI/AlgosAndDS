
public class SpecialStack {
	private int[] arr;
	private int[] arr_min;
	private int count;
	private int max_count;
	private int count_min;
	public SpecialStack(int length) {
		arr = new int[length];
		arr_min = new int[length];
		count = 0;
		count_min = 0;
		max_count = length;
	}
	
	public void push(int val) {
		if(isFull())
			return;
		if(!isEmpty() && getMin()<val)
			arr_min[count] = getMin();
		else
			arr_min[count] = val;
		arr[count++] = val;
	}
	
	public void push_opt(int val) {
		if(isFull())
			return;
		if(isEmpty())
		{
			arr_min[count_min++]= val;
			arr[count++] = val;
		}
		else
		{
			if(val<arr_min[count_min-1])
			{
				arr_min[count_min++] = val;
				arr[count++] = val;
			}
			else
			{
				arr[count++] = val;
			}
		}
	}
	
	public int pop_opt() {
		if(isEmpty())
			return -1;
		if(peek()==peek_min())
		{
			count_min--;
		}
		int temp = arr[--count];
		return temp;
	}
	public int pop() {
		if(isEmpty())
			return -1;
		int temp = arr[--count];
		return temp;
	}
	
	public int getMin() {
		return arr_min[count-1];
	}
	
	public int getMin_opt() {
		return arr_min[count_min-1];
	}
	
	public boolean isFull() {
		return count==max_count;
	}
	
	public boolean isEmpty() {
		return count ==0;
	}
	public int peek_min() {
		if(isEmpty())
			return -1;
		return arr_min[count_min-1];
	}
	public int peek() {
		if(isEmpty())
			return -1;
		return arr[count-1];
	}
	
	public static void main(String args[]) {
		SpecialStack s = new SpecialStack(6);
		s.push_opt(18);
		s.push_opt(19);
		s.push_opt(29);
		s.push_opt(15);
		s.push_opt(16);
		s.pop_opt();
		s.pop_opt();
		System.out.println(s.getMin_opt());
	}
}
