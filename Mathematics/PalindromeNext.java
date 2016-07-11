import java.util.Arrays;


public class PalindromeNext {

	
	
	public void checkPalin(int[] num)
	{
		if(isAll9(num,num.length)==true)
		{
			System.out.print(1);
			for(int i=1;i<num.length;i++)
				System.out.print(0);
			System.out.print(1);
			return;
		}
		checkPalinUtils(num,num.length);
		
		
	}
	
	private void checkPalinUtils(int[] num, int n)
	{
		int mid = n/2;
		int left = mid-1;
		boolean isLeftSmaller = false;
		int right;
		if(n%2==0)
			right = mid;
		else
			right = mid+1;
		while(left>=0 && num[left]==num[right])
		{
			left--;
			right++;
		}
		if(left<0 || num[left]<num[right])
			isLeftSmaller = true;
		while(left>=0)
		{
			num[right]=num[left];
			left--;
			right++;
		}
		if(isLeftSmaller == true)
		{
			int carry =1;
			left = mid-1;
			if(n%2==1)
			{
				num[mid]= num[mid]+carry;
				carry = num[mid]/10;
				num[mid]=num[mid]%10;
				right= mid+1;
			}
			else
				right = mid;
			while(left>=0)
			{
				num[left]=num[left]+carry;
				carry = num[left]/10;
				num[left]=num[left]%10;
				num[right++]=num[left--];
			}
		}
		System.out.println(Arrays.toString(num));
	}
	
	private boolean isAll9(int[] num, int length)
	{
		for(int i=0;i<num.length;i++)
		{
			if(num[i]!=9)
				return false;
		}
		return true;
	}
	
	public static void main(String args[])
	{
		PalindromeNext p = new PalindromeNext();
		int[] num = {1,4,5,8,7,6,7,8,3,2,2};
		p.checkPalin(num);
		
	}
	
	
}
