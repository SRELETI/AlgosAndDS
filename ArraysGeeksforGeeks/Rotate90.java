
public class Rotate90 {
	public static void main(String args[])
	{
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		rotate90(arr);
	}
	public static void rotate90(int[][] arr)
	{
		System.out.println("Image before rotation: ");
		display(arr);
		int[][] dest = new int[arr[0].length][arr.length];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				dest[j][arr.length-i-1]=arr[i][j];
			}
		}
		System.out.println("Image after rotation: ");
		display(dest);
	}
	public static void display(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
