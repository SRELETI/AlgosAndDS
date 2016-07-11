import java.awt.List;
import java.util.Arrays;
import java.util.Collections;

public class LargestMultiple3 {

	public boolean largest(int[] arr)
	{
		Arrays.sort(arr);
		Queue q = new Queue(10);
		Queue q1 = new Queue(10);
		Queue q2 = new Queue(10);
		
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum = sum+arr[i];
			if(arr[i]%3==0)
				q.insert(arr[i]);
			else if(arr[i]%3==1)
				q1.insert(arr[i]);
			else
				q2.insert(arr[i]);
		}
		
		if(sum%3==1)
		{
			if(!q1.isEmpty())
				q1.delete();
			else
			{
				if(!q2.isEmpty())
					q2.delete();
				else
					return false;
				if(!q2.isEmpty())
					q2.delete();
				else
					return false;
			}
		}
		else if(sum%3==2)
		{
			if(!q2.isEmpty())
				q2.delete();
			else
			{
				if(!q1.isEmpty())
					q1.delete();
				else
					return false;
				if(!q1.isEmpty())
					q1.delete();
				else
					return false;
			}
		}
		
		int temp[] = new int[arr.length];
		int top=0;
	//	populate(temp,top,q,q1,q2);
		Arrays.sort(temp, 0, top);
	//	printArray(temp,top);
		return true;
	}
	
/*	private populate(int[] temp, int top, Queue q, Queue q1, Queue q2)
	{
		while(!q.isEmpty())
			temp[top++]=q.delete();
		
	}
	*/
}
