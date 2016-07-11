import java.util.Arrays;


public class MergeMN {
	private int[] arrMN;
	private int[] arrN;
	private int n;
	private int mn;
	public MergeMN(int mn, int nn)
	{
		this.n=0;
		this.mn=0;
		arrMN=new int[mn];
		arrN= new int[nn];
	}
	public void insert(int value,int index)
	{
		if(index>=arrMN.length)
			return;
		arrMN[index]=value;
		mn++;
	}
	public void insert(int value)
	{
		arrN[n]=value;
		n++;
	}
	public int[] MergeArrays()
	{
		moveMN();
		return Merge();
	}
	public void moveMN()
	{
		int i=arrMN.length-1;
		int j=arrMN.length-1;
		for(i=arrMN.length-1;i>=0;i--)
		{
			if(arrMN[i]!=0)
			{
				arrMN[j]=arrMN[i];
				j--;
			}
		}
	}
	public void display()
	{
		System.out.println(Arrays.toString(arrMN));
		System.out.println(Arrays.toString(arrN));
	}
	public int[] Merge()
	{
		int i=n;
		int j=0;
		int k=0;
		
		while(k<(arrMN.length))
		{
			if((i< (arrMN.length) && arrMN[i]<=arrN[j]) || j==n)
			{
				arrMN[k]=arrMN[i];
				k++;
				i++;
			}
			else
			{
				arrMN[k]=arrN[j];
				k++;
				j++;
			}
		}
		return arrMN;
	}
}
