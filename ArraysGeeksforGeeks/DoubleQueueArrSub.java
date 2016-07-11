
public class DoubleQueueArrSub {

	public void check(int[] arr,int size)
	{
		DoubleQueueLink que = new DoubleQueueLink();
		for(int i=0;i<size;i++)
		{
			while(!que.isEmpty() && arr[i]>=arr[que.back()])
				que.dequeue_back();
			que.enqueue_back(i);
		}
		
		for(int i=size;i<arr.length;i++)
		{
			System.out.println(arr[que.front()]);
			while(!que.isEmpty() && que.front() <= i-size)
				que.dequeue_front();
			while(!que.isEmpty() && arr[i]>=arr[que.back()])
				que.dequeue_back();
			que.enqueue_back(i);
		}
		System.out.println(arr[que.front()]);
	}
	
	public static void main(String args[])
	{
		DoubleQueueArrSub q = new DoubleQueueArrSub();
		int[] arr = {12,1,78,90,57,89,56};
		q.check(arr, 3);
	}
}
