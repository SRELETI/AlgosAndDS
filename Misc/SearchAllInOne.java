import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class SearchAllInOne {
	
	
	public int binarySearch(int[] arr, int left, int right,int element) {
		if(left<=right) {
			int mid = left +(right-left)/2;
			if(arr[mid]==element)
				return mid;
			else if(arr[mid]>element)
				return binarySearch(arr,left,mid-1,element);
			else
				return binarySearch(arr,mid+1,right,element);
		}
		return -1;
	}
	
	public int binarySearch_It(int[] arr, int element) {
		if(arr==null || arr.length==0) return -1;
		int left = 0;
		int right = arr.length-1;
		while(left<=right) {
			int mid = left+(right-left)/2;
			if(arr[mid]==element)
				return mid;
			else if(arr[mid]>element)
				right = mid-1;
			else
				left = mid+1;
		}
		return -1;
	}
	
	/*
	 * Selection Sort
	 */
	public void selectionSort(int[] arr) {
		if(arr==null || arr.length==0) return;
		for(int i=0;i<arr.length-1;i++) {
			int min = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min])
					min = j;
			}
			swap(arr,i,min);
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Swap method
	 */
	public void swap(int[] arr, int left, int right)  {
		int temp =arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	/*
	 * Bubble Sort
	 */
	public void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=1;j<arr.length-i;j++) {
				if(arr[j-1]>arr[j])
					swap(arr,j-1,j);
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Insertion Sort
	 */
	public void insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>=key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Radix Sort
	 */
	public void radixSort(double[] arr) {
		Vector<Double>[] v = new Vector[10];
		for(int i=0;i<arr.length;i++) {
			v[0] = new Vector<Double>(arr.length);
		}
		
		int n= arr.length;
		for(int i=0;i<arr.length;i++) {
			int bi = (int)(n*arr[i]);
			v[bi].add(arr[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			Collections.sort(v[i]);
		}
		
	}
	
	/*
	 * Counting Sort:
	 * Used when the data in a particular range and the values can be used as keys
	 */
	public void countingSort(int[] arr, int m, int n) {
		int[] count = new int[n-m+1];
		for(int i=0;i<arr.length;i++) {
			count[arr[i]-m]++;
		}
		
		for(int i=1;i<arr.length;i++) {
			count[i] = count[i]+count[i-1];
		}
		int[] output = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			output[count[arr[i]-m]-1] = arr[i];
			count[arr[i]-m]--;
		}
		for(int i=0;i<output.length;i++) {
			arr[i] = output[i];
		}
 		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Counting Sort Negative numbers
	 */
	public void countingSort_Nve(int[] arr, int m, int n) {
		int[] count  = new int[Math.abs(n)-Math.abs(m)+1];
		for(int i=0;i<arr.length;i++) {
			count[Math.abs(arr[i])-1]++;
		}
		
		for(int i=arr.length-2;i>=0;i--) {
			count[i] = count[i]+count[i+1];
		}
		int[] output = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			output[count[Math.abs(arr[i])-1]-1] = arr[i];
			count[Math.abs(arr[i])-1]--;
		}
		for(int i=0;i<output.length;i++) 
			arr[i]= output[i];
		
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Shell Sort 
	 */
	public void shellSort(int[] arr) {
		for(int gap = arr.length/2;gap>0; gap = gap/2) {
			for(int i=gap;i<arr.length;i++) {
				int tmp = arr[i];
				int j=i;
				for(j=i;j>=gap && arr[j-gap]>tmp;j=j-gap)
					arr[j] = arr[j-gap];
				arr[j] = tmp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public Link_Sort quickSort(Link_Sort head) {
		if(head==null || head.next==null) return head;
		Link_Sort partition = partition(head);
		Link_Sort before_par = getPartBefore(head,partition);
		Link_Sort left = null;
		Link_Sort right = null;
		if(partition!=head) {
			before_par.next = null;
			left = quickSort(head);
			Link_Sort last = getLast(left);
			last.next = partition;
		}
		right = partition.next;
		right = quickSort(right);
		return left==null?head:left;
	}
	
	private Link_Sort getPartBefore(Link_Sort head,Link_Sort par) {
		if(head==par) return null;
		while(head.next!=par) {
			head = head.next;
		}
		return head;
	}
	
	private Link_Sort partition(Link_Sort head) {
		Link_Sort last = getLast(head);
		Link_Sort start = head;
		Link_Sort inc = head;
		while(start!=last) {
			if(start.data<last.data) {
				swap(start,inc);
				inc = inc.next;
			}
			start = start.next;
		}
		swap(inc,last);
		return inc;
	}
	
	private Link_Sort getLast(Link_Sort head) {
		Link_Sort tmp = head;
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		return tmp;
	}
	private void swap(Link_Sort a, Link_Sort b) {
		int temp = a.data;
		a.data = b.data;
		b.data = temp;
	}
	
	public static void main(String args[]) {
		SearchAllInOne search = new SearchAllInOne();
		int[] arr = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
		int left = 0;
		int right = arr.length-1;
		int element = 10;
	//	System.out.println(search.binarySearch(arr, left, right, element));
	//	System.out.println(search.binarySearch_It(arr, element));
	//	search.selectionSort(arr);
	//	search.bubbleSort(arr);
	//  search.insertionSort(arr);
	//	search.countingSort_Nve(arr, -1, -10);
	//	search.shellSort(arr);
		Link_Sort head = new Link_Sort(5);
		head.next = new Link_Sort(20);
		head.next.next = new Link_Sort(4);
		head.next.next.next = new Link_Sort(3);
		head.next.next.next.next = new Link_Sort(30);
		
		Link_Sort result = search.quickSort(head);
		while(result!=null) {
			System.out.print(result.data+" ");
			result = result.next;
		}
	}
	
	
	public void fizzBizz(int n,int a, int b) {
		StringBuilder result=new StringBuilder();
		for(int i=1;i<=n;i++) {
			String word = toWord(a,i,"Fizz")+toWord(b,i,"Buzz");
			if(word.isEmpty()) {
				result.append(i+"-");
			}
			else {
				result.append(word+"-");
			}
		}
	}
	
	private String toWord(int a, int i, String word) {
		return a%i==0 ? word:"";
	}
}


class Link_Sort {
	public int data;
	public Link_Sort next;
	public Link_Sort(int val) {
		data = val;
	}
}