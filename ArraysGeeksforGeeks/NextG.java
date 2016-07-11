import java.util.Stack;


public class NextG {

	public void next(int[] arr)
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(arr[0]);
		int i=1;
		while(i<arr.length)
		{
			while(!s.isEmpty() && s.peek()<arr[i])
			{
				int temp =s.pop();
				System.out.println("element "+temp +" greater "+arr[i]);
			}
			s.push(arr[i]);
			i++;
		}
		while(!s.isEmpty())
		{
			System.out.println("element "+s.pop()+" greater "+(-1));
		}
	}
	
	public static void main(String args[])
	{
		int[] arr = {13,7,6,12};
		NextG g = new NextG();
		g.next(arr);
	}
}
