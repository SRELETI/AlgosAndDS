import java.util.Arrays;


public class ShellSortExample {

	public void shell(int[] arr)
	{
		int temp,j;
		for(int gap = arr.length/2;gap>0;gap = gap/2)
		{
			for(int i=gap;i<arr.length;i++)
			{
				temp = arr[i];
				for(j=i;j>=gap && arr[j-gap]>temp;j=j-gap)
					arr[j]=arr[j-gap];
				arr[j]=temp;
			}
		}
	}
	
	public static void main(String args[])
	{
		ShellSortExample s = new ShellSortExample();
		int[] arr ={12,34,54,2,3};
		s.shell(arr);
		System.out.println(Arrays.toString(arr));
	}
}
