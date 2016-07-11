import java.util.Arrays;


public class Microsoft {
	private int[] arr={1,2,4,3,4,5,6};
	public void remove()
	{
		int i=-1;
		int j=0;
		for(j=0;j<arr.length;j++)
		{
			if(arr[j]!=0)
			{
				i++;
				arr[i]=arr[j];
			}
		}
		for(i=i+1;i<arr.length;i++)
		{
			arr[i]=0;
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String args[])
	{
		Microsoft m = new Microsoft();
		m.remove();
	}
}
