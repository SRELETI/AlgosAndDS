import java.util.Arrays;


public class MergeMNApp {
	public static void main(String args[])
	{
		MergeMN mn = new MergeMN(10,4);
		mn.insert(1, 1);
		mn.insert(2, 3);
		mn.insert(3, 5);
		mn.insert(4, 7);
		mn.insert(5, 9);
		mn.insert(0, 0);
		mn.insert(6);
		mn.insert(7);
		mn.insert(8);
		mn.insert(9);
		mn.display();
		System.out.println(Arrays.toString(mn.MergeArrays()));
	}
}
