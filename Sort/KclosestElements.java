
public class KclosestElements {

	public void getClosest(int[] arr, int element, int k)
	{
		int getElement = findElement(arr,0,arr.length-1,element);
		int r = getElement+1;
		if(arr[getElement]==element)
			getElement--;
		int count=0;
		while(getElement>=0 && r<=arr.length-1 && count<k)
		{
			if(element-arr[getElement]<arr[r]-element)
			{
				System.out.print(arr[getElement]+" ");
				getElement--;
			}
			else
			{
				System.out.print(arr[r]+" ");
				r++;
			}
			count++;
		}
		while(count<k && getElement>=0)
		{
			System.out.print(arr[getElement]+" ");
			getElement--;
			count++;
		}
		while(count<k && r<=arr.length-1)
		{
			System.out.print(arr[r]+" ");
			r++;
			count++;
		}
	}
	
	public int findElement(int[] arr, int left, int right, int element)
	{
		if(arr[right]<=element)
			return right;
		if(arr[left]>=element)
			return left;
		int middle = (left+right)/2;
		if(arr[middle]<=element && element<arr[middle+1])
			return middle;
		else if(element>=arr[middle])
			return findElement(arr,middle+1,right,element);
		else
			return findElement(arr,left,middle-1,element);
	}
	
	public static void main(String args[])
	{
		 int[] arr = {22, 22, 22, 35, 35, 35, 42,
	               42, 44, 44, 53, 53, 56};
		 KclosestElements k = new KclosestElements();
	//	 k.getClosest(arr, 35, 4);
		 k.duplicateGetElements(arr, 35, 4);
		 
	}
	
	public void duplicateGetElements(int[] arr, int element, int k)
	{
		int getElement = findElement(arr,0,arr.length-1,element);
		int r,l;
		r = getElement+1;
		while(arr[getElement]==element)
			getElement--;
		int count = 0;
		int prev = Integer.MAX_VALUE;
		while(getElement>=0 && r<=arr.length-1 && count<k)
		{
			if(element-arr[getElement]<arr[r]-element)
			{
				if(arr[getElement]==prev)
				{
					getElement--;
					continue;
				}
				else
				{
					prev = arr[getElement];
					System.out.print(arr[getElement]+" ");
					count++;
					getElement--;
				}
			}
			else
			{
				if(arr[r]==prev)
				{	
					r++;
					continue;
				}
				else
				{
					prev = arr[r];
					System.out.print(arr[r]+" ");
					count++;
					r++;
				}
			}
		}
				
		while(count<k && getElement>=0)
		{
			if(prev == arr[getElement])
			{
				getElement--;
				continue;
			}
			else
			{
				prev= arr[getElement];
				System.out.print(arr[getElement]+" ");
				getElement--;
				count++;
			}
		}
		
		while(count<k && r<=arr.length-1)
		{
			if(prev == arr[r])
			{
				r++;
				continue;
			}
			else
			{
				prev = arr[r];
				System.out.print(arr[r]+" ");
				r++;
				count++;
			}
		}
	}
}
