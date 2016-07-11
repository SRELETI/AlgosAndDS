
public class TreeIdenticalApp {
	public static void main(String args[])
	{
		TreeIdentical ti = new TreeIdentical();
		ti.insert(4);
		ti.insert(3);
		ti.insert(2);
		ti.insert(1);
	
		ti.insert2(1);
		ti.insert2(2);
		ti.insert2(3);
		ti.insert2(4);
		
		System.out.println(ti.identicalTrees());
	}
}
