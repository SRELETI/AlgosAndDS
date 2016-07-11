import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class PartitionIt
{
	public static void partitionIt(int[] a, int l, int r, int pivot)
	{
		int i,j;
		i = j = l+1;
		int k=pivot;
		boolean swapped  = false;
		while(j<= r)
		{
			if(a[j] < a[pivot])
			{
				swap(a,j,i);
				if(a[i]<a[k])
					k=i;
				i++;
			}	
			j++;
		}
			--i;
		//	System.out.println(a[k]);
			if(i!=k)
			{
				swap(a,pivot,i);
				swap(a,pivot,k);
			}
			else
				swap(a,pivot,i);
	}
	
	public static void swap(int[] a, int j, int i)
	{
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public static void displayArray(int[] a)
	{
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}
	
	public static int QuickSort(int[] a, int l, int r)
	{
		if(r < l)
			return 0;
		int pivot = getPivot(a,l,r);
		
		partitionIt(a,l,r,pivot);
		int x = (pivot - l) +QuickSort(a,l,pivot-1);		
		int y = (r-(pivot+1)) + QuickSort(a,pivot+1,r);
		return x + y;
	}
	
	public static int getPivot(int[] a,int l,int r)
	{
		return l;
	}
	
	public static int[] readData() throws Exception
	{
		ArrayList<Integer> data = new ArrayList<Integer>();
		File f = new File("C:\\Users\\IBM_ADMIN\\Downloads\\QuickSort_test.txt");
		System.out.println(f.exists());
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		while ((line = br.readLine()) != null) 
		{
			data.add(Integer.parseInt(line));
		}
		br.close();
	
		int[] theData = new int[data.size()];
	
		for(int i =0; i< data.size(); i++)
		{
			theData[i] = (int)data.get(i);
		}
	
		return theData;
	}
	
	public static boolean isSorted(int[] a)
	{
		for(int i = 1; i< a.length; i++)
			if(a[i] < a[i-1])
			{	
				System.out.println(a[i] +" " +a[i-1]);
				return false;
			}
		return true;
	}
		
		
		
		
	
	public static void main(String[] args) throws Exception
	{
		int[] theArray = readData(); // 9 split inversions
	//	displayArray(theArray);
	//	System.out.println(theArray.length);
	//	System.out.println(Arrays.toString(theArray));
		System.out.println(QuickSort(theArray,0,theArray.length-1));
	//	System.out.println(Arrays.toString(theArray));
		
		System.out.println("****");
		System.out.println(isSorted(theArray));
	/*	int[] c = {2148,9058,7742,3153,6324,609,7628,5469,7017,504,4092,1582,9572,1542,5697,2081,4218,3130,7923,9595,6558,3859,9832,3062,6788,7578,7432,479,8439,9079};
		System.out.println(QuickSort(c,0,c.length-1));
		System.out.println(isSorted(c));
		displayArray(c);
		*/
		
	}
	
    
	
	/*f
	//Unit Testing	
	
	public static void main(String[] args)
	{
		
		int[] a = {3,2,8,5,1,4,7,6};
		int[] b = {1,2,3,4,5,6,7,8,9,0};
		int[] c = {5,4,2,4,7,6,5,3,2,1,10};
		
		displayArray(a);
		System.out.println("After Parititon with pivot 3");
		System.out.println(QuickSort(a,0,a.length-1));
		displayArray(a);
		System.out.println();
		
		displayArray(b);
		System.out.println("After Parititon with pivot 1");
		System.out.println(QuickSort(b,0,b.length-1));
		displayArray(b);
		System.out.println();
		
			
		displayArray(c);
		System.out.println("After Parititon with pivot 5");
		System.out.println(QuickSort(c,0,c.length-1));
		displayArray(c);
		System.out.println();	
	}
		//*/
}