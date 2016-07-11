
public class SortApp {
	public static void main(String args[])
	{
		SelectionSort2 ss = new SelectionSort2(5);
		ss.add(5);
		ss.add(4);
		ss.add(6);
		ss.add(3);
		ss.add(7);
		ss.display();
		ss.mergeSort(ss.arr);
	//	ss.insertionSort();
	//	ss.bubbleSort();
	//	ss.selectionSort();
		ss.display();
		
	}
}
