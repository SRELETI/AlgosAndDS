import java.util.Arrays;


public class OrderedArrayApp {
	public static void main(String args[])
	{
		OrderedArray ar=new OrderedArray(30);
		ar.insert(20);
		ar.insert(30);
		ar.insert(40);
		ar.display();
		ar.find(30);
		ar.insert(25);
		ar.display();
		ar.insert(10);
		ar.display();
		ar.insert(45);
		ar.display();
		ar.size();
		ar.delete(30);
		ar.display();
		int[] arr1=new int[10];
		for(int i=0;i<arr1.length;i++)
			arr1[i]=i+5;
		int[] arr2=new int[10];
		for(int i=0;i<arr2.length;i++)
			arr2[i]=i+4;
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(ar.merge(arr1, arr2)));
	}
}
