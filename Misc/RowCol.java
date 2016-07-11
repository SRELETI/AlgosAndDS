import java.util.Stack;


public class RowCol {
	public static void main(String args[])
	{
		int[][] arr = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
		//rowCol(arr,70);
		int[] arr2={11,13,21,3};
		greater(arr2);
		greater_mod(arr2);
	}
	public static void rowCol(int[][] arr, int x)
	{
		int i=0;
		int j=arr[0].length-1;
		while(i<arr.length && j>=0)
		{
			if(x==arr[i][j])
			{
				System.out.println("the indexes are "+i+" "+j);
				return;
			}
			else if(x>arr[i][j])
				i++;
			else
				j--;
		}
		System.out.println("Element not found");
	}
	public static void greater(int[] arr)
	{
		int j;
		for(int i=0;i<arr.length;i++)
		{
			for(j=i+1;j<arr.length;j++)
			{
				if(arr[j]>arr[i])
				{
					System.out.println("The next greater for "+arr[i]+" is "+arr[j]);
					break;
				}
			}
			if(j==arr.length)
				System.out.println("The element "+arr[i]+" doesnt have a greater element");
		}
	}
	public static void greater_mod(int[] arr)
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(arr[0]);
		for(int i=1;i<arr.length;i++)
		{
			int next=arr[i];
			if(!s.isEmpty())
			{
				int element=(int) s.pop();
				while(element<next)
				{
					System.out.println("The greater element for "+element+" is "+next);
					if(s.isEmpty())
						break;
					element=(int) s.pop();
				}
				if(element>next)
					s.push(element);
			}
			s.push(next);
		}
		while(!s.isEmpty())
		{
			int element=(int) s.pop();
			int next=-1;
			System.out.println("The greater element for "+element+" is "+next);
		}
	}
}
