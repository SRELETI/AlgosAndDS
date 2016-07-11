import java.util.Stack;


public class NextGreater {
	public static void main(String args[])
	{
		int[] arr={5,4,6,2,7};
		next(arr);
		next_greater(arr);
	}
	public static void next(int[] arr)
	{
		int i,j;
		for(i=0;i<arr.length-1;i++)
		{
			for(j=i+1;j<arr.length;j++)
			{
				if(arr[j]>arr[i])
					break;
			}
			if(j!=arr.length)
				System.out.println("The next greatest element for "+arr[i]+" is "+arr[j]);
		}
	}
	public static void next_greater(int arr[])
	{
		int next;
		int element;
		Stack<Integer> s = new Stack();
		s.push(arr[0]);
		for(int i=1;i<arr.length;i++)
		{
			next=arr[i];
			if(s.isEmpty()==false)
			{
				element=(int) s.pop();
				while(element<next)
				{
					System.out.println("The element "+element+" has greater element "+next);
					if(s.isEmpty())
						break;
					element=(int) s.pop();
				}
				if(element>next)
					s.push(element);
			}
			s.push(next);
		}
		while(s.isEmpty()==false)
		{
			element=(int) s.pop();
			next=-1;
			System.out.println("The element "+element+" has no greater element"+ next);
		}
	}
}
