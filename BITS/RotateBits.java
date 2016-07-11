
public class RotateBits {

	public void rotate(int x, int d)
	{
		int result = x<<d|x>>(32-d);
		System.out.println(result);
	}
	
	public void right_rotate(int x, int d)
	{
		int result = x>>d|x<<(32-d);
		System.out.println(result);
	}
	
	public static void main(String args[])
	{
		RotateBits r = new RotateBits();
		r.rotate(3, 3);
		r.right_rotate(24, 3);
		int[] arr = {2,4,7,9,2,4};
		r.non_repeat(arr);
		r.integer_Overflow(Integer.MAX_VALUE, -5);
		r.byte_order();
	}
	
	public void integer_Overflow(int a, int b)
	{
		int result = a + b;
		if(a>0 && b>0 && result<0)
		{
			System.out.println("Integer Overflow");
			return;
		}
		else if(a<0 && b<0 && result>0)
		{
			System.out.println("Integer Overflow ");
			return;
		}
		else
		{
			System.out.println("No Integer Overflow");
		}
	}
	
	public void non_repeat(int[] arr)
	{
		int length = arr.length;
		int x =0;
		int y=0;
		int xor=0;
		for(int i=0;i<length;i++)
			xor = xor ^ arr[i];
		int set_bit = xor & ~(xor-1);
		for(int i=0;i<arr.length;i++)
		{
			if((arr[i]&set_bit) >0)
				x = x ^ arr[i];
			else
				y = y ^ arr[i];
		}
		
		System.out.println(x+" "+y);
	}
	
	public void byte_order()
	{
		if(java.nio.ByteOrder.LITTLE_ENDIAN==java.nio.ByteOrder.nativeOrder())
			System.out.println("Little Endian");
		else
			System.out.println("Big Endian");
	}
	
	
}
