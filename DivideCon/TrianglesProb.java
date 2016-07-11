import java.util.Arrays;


public class TrianglesProb {

	public void triangle(int[] arr)
	{
		Arrays.sort(arr);
		int i,j,k;
		int count=0;
		for(i=0;i<arr.length;i++)
		{
			k = i+2;
			for(j=i+1;j<arr.length;j++)
			{
				while(k<arr.length && arr[i]+arr[j]>arr[k])
					k++;
				count = count+(k-j-1);
			}
			
		}
		
		System.out.println(count);
	}
	
	public static void main(String args[])
	{
		int[] arr = {4,6,3,7};
		TrianglesProb t = new TrianglesProb();
		t.triangle(arr);
	}
}
