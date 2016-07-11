
public class SetBitPos {

	public void setbit(int x)
	{
		if((x & (x-1))==0)
		{
			int count = 0;
			while(x>0)
			{
				count++;
				x = x>>1;
			}
			System.out.println(count);
		}
		else
		{
			System.out.println("Has more than one set bit");
		}
	}
	
	public static void main(String args[])
	{
		SetBitPos s = new SetBitPos();
	//	s.setbit(4);
		s.swap(11, 7);
		s.swap2(11, 7);
		s.swap3(11, 7);
		System.out.println(s.check_9(9));
		s.swap_nibbles(22);
		s.remove_bit(9, 4);
		s.isPalin((1<<31));
	}
	
	public void remove_bit(int x, int d)
	{
		int y = 1<<(d-1);
		System.out.println(x^y);
	}
	public void swap_nibbles(int c)
	{
		int x = (c&0x0F)<<4;
		int y = (c&0xF0)>>4;
		System.out.println(x|y);
	}
	
	public void isPalin(int c)
	{
		int l = 1;
		int r = Integer.SIZE;
		while(l<r)
		{
			if(isSetBit(c,l)==isSetBit(c,r))
			{
				l++;
				r--;
			}
			else
			{
				System.out.println("Not palin");
				return;
			}
		}
		System.out.println("Is palin");
	}
	private boolean isSetBit(int c, int pos)
	{
		if((c&(1<<(pos-1)))!=0)
			return true;
		return false;
	}
	public void swap(int x, int y)
	{
		System.out.println(" X and Y before swap "+x+" "+y);
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println(" X and Y after swap "+x+" "+y);
	}
	public void swap2(int x, int y)
	{
		System.out.println("X and Y before swap "+x+" "+y);
		x = x + y;
		y = x-y;
		x = x-y;
		System.out.println("X and Y after swap "+x+" "+y);
	}
	
	public void swap3(int x, int y)
	{
		System.out.println("X and y before swap "+x+" "+y);
		x = x*y;
		y = x/y;
		x = x/y;
		System.out.println("X and Y after swap "+x+" "+y);
	}
	
	public boolean check_9(int x)
	{
		if(x==0 || x==9)
			return true;
		if(x<9)
			return false;
		return check_9((x>>3) - (x&7)); 
	}
}
