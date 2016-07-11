import java.util.Arrays;


public class LargestMulThree {

	public int largest(int[] arr) {
		if(arr.length==0)
			return 0;
		Arrays.sort(arr);
		MainQueueLL q1 = new MainQueueLL();
		MainQueueLL q2 = new MainQueueLL();
		MainQueueLL q3 = new MainQueueLL();
		
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum = sum+arr[i];
			if(arr[i]%3==0)
				q1.enqueue(arr[i]);
			else if(arr[i]%3==1)
				q2.enqueue(arr[i]);
			else
				q3.enqueue(arr[i]);
		}
		
		if(sum%3==1)
		{
			if(!q2.isEmpty())
				q2.dequeue();
			else
			{
				if(!q3.isEmpty())
					q3.dequeue();
				else
					return -1;
				if(!q3.isEmpty())
					q3.dequeue();
				else
					return -1;
			}
		}
		else if(sum%3==2)
		{
			if(!q3.isEmpty())
				q3.dequeue();
			else
			{
				if(!q2.isEmpty())
					q2.dequeue();
				else
					return -1;
				if(!q2.isEmpty())
					q2.dequeue();
				else
					return -1;
			}
		}
		int result[] = new int[arr.length];
		int top = pop(result,q1,q2,q3);
		qsort(result,0,top);
		for(int i=0;i<=top;i++)
			System.out.print(result[i]+" ");
		return 0;
	}
	
	private void qsort(int[] arr,int left, int right) {
		if(left<right)
		{
			int partition = findPart(arr,left,right);
			qsort(arr,left,partition-1);
			qsort(arr,partition+1,right);
		}
	}
	
	private int findPart(int[] arr, int left,int right) {
		int part = right;
		int temp =left;
		for(int i = left;i<right;i++)
		{
			if(arr[i]>arr[part])
			{
				swap(arr,i,temp);
				temp++;
			}
		}
		swap(arr,temp,part);
		return temp;
	}
	
	private void swap(int[] arr, int temp1, int temp2) {
		int temp = arr[temp1];
		arr[temp1] = arr[temp2];
		arr[temp2] = temp;
	}
	private int pop(int[] result, MainQueueLL q1, MainQueueLL q2, MainQueueLL q3) {
		int i=0;
		while(!q1.isEmpty())
			result[i++] = q1.dequeue();
		while(!q2.isEmpty())
			result[i++] = q2.dequeue();
		while(!q3.isEmpty())
			result[i++] = q3.dequeue();
		return i-1;
	}
	public int largest_opt(int[] arr) {
		if(arr.length==0)
			return 0;
		Arrays.sort(arr);
		int del1=Integer.MAX_VALUE,del2=Integer.MAX_VALUE;
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum = sum+arr[i];
		}
		
		if(sum%3==1)
		{
			int i=0;
			for(i=0;i<arr.length;i++)
			{
				if(arr[i]%3==1)
				{
					del1 = arr[i];
					break;
				}
			}
			if(i==arr.length)
			{
				i=0;
				for(i=0;i<arr.length;i++)
				{
					if(arr[i]%3==2 && arr[i]<del1)
					{
						del1 = arr[i];
					}
					else if(arr[i]%3==2 && arr[i]>del1)
					{
						del2 = arr[i];
						break;
					}
				}
				if(i==arr.length)
					return -1;
			}
		}
		else if(sum%3==2)
		{
			int i=0;
			for(i=0;i<arr.length;i++)
			{
				if(arr[i]%3==2)
				{
					del1 = arr[i];
					break;
				}
			}
			if(i==arr.length)
			{
				i=0;
				for(i=0;i<arr.length;i++)
				{
					if(arr[i]%3==1 && arr[i]<del1)
					{
						del1 = arr[i];
					}
					else if(arr[i]%3==1 && arr[i]>del1)
					{
						del2 = arr[i];
						break;
					}
				}
				if(i==arr.length)
					return -1;
		}
		for(int p=arr.length-1;p>=0;p--)
		{
			if(arr[p]==del1 || arr[p]==del2)
				p--;
			if(p>=0)
				System.out.print(arr[p]+" ");
		}
		}
		return 0;
	}
	
	public static void main(String args[]) {
		LargestMulThree l = new LargestMulThree();
		int[] arr = {8,1,9};
		l.largest(arr);
	}
}
