
public class Rotation {

	public boolean rotate(String str, String str2)
	{
		String s = (str.concat(str));
	//	StringBuilder ss = new StringBuilder(str2);
		if(s.contains(str2))
			return true;
		else
			return false;
	}
	
	public static void main(String args[])
	{
		Rotation r = new Rotation();
		
		String str = "ABCD";
		String str2 = "ACBD";
		
		System.out.println(r.rotate(str, str2));
	}
}
	