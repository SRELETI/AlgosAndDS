
public class LCABSTAoo {

	public static void main(String args[])
	{
		LCABST l = new LCABST();
		
		l.insert(20);
		l.insert(8);
		l.insert(22);
		l.insert(4);
		l.insert(12);
		l.insert(10);
		l.insert(14);
		l.insert(22);
		
		l.findLCA(10, 14);
		
		l.findLCA(14, 8);
		
		l.findLCA(15, 22);
		
		int[] arr = {4,2,5,1,3};
		int start=0;
		int end =arr.length-1;
		l.print_sorted(arr, start, end);
	}
	
}
