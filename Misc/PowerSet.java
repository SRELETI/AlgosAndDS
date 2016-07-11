import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PowerSet {
	public static void main(String args[])
	{
		Set<Integer> original= new HashSet<Integer>(3);
		original.add(1);
		original.add(2);
		original.add(3);
		Set<Set<Integer>> result=PowerSet.powerSet(original);
		System.out.println(result.toString());
	}
	public static Set<Set<Integer>> powerSet(Set<Integer> originalSet)
	{
		Set<Set<Integer>> result=new HashSet<Set<Integer>>();
		if(originalSet.isEmpty())
		{
			Set<Integer> empty= new HashSet<Integer>();
			result.add(empty);
			return result;
		}
			List<Integer> duplicate = new ArrayList<Integer>(originalSet);
			Integer head = duplicate.get(0);
			Set<Integer> rest= new HashSet<Integer>(duplicate.subList(1, duplicate.size()));
			for(Set<Integer> set: powerSet(rest))
			{
				Set<Integer> temp= new HashSet<Integer>();
				temp.add(head);
				temp.addAll(set);
				result.add(set);
				result.add(temp);
			}
			return result;
	}
}
