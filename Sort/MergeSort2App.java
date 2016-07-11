
public class MergeSort2App {
	public static void main(String args[])
	{
		MergeSort2 ms = new MergeSort2(5);
		ms.insert(5);
	/*	ms.insert(1);
		ms.insert(3);
		ms.insert(2);
		ms.insert(4);*/
		ms.display();
		ms.merge(ms.arr);
		ms.display();
	}
}
