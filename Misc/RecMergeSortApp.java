
public class RecMergeSortApp {
	public static void main(String args[])
	{
		int length=10;
		RecMergeSort rms = new RecMergeSort(length);
		rms.insert(5);
		rms.insert(4);
		rms.insert(1);
		rms.insert(7);
		rms.insert(6);
		rms.insert(8);
		rms.display();
		rms.sorting();
		rms.display();
	}
}
