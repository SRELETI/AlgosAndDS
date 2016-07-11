import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
public class CombinationSum {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		if(num.length==0)
			return new ArrayList<List<Integer>>();
		Arrays.sort(num);
		List<List<Integer>> res = helper(num,target,0);
		if(res==null)
			return new ArrayList<List<Integer>>();
		
		return res;
	}
	
	private List<List<Integer>> helper(int[] num, int target, int index) {
		if(index>=num.length || num[index]>target)
			return null;
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<List<Integer>> s = new HashSet<List<Integer>> ();
		for(int i=index;i<num.length;i++) {
			if(num[i]>target)
				break;
			List<Integer> temp = new ArrayList<Integer>();
			if(num[i]==target) {
				temp.add(num[i]);
				res.add(temp);
				return res;
			}
			List<List<Integer>> t = helper(num,target-num[i],i+1);
			if(t!=null) {
				for(List<Integer> a: t) {
					a.add(num[i]);
					if(s.contains(a)==false)
					{
						s.add(a);
						res.add(a);
					}
				}
			}
		}
		return res;
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		if(candidates.length==0)
			return l;
		Arrays.sort(candidates);
		List<Integer> temp = new ArrayList<Integer>();
		rec_now(temp,candidates,target,0,l);
		return l;
	}
	
	private void rec_now(List<Integer> temp, int[] num, int target, int index, List<List<Integer>> l) {
		if(target==0)
		{
			l.add(temp);
			return;
		}
		
		for(int i=index;i<num.length;i++) {
			int newTarget = target-num[i];
			if(newTarget>=0) {
				List<Integer> copy = new ArrayList<Integer>(temp);
				copy.add(num[i]);
				rec_now(copy,num,newTarget,i,l);
			}
			else
				break;
		}
	}
	public static void main(String args[]) {
		CombinationSum c = new CombinationSum();
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> l = c.combinationSum2(num, target);
		Iterator<List<Integer>> a = l.iterator();
		while(a.hasNext()) {
			System.out.println(Arrays.toString(a.next().toArray()));
		}
	}
}

