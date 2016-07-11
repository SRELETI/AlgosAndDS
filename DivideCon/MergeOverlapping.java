import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class Intervals
{
	int start;
	int end;
	public Intervals(int st, int en)
	{
		start= st;
		end = en;
	}
}
public class MergeOverlapping {

	public void merge(Intervals[] arr)
	{
		if(arr.length<=1)
			return;
	//	Arrays.sort(arr);
		Stack<Intervals> s = new Stack<Intervals>();
		s.push(arr[0]);
		int i=1;
		while(i<arr.length)
		{
			Intervals top = s.peek();
			if(top.end<arr[i].start)
			{
				s.push(arr[i]);
				i++;
			}
			else
			{
				top.end= arr[i].end;
				s.pop();
				s.push(top);
				i++;
			}
		}
		
		while(!s.isEmpty())
		{
			Intervals top = s.pop();
			System.out.println("Start: "+top.start+" End: "+top.end);
		}
		
	}
	
	public static void main(String args[])
	{
		Intervals arr[] = {new Intervals(1,9), new Intervals(2,4), new Intervals(4,7), new Intervals(6,9)};
		MergeOverlapping m = new MergeOverlapping();
		m.merge(arr);
	}
}
