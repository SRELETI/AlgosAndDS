import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PermutateNumbers {
	List<Integer> res;
	List<List<Integer>> result;
	boolean isUsed[];
	private void permute(int[] num) {
		permutation(num,0,num.length-1, new ArrayList<List<Integer>>());
	}
	
	private void permutation(int[] num, int start, int end, List<List<Integer>> l) {
		if(start==end)
		{
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i=start;i<=end;i++) {
			swap(num,i,start);
			permutation(num,start+1,end,l);
			swap(num,i,start);
		}
	}
	
	private void swap(int[] num, int start, int end) {
		int temp = num[start];
		num[start] = num[end];
		num[end] = temp;
	}
	
	public static void main(String args[]) {
		PermutateNumbers p = new PermutateNumbers();
		int[] num = {1,1,1};
		p.permute(num);
	//	int[] num = {3,3,0,0,2,3,2};
	//	p.permuteUnique(num);
	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        Set<List<Integer>> s = new HashSet<List<Integer>>();
        permutation(num,0,num.length-1,l,s);
        return l;
    }
    
    private void permutation(int[] num, int start, int end, List<List<Integer>> l,Set<List<Integer>> s) {
        if(start==end) {
            List<Integer> ll = new ArrayList<Integer>();
            for(int i=0;i<num.length;i++)
                ll.add(num[i]);
            if(s.contains(ll)==false)
            {
                s.add(ll);
                System.out.println(Arrays.toString(ll.toArray()));
            }
            return;
        }
        
        for(int i=start;i<=end;i++) {
            swap(num,i,start);
            permutation(num,start+1,end,l,s);
            swap(num,i,start);
        }
    }
    
    public List<List<Integer>> permuteUnique2(int[] num) {
    	int len = num.length;
    	res = new ArrayList<Integer>();
    	result = new ArrayList<List<Integer>> ();
    	isUsed = new boolean[len];
    	Arrays.sort(num);
    	permuteNow(num);
    	return result;
    }
    
    private void permuteNow(int[] num) {
    	if(res.size()== num.length)
    	{
    		result.add(res);
    		return;
    	}
    	for(int i=0;i<num.length;i++) {
    		if(isUsed[i]==true)
    			continue;
    		if(i>0 && num[i]==num[i-1] && isUsed[i-1]==false)
    			continue;
    		isUsed[i] = true;
    		res.add(num[i]);
    		permuteNow(num);
    		isUsed[i] = false;
    		res.remove(res.size()-1);
    	}
    }
}
