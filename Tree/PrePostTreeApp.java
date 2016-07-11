
public class PrePostTreeApp {

	public static void main(String args[])
	{
		
		PrePostTree  p = new PrePostTree();
		
		int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
	    int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
	    
	    int start =0;
	    int end =pre.length-1;
	    
	    p.construct(pre, post, start, end);
	    
	}
}
