import java.util.Arrays;


public class Binary {
	char[][] arr;
	int length;
	int len;
	public Binary(int lengt)
	{
		length=lengt;
		len=(int) ((Math.log(lengt)/Math.log(2))+1);
		arr=new char[len][length];
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<length;j++)
			arr[i][j]='-';
		}
	}
	public void make()
	{
		makeBinary(arr,0,length-1,0);
		display();
	}
	public static void main(String args[])
	{
		int length=16;
		Binary br = new Binary(length);
		br.make();
		
	}
	public void makeBinary(char[][] arr,int left,int right,int row)
	{
		if(left>right || row>len-1)
			return;
		int middle=(left+right)/2;
		arr[row][middle]='X';
		makeBinary(arr,left,middle,row+1);
		makeBinary(arr,middle+1,right,row+1);
	}
	public void display()
	{
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
