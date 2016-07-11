import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class ArraysAllInOne {

	/*
	 * Checks if there is a pair in the array with given sum without using extra space
	 */
	public boolean checkSumPair_NoSpace(int[] arr, int sum) {
		if(arr==null || arr.length==0) return false;
		Arrays.sort(arr);
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			if(arr[i]+arr[j]==sum) return true;
			if(arr[i]+arr[j]<sum) i++;
			else j--;
		}
		return false;
	}
	
	/*
	 * Checks if there is a pair in the array with the given sum
	 */
	public boolean checkSumPair(int[] arr, int sum) {
		Map<Integer,Integer> map  = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(sum-arr[i])) {
				return true;
			}
			map.put(arr[i], i);
		}
		return false;
	}
	
	/*
	 * Finding the majority element in the array
	 */
	public int majority(int[] arr) {
		if(arr==null || arr.length==0)
			return -1;
		int maj_index = arr[0];
		int count =1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[maj_index])
				count++;
			else if(arr[i]!=arr[maj_index])
				count--;
			if(count==0) {
				maj_index=i;
				count = 1;
			}
		}
		return arr[maj_index];
	}
	
	/*
	 * Find element repeating n times in a array with 2n elements and other n elements being different
	 */
	public int majority_second(int[] arr) {
		if(arr==null || arr.length==0) return -1;
		int maj_index = 0;
		int count = 1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[maj_index]) 
				return arr[i];
			else 
				count--;
			if(count==0) {
				maj_index = i;
				count = 1;
			}
		}
		return -1;
	}
	
	/*
	 * ELement occuring odd number of times
	 */
	public int oddOcc(int[] arr) {
		if(arr==null || arr.length==0)
			return -1;
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			sum = sum^arr[i];
		}
		return sum;
	}
	
	/*
	 * Maximum contiguous subarray 
	 */
	public int max_subArr_sum(int[] arr) {
		if(arr==null || arr.length==0) return 0;
		int cur_sum = arr[0];
		int max_sum = arr[0];
		for(int i=1;i<arr.length;i++) {
			cur_sum = Math.max(cur_sum+arr[i],arr[i]);
			max_sum = Math.max(max_sum, cur_sum);
		}
		return max_sum;
	}
	
	/*
	 * Maximum product subarray
	 */
	
	public int max_prodSubArray(int[] arr) {
		if(arr==null || arr.length==0) return 0;
		int min = arr[0];
		int max = arr[0];
		int global_max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<0) {
				swap(min,max);
			}
		max = Math.max(arr[i], max*arr[i]);
		min = Math.min(arr[i], min*arr[i]);
		global_max = Math.max(max, min);
		}
		return global_max;
	}
	
	private void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	/*
	 * Find element in a sorted pivoted array
	 */
	public int sorted_pivoted(int[] arr, int val,int left, int right) {
		if(arr==null || left>right) 
			return -1;
		while(left<=right) {
		int mid = left+(right-left)/2;
		if(arr[mid]==val) return mid;
		else if (arr[left]<arr[mid]) {
			if(arr[left]<=val && val<arr[mid])
				right = mid-1;
			else 
				left = mid+1;
		}
		else if(arr[right]>arr[mid]) {
			if(arr[mid]<val && val<=arr[right]) {
				left = mid+1;
			}
			else 
				right = mid-1;
		}
		}
		return -1;	
	}
	
	/*
	 * Find the median of two sorted arrays
	 */
	public int findMedian(int[] a, int[] b) {
		if(a==null&&b==null) return -1;
		int aLen = a.length;
		int bLen = b.length;
		if((aLen+bLen)%2==0) {
			return (findMedianUtils(a,b,(aLen+bLen)/2,0,aLen-1,0,bLen-1)+findMedianUtils(a,b,((aLen+bLen)/2)-1,0,aLen-1,0,bLen-1))/2;
		}
		else 
			return findMedianUtils(a,b,(aLen+bLen)/2,0,aLen-1,0,bLen-1);
	}
	
	private int findMedianUtils(int[] a, int[] b, int k, int aStart, int aEnd, int bStart, int bEnd) {
		int aLen = aEnd-aStart+1;
		int bLen = bEnd-bStart+1;
		if(aLen==0) return b[bStart+k];
		if(bLen==0) return a[aStart+k];
		if(k==0) return a[aStart]<b[bStart] ? a[aStart]:b[bStart];
		
		int aMid = (aLen*k)/(aLen+bLen);
		int bMid = k-aMid-1;
		
		aMid = aMid+aStart;
		bMid = bMid+bStart;
		
		if(a[aMid]<=b[bMid]) {
			k = k-(aMid-aStart+1);
			aStart=aMid+1;
			bEnd = bMid;
		}
		else {
			k= k-(bMid-bStart+1);
			bStart= bMid+1;
			aEnd = aMid; 
		}
		return findMedianUtils(a,b,k,aStart,aEnd,bStart,bEnd);
	}
	
	/*
	 * Reverse an array
	 */
	public void reverseArray(int[] arr) {
		if(arr==null || arr.length==0) 
			return ;
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			j--;
			i++;
		}
	}
	
	/*
	 * Rotate an array
	 */
	
	public void rotateArray(int[] arr, int d) {
		if(arr==null || arr.length==0 || d<=0)return;
		reverseArray(arr,0,d);
		reverseArray(arr,d,arr.length);
		reverseArray(arr,0,arr.length);
	}
	
	/*
	 * Reverse array 
	 */
	public void reverseArray(int[] arr, int i, int j){
		if(arr==null || arr.length==0)
			return;
		int low = i;
		int high = j-1;
		while(low<high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}
	
	/*
	 * Rotational Algorithm efficient
	 */
	public void rotational(int[] arr, int d) {
		if(arr==null || arr.length==0) 
			return;
		int gcd = getGCD(arr.length,d);
		for(int i=0;i<gcd;i++) {
			int temp = arr[i];
			int j= i;
			while(true) {
				int k = j+gcd;
				if(k>=arr.length);
				 k= k-arr.length;
				if(k==i)
					break;
				arr[j] = arr[k];
				j=k;
			}
		}
	}
	
	/*
	 * GCD
	 */
	public int getGCD(int a, int b) {
		if(b==0) return a;
		return getGCD(b,a%b);
	}
	
	/*
	 * Max such that no two elements are adjacent
	 */
	public int getMax(int[] arr) {
		if(arr==null || arr.length==0) return Integer.MIN_VALUE;
		int incl = arr[0];
		int exc = 0;
		for(int i=1;i<arr.length;i++) {
			int excl_new = Math.max(incl, exc);
			incl = exc+arr[i];
			exc = excl_new;
		}
		return Math.max(exc, incl);
				
	}
	
	/*
	 * Leaders Array
	 */
	public void leaders(int[] arr) {
		if(arr==null || arr.length==0) return;
		int max = Integer.MIN_VALUE;
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]>max) {
				System.out.print(arr[i]+" ");
				max = arr[i];
			}
		}
	}
	
	/*
	 * Count inversions in a array
	 */
	public void count_inversions(int[] arr) {
		if(arr==null || arr.length==0) return;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					System.out.print("Inversion pair ("+arr[i]+" "+arr[j]+") \n");
				}
			}
		}
 	}
	
	/*
	 * Count inversions optimized method
	 */
	public int opt_CountInv(int[] arr,int[]temp, int left, int right) {
		if(arr==null || arr.length==0 || left>=right) return 0;
		int inv_count=0;
		int mid = left+(right-left)/2;
		inv_count = opt_CountInv(arr,temp,left,mid);
		inv_count += opt_CountInv(arr,temp,mid+1,right);
		
		inv_count += merge(arr,temp,0,left,mid+1,right);
		return inv_count;
	}
	
	private int merge(int[] arr, int[] temp , int inv_count, int left, int mid, int right) {
		int i= left;
		int j = mid;
		int k = mid;
		while(i<mid && j<=right) {
			if(arr[i]<arr[j]) {
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
				inv_count = inv_count + (mid-i);
			}
		}
		while(i<mid) {
			temp[k++] = arr[i++];
		}
		while(j<=right) {
			temp[k++] = arr[j++];
		}
		for(i=left;i<=right;i++) {
			arr[i] = temp[i];
		}
		return inv_count;
	}
	
	/*
	 * Merge Sort
	 */
	public int[] mergeSort(int[] arr) {
		if(arr==null || arr.length<=1) return arr;
		int[] leftHalf = new int[arr.length/2];
		int[] rightHalf = new int[arr.length-arr.length/2];
		for(int i=0;i<arr.length/2;i++) {
			leftHalf[i] = arr[i];
		}
		for(int i=arr.length/2;i<arr.length;i++) {
			rightHalf[i-arr.length/2] = arr[i];
		}
		leftHalf = mergeSort(leftHalf);
		rightHalf= mergeSort(rightHalf);
		return merge(arr,leftHalf,rightHalf);
	}
	
	private int[] merge(int[] arr, int[] leftHalf,int[] rightHalf) {
		if(leftHalf==null) return rightHalf;
		if(rightHalf==null) return leftHalf;
		int i = 0;
		int j = 0;
		int k=0;
		while(i<leftHalf.length && j<rightHalf.length) {
			if(leftHalf[i]<rightHalf[j]) {
				arr[k++] = leftHalf[i++];
			}
			else {
				arr[k++] = rightHalf[j++];
			}
		}
		while(i<leftHalf.length) {
			arr[k++] = leftHalf[i++];
		}
		while(j<rightHalf.length) {
			arr[k++] = rightHalf[j++];
		}
		return arr;
	}
	
	/*
	 * Count_Inversions
	 */
	
	public int count_Inversion_second(int[] arr) {
		if(arr==null || arr.length<=1) return 0;
		int[] left = new int[arr.length/2];
		int[] right = new int[arr.length-arr.length/2];
		for(int i=0;i<arr.length/2;i++) {
			left[i] = arr[i];
		}
		for(int i=arr.length/2;i<arr.length;i++) {
			right[i-arr.length/2] = arr[i];
		}
		int inv_count =0;
		inv_count = count_Inversion_second(left);
		inv_count += count_Inversion_second(right);
		
		inv_count += merge_count(arr,left,right);
		return inv_count;
	}
	
	/*
	 * Elements with sum closest to zero
	 */
	public int sum_closestZero(int[] arr) {
		if(arr == null || arr.length<=1) return Integer.MAX_VALUE;
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length-1;
		int min = Integer.MAX_VALUE;
		while(i<j) {
			int sum = arr[i]+arr[j];
			if(Math.abs(sum)<Math.abs(min)) {
				min = sum;
			}
			if(sum<0) 
				i++;
			else if(sum>0)
				j--;
		}
		return min;
	}
	
	
	private int merge_count(int[] arr, int[] leftHalf,int[] rightHalf) {
		if(leftHalf==null) return 0;
		if(rightHalf==null) return 0;
		int i = 0;
		int j = 0;
		int k=0;
		int inv_count=0;
		while(i<leftHalf.length && j<rightHalf.length) {
			if(leftHalf[i]<rightHalf[j]) {
				arr[k++] = leftHalf[i++];
			}
			else {
				arr[k++] = rightHalf[j++];
				inv_count = inv_count + leftHalf.length-i;
			}
		}
		while(i<leftHalf.length) {
			arr[k++] = leftHalf[i++];
		}
		while(j<rightHalf.length) {
			arr[k++] = rightHalf[j++];
		}
		return inv_count;
	}
	
	/*
	 * Smallest and second smallest in the array
	 * 
	 */
	public void smallest(int[] arr) {
		if(arr==null || arr.length==0) return;
		if(arr.length==1) {
			System.out.println(" Only element in the array");
			return;
		}
		int min;
		int smin;
		if(arr[0]<arr[1]) {
			min = arr[0];
			smin = arr[1];
		}
		else {
			min = arr[1];
			smin=arr[0];
		}
		for(int i=2;i<arr.length;i++) {
			if(arr[i]<min) {
				smin = min;
				min = arr[i];
			}
			else if(arr[i]<smin && arr[i]!=min) {
				smin = arr[i];
			}
		}
		System.out.println("The smallest is "+min+" and second smallest is "+smin);
	}
	
	/*
	 * Check if given element is majority element in a sorted array
	 */
	public int checkMaj(int[] arr, int left, int right, int key) {
		if(arr==null || arr.length<=1) return -1;
		int leftVal = binarySearch(arr,left,right,key);
		if(leftVal==-1) {
		//	System.err.println("temp");
			return -1;
		}
		else if((leftVal+(arr.length/2))<arr.length && arr[leftVal+(arr.length/2)]==arr[leftVal])
			return arr[leftVal];
		return -1;
	}
	
	public int binarySearch(int[] arr, int left, int right, int key) {
		if(right<left) return -1;
		int mid = left+(right-left)/2;
		if((mid==0 || arr[mid-1]<arr[mid]) && arr[mid] == key )
			return mid;
		else if(key>arr[mid])
			return binarySearch(arr,mid+1,right,key);
		else 
			return binarySearch(arr,left,mid-1,key);
	}
	
	/*
	 * Maximum difference between two elements such that greater element is on the right side of smaller element in the array
	 */
	public int maxDiff(int[] arr) {
		if(arr==null || arr.length<=1) return -1;
		int min_element = arr[0];
		int max_diff = arr[1]-arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-min_element>max_diff) 
				max_diff = arr[i]-min_element;
			if(arr[i]<min_element) 
				min_element = arr[i];
		}
		return max_diff;
	} 
	
	/*
	 * Union and Intersection of sorted arrays 
	 */
	public int[] union_sorted(int[] arr1, int[] arr2) {
		if(arr1==null) return arr2;
		if(arr2==null) return arr1;
		int[] result = new int[arr1.length+arr2.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				result[k++] = arr1[i++];
			}
			else if(arr2[j]<arr1[i])
				result[k++] = arr2[j++];
			else {
				result[k++] = arr2[j++];i++;
			}
		}
		while(i<arr1.length) 
			result[k++] = arr1[i++];
		while(j<arr2.length)
			result[k++] = arr2[j++];
		return result;
	}
	
	/*
	 * intersection of two sorted arrays
	 */
	public int[] intersection(int[] arr1,int[] arr2) {
		if(arr1==null) return null;
		if(arr2==null) return null;
		int[] result = new int[arr1.length];
		int i=0;int j=0;int k=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) 
				i++;
			else if(arr1[i]>arr2[j])
				j++;
			else { 
				result[k++] = arr1[i++];j++; 
			}
		}
		return result;
	}
	
	/*
	 * Union of two sorted arrays
	 */
	public int[] union(int[] arr1, int[] arr2) {
		if(arr1==null) return arr2;
		if(arr2==null) return arr1;
		int[] result = new int[arr1.length+arr2.length];
		int k=0;
		for(int i=0;i<arr2.length;i++) {
			result[k++] = arr2[i];
		}
		
		for(int i=0;i<arr1.length;i++) {
			int res = binarySearch(arr2,0,arr2.length-1,arr1[i]);
			if(res==-1) {
				result[k++] = arr1[i];
			}
		}
		return result;
	}
	
	/*
	 * Intersection of two sorted arrays
	 */
	public int[] intersection_opt(int[] arr1, int[] arr2) {
		if(arr1==null) return null;
		if(arr2==null) return null;
		int length = 0;
		int[] smaller;
		if(arr1.length<arr2.length) {
			length= arr1.length;
			smaller = arr1;
		}
		else {
			length = arr2.length;
			smaller = arr2;
		}
		int[] result = new int[length];
		int k=0;
		for(int i=0;i<smaller.length;i++) {
			int res = binarySearch(arr2,0,arr2.length-1,arr1[i]);
			if(res!=-1) 
				result[k++] = arr1[i];
		}
		return result;
	}
	
	/*
	 * Floor and ceil of a given element in a array
	 */
	public int ceilInArr(int[] arr, int element, int left, int right) {
		if(element<=arr[left]) return left;
		if(element>arr[right]) return -1;
		int mid = left+(right-left)/2;
		if(arr[mid]==element) return mid;
		else if(element<arr[mid]) {
			if((mid-1>=left && element>=arr[mid-1]))
				return mid;
			else
				return ceilInArr(arr,element,left,mid-1);
		}
		else {
			if(mid+1<=right && element<arr[mid+1])
				return mid+1;
			else
				return ceilInArr(arr,element,mid+1,right);
		}
	}
	
	/*
	 * Floor of an element in an array
	 */
	public int floor(int[] arr, int element, int left, int right) {
		if(element>=arr[right]) return right;
		if(element<arr[left]) return -1;
		
		int mid = left+(right-left)/2;
		if(arr[mid]==element) 
			return mid;
		else if(element<arr[mid]) {
			if(mid-1>=left && element<=arr[mid-1]) 
				return mid-1;
			else
				return floor(arr,element,left,mid-1);
		}
		else {
			if(mid+1<=right && element<arr[mid+1]) 
				return mid;
			else
				return floor(arr,element,mid+1,right);
		}
	}
	
	/*
	 * Segregate 0,1,2 's in a array
	 */
	public void seg012(int[] arr) {
		if(arr==null || arr.length==0) return;
		int i=0;int j=0;int k=arr.length-1;
		while(j<=k) {
			if(arr[j]==0) {
				swap(arr,i++,j++);
			}
			else if(arr[j]==1) 
				j++;
			else 
				swap(arr,j,k--);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	/*
	 * Minimum length sub array sorting which makes the complete array sorted 
	 */
	public void sortArray(int[] arr) {
		if(arr==null || arr.length==0) return;
		
		int min;
		int max;
		int i=0;
		int j=arr.length-1;
		for(i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) 
				break;
		}
		min = i;
		for(j=arr.length-1;j>0;j--) {
			if(arr[j]<arr[j-1]) 
				break;
		}
		max = j;
		if(max<min) return;
		
		int inMin = arr[min];
		int inMax = arr[max];
		for(int k=min;k<=max;k++) {
			if(arr[k]<inMin)
				inMin = arr[k];
			if(arr[k]>inMax)
				inMax = arr[k];
		}
		int k = min;
		while(k>=0 && arr[k]>inMin) 
			k--;
		if(k>=-1) {
			min = k+1; 
		}
		k=max;
		while(k<=arr.length-1 && arr[k]<inMax )
			k++;
		if(k<=arr.length)
			max = k-1;
		System.out.println("The subarray that has to be sorted to make the complete array sorted is from index "+min+" to "+max);
	}
	
	/*
	 * Duplicates in a array in o(n) time
	 */
	public void duplicates(int[] arr) {
		if(arr==null || arr.length==0) return;
		for(int i=0;i<arr.length;i++) {
			if(arr[Math.abs(arr[i])]>0) 
				arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
			else
				System.out.print(arr[i]+" ");
		}
	}
	
	/*
	 * Equilibrium index in a array
	 */
	public void equil(int[] arr) {
		if(arr==null || arr.length==0) return;
		int left_sum = 0;
		for(int i=0;i<arr.length;i++) 
			left_sum += arr[i];
		
		int right_sum = 0;
		
		for(int i=arr.length-1;i>=0;i--) {
			left_sum = left_sum-arr[i];
			if(left_sum == right_sum) 
				System.out.println("Equil index "+i);
			right_sum = right_sum+arr[i];
		}
	}
	
	/*
	 * Rotate image by 90
	 */
	public void rotate(int[][] image) {
		if(image==null || image.length==0) return;
		
		for(int i=0;i<image.length;i++) {
			for(int j=0;j<image[i].length;j++) {
				System.out.print(image[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Modifying");
		for(int i=0;i<image.length/2;i++) {
			for(int j=i;j<image.length-1-i;j++) {
				int temp = image[j][image.length-1-i];
				image[j][image.length-1-i] = image[i][j];
				image[i][j] = image[image.length-1-j][i];
				image[image.length-1-j][i] = image[image.length-1-i][image.length-1-j];
				image[image.length-1-i][image.length-1-j] = temp;
			}
		}
		for(int i=0;i<image.length;i++) {
			for(int j=0;j<image[i].length;j++) {
				System.out.print(image[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	/*
	 * Check if array elements are consecutive 
	 */
	public boolean isCons(int[] arr) {
		if(arr==null || arr.length==0) return false;
		boolean[] visited = new boolean[arr.length];
		int max = getMaxInArr(arr);
		int min = getMin(arr);
		if(max-min+1==arr.length) {
			for(int i=0;i<arr.length;i++) {
				if(visited[arr[i]-min]!=false)
					return false;
				visited[arr[i]-min] = true;
			}	
			return true;
		}
		return false;
	}
	
	private int getMaxInArr(int[] arr) {
		if(arr==null || arr.length==0) return -1;
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) 
				max = arr[i];
		}
		return max;
	}
	
	private int getMin(int[] arr) {
		if(arr==null || arr.length==0) return -1;
		int min = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<min)
				min = arr[i];
		}
		return min;
	}
	
	public boolean isCons_second(int[] arr) {
		if(arr==null || arr.length==0) return false;
		int max = getMaxInArr(arr);
		int min = getMin(arr);
		if(max-min+1==arr.length) {
			for(int i=0;i<arr.length;i++) {
				if(arr[Math.abs(arr[i])-min]<0)
					return false;
				arr[Math.abs(arr[i])-min] = - arr[Math.abs(arr[i])-min];
			}
			return true;
		}
		return false;
	}
	
	/*
	 * Smallest missing number
	 */
	public int missing_search(int[] arr, int left, int right) {
		if(left>right) return right+1;
		if(arr[left]!=left) return left;
		int mid = (left+right)/2;
		if(arr[mid]>mid) 
			return missing_search(arr,left,mid-1);
		else
			return missing_search(arr,mid+1,right);
	}
	
	/*
	 * Get max diff j-i such that arr[j]>arr[i] 
	 */
	public int getMaxDiffij(int[] arr) {
		if(arr==null || arr.length==0) 
			return -1;
		int[] leftMin = new int[arr.length];
		int[] rightMax = new int[arr.length];
		leftMin[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			leftMin[i] = Math.min(arr[i], leftMin[i-1]);
		}
		
		rightMax[arr.length-1] = arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--) {
			rightMax[i] = Math.max(arr[i], rightMax[i+1]);
		}
		
		int i= 0;
		int j=0;
		int maxDiff = Integer.MIN_VALUE;
		while(i<=j) {
			if(leftMin[i]<rightMax[j]) {
				maxDiff = Math.max(maxDiff, j-i);
				j++;
			}
			else i++;
		}
		return maxDiff;
	}
	
	/*
	 * Minimum distance between two numbers
	 */
	public int minDist(int[] arr, int a, int b) {
		if(arr==null || arr.length==0) return -1;
		int prev = -1;
		int i;
		for(i=0;i<arr.length;i++) {
			if(arr[i]==a || arr[i]==b) {
				prev = i;
				break;
			}
		}
		if(prev==-1) return -1;
		int minDiff = Integer.MAX_VALUE;
		for(;i<arr.length;i++) {
			if(arr[i]==a || arr[i]==b) {
				if(arr[prev]!=arr[i] && i-prev<minDiff) {
					minDiff = i-prev;
					prev = i;
				}
				else 
					prev = i;
			}
		}
		
		return minDiff;
	}
	
	/*
	 * Fixed point in a array
	 */
	public int fixedPoint(int[] arr, int left, int right) {
		if(left>right) return -1;
		int mid = left+(right-left)/2;
		if(arr[mid]==mid) return mid;
		else if(arr[mid]>mid) return fixedPoint(arr,left,mid-1);
		else return fixedPoint(arr,mid+1,right);
	}
	 
	/*
	 * Maximum biotonic subarray
	 */
	public int biotonic(int[] arr) {
		if(arr==null || arr.length==0) return -1;
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		left[0] = 1;
		right[arr.length-1] = 1;
		for(int i=1;i<arr.length;i++) {
			left[i] = arr[i]>arr[i-1] ? left[i-1]+1 : 1;
		}
		for(int i=arr.length-2;i>=0;i--) {
			right[i] = arr[i]>arr[i+1] ? right[i+1]+1 : 1;
		}
		
		int max = 0;
		for(int i=0;i<arr.length;i++) {
			if(left[i]+right[i]-1>max) 
				max = left[i]+right[i]-1;
		}
		return max;
	}
	
	public int incDec(int[] arr, int left, int right) {
		if(right==left) return arr[left];
		if(right-left==1) return arr[left]>arr[right] ? arr[left] : arr[right] ;
		int mid = left+ (right-left)/2;
		if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1])
			return arr[mid];
		else if(arr[mid]<arr[mid+1]) 
			return incDec(arr,mid+1,right);
		else 
			return incDec(arr,left,mid-1);
	}
	
	/*
	 * Minimum number of jumps required to reach the end of the array
	 */
	public int minJumps(int[] arr, int left, int right) {
		if(left==right) return 0;
		if(arr[left]==0) return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=left+1;i<=right && i<=left+arr[left];i++) {
			int jumps = minJumps(arr,i,right);
			if(jumps!=Integer.MAX_VALUE && jumps+1<min)
				min = jumps+1;
		}
		return min;
	}
	
	/*
	 * Minimum number of jumps required to reach the end of the array- dynamic programming
	 */
	public int minJumps_DP(int[] arr) {
		if(arr.length==1) return 0;
		if(arr[0]==0) return Integer.MAX_VALUE;
		int[] jumps = new int[arr.length];
		jumps[0] = 0;
		for(int i=1;i<arr.length;i++) {
			jumps[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE) { 
					jumps[i] = Math.min(jumps[i],jumps[j]+1);
					break;
				}
			}
		}
		return jumps[arr.length-1];
	}
	
	/*
	 * SubArray with given sum
	 */
	public void subArray(int[] arr,int sum) {
		if(arr==null || arr.length==0) return;
		int cur_sum = arr[0];
		int start = 0;
		for(int i=1;i<=arr.length;i++) {
			while(cur_sum>sum && start<i-1) {
				cur_sum = cur_sum - arr[start];
				start++;
			}
			if(cur_sum==sum) {
				System.out.println("Sum found between indexes "+start+" and "+(i-1));
				return;
			}
			if(i<arr.length) {
				cur_sum = cur_sum+arr[i];
			}
		}
		System.out.println("not found");
	}
	/*
	 * Finding the smallest missing positive number in a unsorted array
	 */
	public int findSmallestPos(int[] arr) {
		if(arr==null || arr.length==0) return -1;
		int start = segPosNeg(arr);
		int[] newArr = Arrays.copyOfRange(arr, start, arr.length);
		return findSmallest(newArr);
	}
	
	private int findSmallest(int[] arr) {
		int size = arr.length;
		for(int i=0;i<size;i++) {
			if(Math.abs(arr[i])-1<size && arr[Math.abs(arr[i])-1]>0)
				arr[Math.abs(arr[i])-1] = - arr[Math.abs(arr[i])-1];
		}
		for(int i=0;i<size;i++) {
			if(arr[i]>0) return i+1;
		}
		return size+1;
	}
	
	private int segPosNeg(int[] arr) {
		int i=0;
		int j=arr.length-1;
		while(i<=j) {
			while(i<=j && arr[i]<0)
				i++;
			while(i<=j && arr[j]>0)
				j--;
			if(i<=j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j]  = temp;
				i++;
				j--;
			}
		}
		return i;
	}
	
	/*
	 * Sorted Subsequence of size 3 in linear time
	 */
	public void sortedSub(int[] arr) {
		if(arr==null || arr.length==0) return;
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		left[0] = -1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1]<arr[i] || (left[i-1]<arr[i] && left[i-1]!=-1)) {
				left[i] = Math.min(arr[i-1],left[i-1]==-1?Integer.MAX_VALUE:left[i-1]);
			}
			else
				left[i] = -1;
		}
		
		right[arr.length-1] = -1;
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i+1]>arr[i] || right[i+1]>arr[i]) {
				right[i] = Math.max(right[i+1],arr[i+1]);
			}
			else
				right[i] = -1;
		}
		
		for(int i=1;i<arr.length-1;i++) {
			if(left[i]!=-1 && left[i]<arr[i] && right[i]>arr[i]) {
				System.out.println("The sorted subsequence is "+left[i]+","+arr[i]+","+right[i]);
				return;
			}
		}
	}
	
	/*
	 * Maximum sub array with equal 0's and 1's
	 */
	public void subArr(int[] arr) {
		if(arr==null || arr.length==0) return;
		int maxSize = Integer.MIN_VALUE;
		int start=0;
		for(int i=0;i<arr.length-1;i++) {
			int sum = arr[i]==0 ? -1: 1;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]==0) {
					sum=sum-1;
				}
				else {
					sum=sum+1;
				}
				if(sum==0 && j-i+1>maxSize) { 
					maxSize = j-i+1;
					start=i;
				}
			}
		}
		if(maxSize!=Integer.MIN_VALUE)
			System.out.println("The subarray is from "+start+" to "+(start+maxSize-1));
		else
			System.out.println("no subarray found");
		
	}
	
	/*
	 * Largest subarray with equal 0's and 1's
	 * Two methods
	 * First method: brute force
	 * second method: opt method
	 */
	public void subArr01(int[] arr) {
		if(arr==null || arr.length==0) return;
		int maxSize = -1;
		int startIndex = 0;
		for(int i=0;i<arr.length-1;i++) {
			int sum = arr[i]==0 ? -1 : 1;
			for(int j=i+1;j<arr.length;j++) {
				sum = arr[j]==0? sum-1 : sum+1;
				if(sum==0 && j-i+1>maxSize) {
					maxSize = j-i+1;
					startIndex = i;
				}
			}
		}
		if(maxSize!=-1) {
			System.out.println("The subarray is found between "+startIndex+" and "+(startIndex+maxSize-1));
		}
		else {
			System.out.println("Not found");
		}
	}
	
	/*
	 * Opt method for subarray with 0's and 1's
	 */
	public void opt_subArr01(int[] arr) {
		if(arr==null || arr.length==0) return;
		int[] sumleft = new int[arr.length];
		int maxSize = -1;
		int startIndex= 0;
		int min = arr[0];
		int max = arr[0];
		sumleft[0] = arr[0]==0?-1:1;
		for(int i=1;i<arr.length;i++) {
			sumleft[i] = sumleft[i-1]+(arr[i]==0?-1:1);
			if(sumleft[i]<min) 
				min = sumleft[i];
			if(sumleft[i]>max)
				max = sumleft[i];
		}
		int[] hash = new int[max-min+1];
		for(int i=0;i<max-min+1;i++)
			hash[i]=-1;
		for(int i=0;i<arr.length;i++) {
			if(sumleft[i]==0) {
				maxSize = i+1;
				startIndex = 0;
			}
			else {
				if(hash[sumleft[i]-min]==-1) 
					hash[sumleft[i]-min] = i;
				else {
					if(maxSize<i-hash[sumleft[i]-min]) {
						maxSize = i-hash[sumleft[i]-min];
						startIndex = hash[sumleft[i]-min]+1;
					}
				}
			}
		}
		if(maxSize==-1) {
			System.out.println("not found");
		}
		else {
			System.out.println("found "+startIndex+" and "+(startIndex+maxSize-1));
		}
	}
	
	/*
	 * Maximum Product subArray
	 */
	public int maxProdArr(int[] arr) {
		if(arr==null || arr.length==0) return 0;
		int max= arr[0];
		int min = arr[0];
		int total_max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<0) {
				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(max*arr[i], arr[i]);
			min = Math.min(min*arr[i], arr[i]);
			total_max = Math.max(total_max, max);
		}
		return total_max;
	}
	
	/*
	 * FInd a pair with given difference in an array
	 */
	public boolean findPairEqDiff(int[] arr, int diff) {
		if(arr==null || arr.length==0) return false;
		Arrays.sort(arr);
		int i= 0;
		int j=arr.length-1;
		while(i<j) {
			int dif = arr[j]-arr[i];
			if(dif==diff) {
				System.out.println("The pair is "+arr[i]+" and "+arr[j]);
				return true;
			}
			else if(dif>diff) {
				j--;
			}
			else
				i++;
		}
		System.out.println("No pair found");
		return false;
	}
	
	/*
	 * Replace every element with its next greatest
	 */
	public void replaceNextGreater(int[] arr) {
		if(arr==null || arr.length==0) return;
		int max_right = arr[arr.length-1];
		arr[arr.length-1] = -1;
		for(int i=arr.length-2;i>=0;i--) {
			int old_val = arr[i];
			arr[i] = max_right;
			if(old_val>max_right)
				max_right = old_val;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Find four elements that sum to a given value
	 */
	public void fourPair(int[] arr, int sum) {
		if(arr==null || arr.length==0) return;
		int n = (arr.length*(arr.length-1))/2;
		Sum_Pair[] sumPair = new Sum_Pair[n];
		int k=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				sumPair[k].sum = arr[i]+arr[j];
				sumPair[k].first= i;
				sumPair[k].sec = j;
				k++;
			}
		}
		Arrays.sort(sumPair);
		int i=0;
		int j=n-1;
		while(i<j) {
			int total_sum = sumPair[i].sum+sumPair[j].sum;
			if(total_sum==sum && noCommon(sumPair[i],sumPair[j])) {
				System.out.println("The pairs are "+arr[sumPair[i].first]+" "+arr[sumPair[i].sec]+" "+arr[sumPair[j].first]+" "+arr[sumPair[j].sec]);
				return;
			}
			else if(total_sum>sum) {
				j--;
			}
			else
				i++;
		}
	}
	
	private boolean noCommon(Sum_Pair sum1, Sum_Pair sum2) {
		if(sum1.first==sum2.first || sum1.first==sum2.sec || sum1.sec==sum2.first || sum1.sec == sum2.sec) 
			return false;
		return true;
	}
	
	/*
	 * Sort a nearly sorted or k sorted array
	 */
	public void sortNearly(int[] arr) {
		
	}

	/*
	 * Maximum consecutive circular sum
	 */
	public int max_Cons_wrap(int[] arr) {
		if(arr==null || arr.length==0) return 0;
		int max_kadane = max_subArr_sum(arr);
		int max_wrap_sum = 0;
		for(int i=0;i<arr.length;i++) {
			max_wrap_sum +=arr[i];
			arr[i] = -arr[i];
		}
		
		max_wrap_sum  = max_wrap_sum+max_subArr_sum(arr);
		return max_wrap_sum>max_kadane ? max_wrap_sum:max_kadane;
	}
	
	/*
	 * Rows with maximum number of 1's
	 */
	public void findMax1s(int[][] arr) {
		int j=arr[0].length-1;
		int maxSize = -1;
		int index = -1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i][j]==1) {
				while(j>=0 && arr[i][j]==1)
					j--;
				if(j<0) {
					System.out.println("Index is "+i+" with all columns as 1");
					return;
				}
				if(arr.length-1-j>maxSize)  {
					maxSize = arr.length-1-j;
					index = i;
				}
			}
		} 
		if(maxSize!=-1) {
			System.out.println("THe index is "+index+" with columns "+maxSize);
		}
	}
	
	/*
	 * Median of two sorted arrays of different lengths
	 */
	public int findMedianUnEqual(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		if((n+m)%2==0) {
			return (findMedianUnEqualUtils(arr1,arr2,(m+n)/2,0,n-1,0,m-1)+findMedianUnEqualUtils(arr1,arr2,(m+n)/2-1,0,n-1,0,m-1))/2;
		}
		else
			return findMedianUnEqualUtils(arr1,arr2,(m+n)/2,0,n-1,0,m-1);
	}
	
	private int findMedianUnEqualUtils(int[] arr1, int[] arr2, int k, int aStart, int aEnd, int bStart, int bEnd) {
		int aLen = aEnd-aStart+1;
		int bLen = bEnd-bStart+1;
		if(aLen==0) return arr2[bStart+k];
		if(bLen==0) return arr1[aStart+k];
		if(k==0) return arr1[aStart]<arr2[bStart] ? arr1[aStart] : arr2[bStart];
		int aMid = aLen/2;
		int bMid = bLen/2;
	//	int aMid = (aLen*k)/(aLen+bLen);
	//	int bMid = k-aMid-1;
		aMid = aMid+aStart;
		bMid = bMid+bStart;
		if(arr1[aMid]<arr2[bMid]) {
			k = k-(aMid-aStart+1);
			aStart = aMid+1;
			bEnd = bMid;
		}
		else {
			k = k-(bMid-bStart+1);
			bStart = bMid+1;
			aEnd = aMid;
		}
		return findMedianUnEqualUtils(arr1,arr2,k,aStart,aEnd,bStart,bEnd);
	}
	
	/*
	 * Shuffle a deck of cards or Randomize an array
	 */
	public void shuffle(int[] arr) {
		if(arr==null || arr.length==0) return;
		Random rand = new Random();
		
		for(int i=arr.length-1;i>=0;i--) {
			int j = (int)Math.random()*i+1;
			swap(arr,i,j);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Count the number of triangles
	 */
	public int triangles(int[] arr) {
		if(arr==null || arr.length==0) return 0;
		Arrays.sort(arr);
		int count=0;
		for(int i=0;i<arr.length-2;i++) {
			for(int j=i+1;j<arr.length-1;j++) {
				for(int k=j+1;k<arr.length;k++) {
					if(arr[i]+arr[j]>arr[k]) 
						count++;
				}
			}
		}
		return count;
	}
	
	/*
	 * Count number of triangles
	 */
	public int triangles_second(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		for(int i=0;i<arr.length-2;i++) {
			int k= i+2;
			for(int j=i+1;j<arr.length-1;j++) {
				while(k<arr.length && arr[i]+arr[j]>arr[k])
					k++;
				count = count+(k-j-1);
			}
		}
		return count;
	}
	
	/*
	 * Iterative Quick Sort
	 */
	public void iterate(int[] arr) {
		if(arr==null || arr.length==0)
			return;
		int left = 0;
		int right = arr.length-1;
		Stack<Integer> s = new Stack<Integer>();
		s.push(right);
		s.push(left);
		while(!s.isEmpty()) {
			left = s.pop();
			right = s.pop();
			if(right-left>0) {
				int mid = partition(arr,left,right);
				
				s.push(right);
				s.push(mid+1);
	
				s.push(mid-1);
				s.push(left);
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Find number of islands 
	 */
	public int numberOfislands(int[][] arr) {
		if(arr==null || arr.length==0) return 0;
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==1 && visited[i][j]==false) {
					dcf(arr,i,j,visited);
					count++;
				}
			}
		}
		return count;
	}
	
	private boolean isSafe(int[][] arr, int i, int j, boolean[][] visited) {
		if(i>=0 && i<arr.length && j>=0 && j<arr[0].length && arr[i][j]==1 && visited[i][j]==false) 
			return true;
		return false;
	}
	private void dcf(int[][] arr, int i, int j, boolean[][] visited) {
		int[] neighbourRows = {-1,-1,-1,0,0,1,1,1};
		int[] neighbourCols = {-1,0,1,-1,1,-1,0,1};
		visited[i][j] = true;
		for(int k=0;k<8;k++) {
			if(isSafe(arr,i+neighbourRows[k],j+neighbourCols[k],visited)) {
				dcf(arr,i+neighbourRows[k],j+neighbourCols[k],visited);
			}
		}
	}
	
	
	/*
	 * partition method of quick sort algorithm
	 */
	public int partition(int[] arr,int left, int right) {
		int i=left,j=left;
		int last = right;
		
		for(j=left;j<last;j++) {
			if(arr[j]<arr[last]) {
				swap(arr,i,j);
				i++;
			}
		}
		swap(arr,i,last);
		return i;
	}
	
	/*
	 * First Circular tour that visits all the petrol bunks
	 */
	public void cirCularTour(Petrol_Node[] arr) {
		if(arr==null || arr.length==0) return;
		int start= 0;
		int end = 1;
		int sum = arr[start].dist-arr[start].pet;
		while(start!=end || sum<0) {
			
			while(start!=end && sum<0) {
				sum = sum-(arr[start].dist-arr[start].pet);
				start = (start+1)%arr.length;
				if(start==0) { 
					System.out.println("No Tour found");
					return;
				}
			}
			
			sum = sum+arr[end].dist - arr[end].pet;
			end = (end+1)%arr.length;
		}
		System.out.println("Circular tour found from "+start);
	}
	
	/*
	 * Sorting 
	 */
	public void getLargestNumber(String[] arr) {
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String a , String b) {
				StringBuilder aa = new StringBuilder(a);
				StringBuilder bb = new StringBuilder(b);
				StringBuilder ab = aa.append(bb);
				StringBuilder ba = bb.append(aa);
				return ab.toString().compareTo(ba.toString())>0 ? -1: ab.toString().compareTo(ba.toString())<0 ? 1:0 ;
			}
		}
		);
		
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 *  Pancake Sorting
	 */
	public void panCake(int[] arr) {
		int cur_size = arr.length-1;
		for(cur_size=arr.length-1;cur_size>0;cur_size--) {
			int max = findMax(arr,0,cur_size);
			reverseArray(arr,0,max+1);
			reverseArray(arr,0,cur_size+1);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private int findMax(int[] arr, int start, int end) {
		int max= start;
		for(int i=start+1;i<=end;i++) {
			if(arr[i]>arr[max])
				max = i;
		}
		return max;
	}
	
	/*
	 * Pancake sorting using insertion sort
	 */
	public void pankCake_insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int ceil = ceilInArr(arr,arr[i],0,i-1);
			if(ceil!=-1) {
				reverseArray(arr,0,ceil);
				reverseArray(arr,0,i);
				reverseArray(arr,0,i+1);
				reverseArray(arr,0,ceil+1);
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Tug of war
	 */
	public void tugOfWar(int[] arr){
		if(arr==null || arr.length==0) return;
		boolean[] cur_elements = new boolean[arr.length];
		boolean[] soln = new boolean[arr.length];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum = sum+arr[i];
		}
		Wrapper_MinSum min = new Wrapper_MinSum();
		tugOfWarUtils(arr,arr.length,cur_elements,soln,0,min,0,0,sum);
		System.out.println("First set");
		for(int i=0;i<arr.length;i++) {
			if(soln[i]==true) 
				System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("Second set");
		for(int i=0;i<arr.length;i++) {
			if(soln[i]==false)
				System.out.print(arr[i]+" ");
		}
	}
	
	private void tugOfWarUtils(int[] arr, int n, boolean[] cur_elements, boolean[] soln, int cur_sum, Wrapper_MinSum min, int noOfSelected, int cur_position,int total) {
		if(cur_position>=n) return;
		if(((n/2)-noOfSelected)>n-cur_position) return;
		
		tugOfWarUtils(arr,n,cur_elements,soln,cur_sum,min,noOfSelected,cur_position+1,total);
		
		noOfSelected++;
		cur_sum = cur_sum+arr[cur_position];
		cur_elements[cur_position] = true;
		
		if(noOfSelected==n/2) {
			if(Math.abs(total/2-cur_sum)<min.sum) {
				min.sum = Math.abs(total/2-cur_sum);
				for(int i=0;i<n;i++) 
					soln[i] = cur_elements[i];
			}
		}
		else {
			tugOfWarUtils(arr,n,cur_elements,soln,cur_sum,min,noOfSelected,cur_position+1,total);
		}
		cur_elements[cur_position] = false;
	}
	
	/*
	 * Divide and Conquer - Maximum contigous subarray
	 */
	public int maxSubArr_DC(int[] arr, int l, int h) {
		if(l>h) return 0;
		if(l==h) return arr[l];
		int mid = l + (h-l)/2;
		return Math.max(maxSubArr_DC(arr,l,mid-1), Math.max(maxSubArr_DC(arr,mid+1,h),maxCrossSum(arr,l,mid,h)));
	}
	
	private int maxCrossSum(int[] arr, int l, int m, int h) {
		int left_sum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=m;i>=l;i--) {
			sum = sum+arr[i];
			if(sum>left_sum) 
				left_sum = sum;
		}
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for(int i=m+1;i<=h;i++) {
			sum = sum+arr[i];
			if(sum>right_sum) 
				right_sum = sum;
		}
		return right_sum+left_sum;
	}
	
	/*
	 * Merge Overlappig intervals
	 */
	public void mergeOverlapping(Petrol_Node[] arr) {
		if(arr==null || arr.length==0) return;
		Arrays.sort(arr,new Comparator<Petrol_Node>() {

			@Override
			public int compare(Petrol_Node arg0, Petrol_Node arg1) {
				// TODO Auto-generated method stub
				return arg0.pet>arg1.pet ? 1: arg0.pet<arg1.pet? -1 :0;
			}
			
		});
		Stack<Petrol_Node> s = new Stack<Petrol_Node>();
		int i=0;
		s.push(arr[i++]);
		while(i<arr.length && !s.isEmpty())  {
			Petrol_Node top = s.peek();
			if(top.dist<arr[i].pet) {
				s.push(arr[i]);
			}
			else if(top.dist<arr[i].dist) {
				top.dist = arr[i].dist;
				s.pop();
				s.push(top);
			}
			i++;
		}
		while(!s.isEmpty()) {
			Petrol_Node result = s.pop();
			System.out.println("Distinct intervals "+result.pet+" "+result.dist);
		}
	}
	
	/*
	 * Maximum repeating element in a array
	 * 
	 * Input: Values from 0 to k-1, total size is n
	 */
	public void maxRepeat(int[] arr, int k) {
		for(int i=0;i<arr.length;i++) {
			arr[arr[i]%k] = arr[arr[i]%k]+k;
		}
		getMaxInArr(arr,k);
		
	}
	
	private void getMaxInArr(int[] arr, int k) {
		int maxK=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]/k>maxK)
				maxK = arr[i]/k;
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]/k==maxK) 
				System.out.print("the number is "+i);
		}
	}
 	
	/*
	 * Sort by frequency
	 */
	public void sortByFreq(int[] arr) {
		if(arr==null || arr.length==0) return;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				int val = map.get(arr[i]);
				map.put(arr[i], val+1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		Map<Integer,Integer> resultMap = sortHashMap(map);
		Iterator<Integer> iterator = resultMap.keySet().iterator();
		int i = 0;
		while(iterator.hasNext()) {
			int k = iterator.next();
			int val = resultMap.get(k);
			while(val>0 && i<arr.length) { 
				arr[i++] = k;
				val--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private Map<Integer,Integer> sortHashMap( Map<Integer,Integer> map) {
		List<Integer> values = new ArrayList<Integer>(map.values());
		Collections.sort(values, new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0>arg1 ? -1: arg0<arg1 ? 1:0;
			}
			
		});
		Map<Integer,Integer> sortedMap = new LinkedHashMap<Integer,Integer>();
		Iterator<Integer> iterator = values.iterator();
		while(iterator.hasNext()) {
			int val = iterator.next();
			Iterator<Integer> keyIterator = map.keySet().iterator();
			while(keyIterator.hasNext()) {
				int key = keyIterator.next();
				int inner_val = map.get(key);
				if(val==inner_val) {
					sortedMap.put(key, val);
					map.remove(key);
					break;
				}
			}
		}
		return sortedMap;
	}
	
	/*
	 * Find peak in an array
	 */
	public int findPeak(int[] arr, int l , int h) {
		int mid = l+(h-l)/2;
		if((mid==0 || arr[mid-1]<=arr[mid]) && (mid==arr.length-1 || arr[mid+1]<=arr[mid]))
			return mid;
		else if(mid>0 && arr[mid-1]>arr[mid]) 
			return findPeak(arr,l,mid-1);
		else
			return findPeak(arr,mid+1,h);
	}
	
	/*
	 * Combinations of r elements among n elements
	 */
	public void combinations(int[] arr, int n, int r) {
		int[] data = new int[r];
		combinationsUtils(arr,n,r,0,0,data);
	}
	
	private void combinationsUtils(int[] arr, int n, int r, int i, int index, int[] data) {
		if(index==r) {
			System.out.println(Arrays.toString(data));
			return;
		}
		if(i>n)
			return;
		data[index] = arr[i];
		combinationsUtils(arr,n,r,i+1,index+1,data);
		
		while(i<n && arr[i]==arr[i+1])
			i++;
		combinationsUtils(arr,n,r,i+1,index,data);
	}
	
	/*
	 * Find elements appearing more than k times 
	 */
	public void findKOccElements(int[] arr,int k) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				int val = map.get(arr[i]);
				map.put(arr[i], val+1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		
		Iterator<Integer> iterator = map.keySet().iterator();
		
		while(iterator.hasNext()) {
			int key = iterator.next();
			if(map.get(key)>(arr.length/k)) {
				System.out.println(key);
			}
		}
	}
	
	public void findKOcc(int[] arr, int k) {
		if(k<2) return;
		NKNode[] temp = new NKNode[k-1];
		for(int i=0;i<temp.length;i++) {
			temp[i] = new NKNode();
		}
		for(int i=0;i<arr.length;i++) {
			int j;
			for(j=0;j<k-1;j++) {
				if(arr[i]==temp[j].element) {
					temp[j].count++;
					break;
				}
			}
			if(j==k-1) {
				
				for(j=0;j<k-1;j++) {
					if(temp[j].count==0) {
						temp[j].element= arr[i];
						temp[j].count = 1;
						break;
					}
				}
				if(j==k-1) {
					for(j=0;j<k-1;j++) {
						temp[j].count--;
					}
				}
			}
		}
		for(int i=0;i<k-1;i++) {
			int count=0;
			for(int j=0;j<arr.length;j++) {
				if(temp[i].element==arr[j])
					count++;
			}
			if(count>arr.length/k) {
				System.out.println(temp[i].element);
			}
		}
	}
	
	private int f(int i) {
		return i*i-10*i-20;
	}
	/*
	 * Find point where a monotonically increasing function becomes positive for the first time
	 */
	public int findPositiveVal() {
		if(f(0)>0)
			return 0;
		int i=1;
		while(f(i)<=0)
			i=i*2;
		return binarySearch(i/2,i);
	}
	
	private int binarySearch(int low, int high) {
		if(f(low)>0)
			return low;
		int mid = (high+low)/2;
		if(f(mid)>0) {
			if(f(mid-1)<=0)
				return mid;
			else 
				return binarySearch(low,mid-1);
		}
		else {
			if(f(mid+1)>0) 
				return mid+1;
			else
				return binarySearch(mid+1,high);
		}
	}
	
	/*
	 * Increasing subsequence of length 3
	 */
	public void increasingSubSeq(int[] arr) {
		if(arr==null || arr.length<3) return;
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		
		left[0] = 0;
		right[arr.length-1]=0;
		for(int i=0;i<arr.length;i++) {
			int leftMax = 0;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && arr[j]>leftMax) 
					leftMax = arr[j];
			}
			left[i] = leftMax;
			int rightMax = 0;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]>arr[i] && arr[j]>rightMax) 
					rightMax = arr[j];
			}
			right[i]=rightMax;
		}
		int max=0;
		int maxIndex = -1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]*left[i]*right[i]>max) {
				maxIndex = i;
				max = arr[i]*left[i]*right[i];
			}
		}
		System.out.println("The max subseq is "+left[maxIndex]+" "+arr[maxIndex]+" "+right[maxIndex]);
	}
	
	/*
	 * Number of pairs with x^y>y^x where x is element in X[] and y is element in Y[]
	 */
	public int numOfPairsXY(int[] x,int[] y){
		if(x==null || x.length==0) return 0;
		int noOfPairs = 0;
		int[] NoY = new int[5];
		for(int i=0;i<x.length;i++) {
			if(x[i]<5) 
				NoY[x[i]]++;
		}
		Arrays.sort(y);
		for(int i=0;i<x.length;i++) {
			int val = numOfPairsXYUtils(x[i],y,NoY);
			System.out.println(val);
			noOfPairs = noOfPairs + val;
		}
		return noOfPairs;
	}
	
	private int numOfPairsXYUtils(int x, int[] Y, int[] NoY) {
		if(x==0)
			return 0;
		if(x==1)
			return NoY[0];
		int idx = findPairsUtils(Y,0,Y.length-1,x);
		int total = 0;
		if(idx!=-1)
			total = Y.length-idx;
		total = total + NoY[0]+NoY[1];
		if(x==2) 
			total = total - NoY[3] - NoY[4];
		if(x==3)
			total = total + NoY[2];
		return total;
	}
	
	private int findPairsUtils(int[] arr, int l, int h, int val) {
		if(val<arr[l]) return l;
		if(val>arr[h]) return -1;
		int m = l +(h-l)/2;
		if(val>arr[m]) {
			if(val<arr[m+1])
				return m+1;
			else
				return findPairsUtils(arr,m+1,h,val);
		}
		else if(val<arr[m]){
			if(val>arr[m-1])
				return m;
			else
				return findPairsUtils(arr,l,m-1,val);
		}
		else
			return findPairsUtils(arr,m+1,h,val);
	}
	
	/*
	 * count all distinct pairs with difference equal to a given number
	 */
	public int countDiffPairs(int[] arr, int k) {
		int count =0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]-arr[j] == k || arr[j]-arr[i]==k)
					count++;
			}
		}
		return count;
	}
	
	public int hashCountDiffPairs(int[] arr, int k) {
		int count = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], i);
		}
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i]-k))
				count++;
			if(map.containsKey(arr[i]+k))
				count++;
			map.remove(arr[i]);
		}
		return count;
	}
	
	/*
	 * Find a subarray with sum 0
	 */
	public void subArraySumZero(int[] arr) {
		if(arr==null || arr.length==0) return;
		int cur_sum = arr[0];
		int start = 0;
		for(int i=1;i<=arr.length;i++) {
			while(cur_sum>0 && start<i-1) {
				cur_sum = cur_sum - arr[start];
				start++;
			}
			if(cur_sum==0) {
				System.out.println("The subarray with sum zero is "+start+" ,"+(i-1));
				return;
			}
			if(i<arr.length) {
				cur_sum = cur_sum + arr[i];
			}
		}
	}

	/*
	 * SubArray with given sum and minimal length
	 */
	public void subArrMinLen(int[] arr, int sum) {
		if(arr==null || arr.length==0) return ;
		int cur_sum = arr[0];
		int start = 0;
		int maxSize = Integer.MAX_VALUE;
		for(int i=1;i<=arr.length;i++) {
			while(cur_sum>sum && start<i) {
				if(i-start<maxSize)
					maxSize = i-start;
				cur_sum = cur_sum - arr[start];
				start++;
			}
			if(i<arr.length)
				cur_sum = cur_sum + arr[i];
		}
		System.out.println("The minimal length subarray is "+maxSize);
	}
	
	/*
	 * Sort Array according to order defined in another array
	 */
	public void sortAnotherArray(int[] arr, int[] arr2) {
		if(arr==null || arr2==null || arr.length==0 || arr2.length==0) return;
		int[] copy = new int[arr.length];
		boolean[] visited = new boolean[arr.length];
		for(int i=0;i<arr.length;i++) {
			copy[i] = arr[i];
		}
		Arrays.sort(copy);
		int index = 0;
		for(int i=0;i<arr2.length;i++) {
			int first = firstOcc(arr2[i],copy,0,copy.length-1);
			if(first==-1)
				continue;
			for(int j=first;(j<copy.length && copy[j]==arr2[i]);j++) { 
				arr[index++] = copy[j];
				visited[j] = true;
			}
		}
		
		for(int i=0;i<copy.length;i++) {
			if(visited[i]==false)
				arr[index++] = copy[i];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public int firstOcc(int val , int[] arr, int start, int end) {
		if(start>end) return -1;
		int mid = start+(end-start)/2;
		if((mid==0 || arr[mid-1]<val) && arr[mid]==val)
			return mid;
		else if(arr[mid]<val)
			return firstOcc(val,arr,mid+1,end);
		else
			return firstOcc(val,arr,start,mid-1);
	}
	
	
	/*
	 * Maximum sum path in two arrays
	 */
	public int maxSum(int[] arr, int[] arr2) {
		int len1 = arr.length;
		int len2 = arr2.length;
		int i=0,j=0;
		int sum1 = 0;int sum2=0;int total=0;
		while(i<len1 && j<len2) {
			while(i<len1 & j<len2 && arr[i] !=arr2[j]) {
				if(arr[i]<arr2[j]) {
					sum1 = sum1+arr[i++];
				}
				else 
					sum2= sum2+arr2[j++];
			}
			
			if(i==len1 || j==len2) {
				while(i<len1) {
					sum1 = sum1 + arr[i++];
				}
				while(j<len2) {
					sum2 = sum2 + arr2[j++];
				}
				return sum1>sum2 ? total+sum1 : total+sum2;
			}
			
			if(arr[i]==arr2[j]) {
				sum1 = sum1+arr[i++];
				sum2 = sum2+arr2[j++];
				total = sum1>sum2 ? total+sum1 : total+sum2;
				sum1=0;
				sum2=0;
			}
		}
		return total;
	}
	
	/*
	 * Sort array in wave form 
	 */
	
	public void sortWave(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			if(i%2==0) {
				if(arr[i]<arr[i+1])
					swap(arr,i,i+1);
			}
			else {
				if(arr[i]>arr[i+1])
					swap(arr,i,i+1);
			}
				
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Index of 0 to be replaced with 1 to get longest cont sequence 
	 */
	public int indexOfZero(int[] arr) {
		int prev_prev_zero = -1;
		int prev_zero = -1;
		int maxIndex = -1;
		int maxCount =Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				if(i-prev_prev_zero-1>maxCount) {
					maxCount = i-prev_prev_zero-1;
					maxIndex = prev_zero;
				}
				prev_prev_zero = prev_zero;
				prev_zero = i; 
			}
		}
		if(arr.length-prev_prev_zero-1>maxCount)
			maxIndex = prev_zero;
		return maxIndex;
	}
	
	/*
	 * Closest pair to a given sum in two sorted arrays
	 */
	public void closestPairSum(int[] arr, int[] arr2, int sum) {
		int minDiff = Integer.MAX_VALUE;
		int res_i = -1;
		int res_j = -1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(Math.abs(arr[i]+arr2[j]-sum)<minDiff) {
					minDiff = Math.abs(arr[i]+arr2[j]-sum);
					res_i = i;
					res_j = j;
				}
			}
		}
		System.out.println("THe pairs with min sum Diff are "+arr[res_i]+" "+arr2[res_j]);
	}
	
	public void closestPairSum2(int[] arr, int[] arr2,int sum) {
		int i = 0;
		int j = arr2.length-1;
		int minDiff = Integer.MAX_VALUE;
		int res_i = -1;
		int res_j = -1;
		while(i<arr.length && j>=0) {
			if(Math.abs(arr[i]+arr2[j]-sum)<minDiff){
				minDiff = Math.abs(arr[i]+arr2[j]-sum);
				res_i = i;
				res_j = j;
			}
			if(arr[i]+arr2[j]>sum) {
				j--;
			}
			else 
				i++;
		}
		System.out.println("The pairs with min sum diff are "+arr[res_i]+" "+arr2[res_j]);
	}
	
	/*
	 *  Count 1's in a sorted array
	 */
	public int count1SUtils(int[] arr, int l, int r) {
		if(l>r) return -1;
		if(l==r) return arr[l]==1 ? l:-1;
		int m = l+(r-l)/2;
		if(m+1<=r && arr[m+1]<1 && arr[m]==1)
			return m;
		else if(arr[m]<1)
			return count1SUtils(arr,l,m-1);
		else
			return count1SUtils(arr,m+1,r);
	}
	
	public int count1S(int[] arr) {
		int count = count1SUtils(arr,0,arr.length-1);
		if(count==-1) return 0;
		return count+1;
	}
	
	/*
	 * Construct array from its sum pair array 
	 */
	public void constrSumPair(int[] arr, int[] sum, int n) {
		arr[0] = (sum[0]+sum[1]-sum[n-1])/2;
		for(int i=1;i<n;i++) {
			arr[i] = sum[i-1]-arr[0];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Common Elements in three sorted Arrays
	 */
	public void comSortedArr(int[] arr1, int[] arr2, int[] arr3) {
		int i=0,j=0,k=0;
		while(i<arr1.length && j<arr2.length && k<arr3.length) {
			if(arr1[i]<arr2[j] && arr1[i]<arr3[k])
				i++;
			else if(arr2[j]<arr1[i] && arr2[j]<arr3[k])
				j++;
			else if(arr3[k]<arr1[i] && arr3[k]<arr1[i])
				k++;
			else {
				System.out.println(arr1[i]);
				i++;j++;k++;
			}
		}
	}
	
	/*
	 * Find Smallest Number which cannot be formed from the subset of the array
	 */
	public void smallestNumberSubSet(int[] arr) {
		int res = 1;
		for(int i=0;i<arr.length && arr[i]<=res;i++)
			res = res+arr[i];
		System.out.println("The smallest number is "+res);
	}
	
	/*
	 * Rearrange array such that arr[i]=j becomes arr[j]=i
	 */
	public void reArrange(int[] arr) {
		int[] temp = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			temp[arr[i]] = i;
		}
		for(int i=0;i<arr.length;i++)
			arr[i] =temp[i];
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Rearrange array 
	 */
	public void reArrange2(int[] arr) {
		int val = 0;
		int i = arr[0];
		while(i!=0) {
			int new_val = arr[i];
			arr[i] = val;
			val = i;
			i = new_val;
		}
		arr[0] = val;
		System.out.println(Arrays.toString(arr));
	}
	
	private void reArrangeUtils(int[] arr, int index, int n) {
		int val = -(index+1);
		int i = arr[index]-1;
		while(arr[i]>0) {
			int new_val = arr[i]-1;
			arr[i] = val;
			val = -(i+1);
			i = new_val;
		}
	}
	
	public void reArrange3(int[] arr) {
		for(int i=0;i<arr.length;i++) 
			arr[i]++;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) 
				reArrangeUtils(arr,i,arr.length);
		}
		for(int i=0;i<arr.length;i++) 
			arr[i] = (-arr[i])-1;
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * 
	 * Main Method
	 */
	public static void main(String args[]) {
		ArraysAllInOne arrays = new ArraysAllInOne();
		int[] arr = {1, 2, 3, 3, 3, 3, 10};
		int[] arr2 = {2, 13, 17, 30, 45};
	//	System.out.println(arrays.checkSumPair(arr, 16));
	//	System.out.println(arrays.checkSumPair_NoSpace(arr, 16));
	//	System.out.println(arrays.oddOcc(arr));
	//	System.out.println(arrays.findMedian(arr, arr2));
	//	arrays.rotateArray(arr, 3);
	//	System.out.println(Arrays.toString(arr));
	//	System.out.println(arrays.getMax(arr));
	//	arrays.leaders(arr);
	//	arrays.count_inversions(arr);
	//	System.out.println(arrays.opt_CountInv(arr, arr2, 0, 4));
	//	System.out.println(Arrays.toString(arrays.mergeSort(arr)));
	//	System.out.println(arrays.count_Inversion_second(arr));
		int[] a ={4, 3, 5, 2, 1, 3, 2, 3};
	    int b[] = {23, 10, 20, 11, 12, 6, 7};
		int left = 0;
		int right = 4;
	//	System.out.println(arrays.sum_closestZero(arr3));
		//arrays.smallest(arr);
	//	System.out.println(arrays.checkMaj(arr, 0, 6, 3));
	//	arrays.seg012(arr3);
	//	arrays.sortArray(arr3);
	//	arrays.equil(arr3);
	//	int[][] image = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	//	arrays.rotate(image);
	//	System.out.println(arrays.isCons(arr3));
	//	System.out.println(arrays.isCons_second(arr3));
	//	System.out.println(arrays.getMaxDiffij(arr3));
	//	System.out.println(arrays.minDist(arr3, 3, 2));
	//	System.out.println(arrays.fixedPoint(arr3, 0, 5));
	//	System.out.println(arrays.biotonic(arr3));
	//	System.out.println(arrays.incDec(arr3, left, right));
	//	System.out.println(arrays.minJumps(arr3, 0, 5));
	//	System.out.println(arrays.minJumps_DP(arr3));
	//	arrays.subArray(arr3, 0);
	//	System.out.println(arrays.findSmallestPos(arr3));
	//	arrays.sortedSub(arr3);
	//	arrays.subArr(arr3);
	//	arrays.subArr01(arr3);
	//	arrays.opt_subArr01(arr3);
	//	System.out.println(arrays.maxProdArr(arr3));
	//	arrays.findPairEqDiff(arr3, 45);
	//	arrays.replaceNextGreater(arr3);
	//	System.out.println(arrays.max_Cons_wrap(arr3));
		int[][] arr4 = {  {1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}
		    };
	//	arrays.findMax1s(arr4);
	//	System.out.println(arrays.findMedianUnEqual(a, b));
	//	arrays.shuffle(b);
	//	System.out.println(arrays.triangles_second(a));
	//	arrays.iterate(a);
	//	System.out.println(arrays.numberOfislands(arr4));
		Petrol_Node[] arr_pet = {new Petrol_Node(6,8), new Petrol_Node(1,3), new Petrol_Node(2,4),new Petrol_Node(4,7)};
	//	arrays.cirCularTour(arr_pet);
	//	String[] arr5= {"54","548","546","60"};
	//	arrays.getLargestNumber(arr5);
	//	arrays.panCake(b);
	//	arrays.pankCake_insertionSort(b);
		int[] arr6 = {1, 3,4,5} ;
		int[] arr7 = {1,1,3,4} ;
		int[] arr8 = {2, 0, 1, 4, 5, 3} ;
	//	arrays.tugOfWar(arr6);
	//	System.out.println(arrays.maxSubArr_DC(arr6, 0, 7));
	//	arrays.mergeOverlapping(arr_pet);
	//	arrays.maxRepeat(arr6, 4);
	//	arrays.sortByFreq(arr6);
	//	System.out.println(arrays.findPeak(arr6, 0, 5));
	//	arrays.combinations(arr6, 4, 3);
	//	arrays.findKOccElements(arr6, 4);
	//	arrays.findKOcc(arr6, 4);
	//	System.out.println(arrays.findPositiveVal());
	//	arrays.increasingSubSeq(arr6);
	//	System.out.println(arrays.numOfPairsXY(arr6, arr7));
	//	arrays.subArraySumZero(arr7);
	//	arrays.subArrMinLen(arr7, 51);
	//	arrays.sortAnotherArray(arr7, arr6);
	//	System.out.println(arrays.maxSum(arr7, arr6));
	//	arrays.sortWave(arr7);
	//	System.out.println(arrays.indexOfZero(arr7));
	//	int sum = 32;
	//	arrays.closestPairSum(arr7, arr6, sum);
	//	arrays.closestPairSum2(arr7, arr6, sum);
	//	System.out.println(arrays.count1S(arr7));
	//	arrays.constrSumPair(arr7, arr6, 5);
	//	arrays.comSortedArr(arr8, arr7, arr6);
	//	arrays.smallestNumberSubSet(arr7);
	//	arrays.reArrange(arr8);
	//	arrays.reArrange2(arr8);
		arrays.reArrange(arr8);
	//	arrays.reArrange2(arr8);
	//	arrays.reArrange3(arr8);
		
	}
}

class MapNode {
	public int index=-1;
	public int count =0;
}

class Sum_Pair {
	public int sum;
	public int first;
	public int sec;
}

class Petrol_Node {
	public int dist;
	public int pet;
	public Petrol_Node(int pe, int dis) {
		dist = dis;
		pet = pe;
	}
}

class NKNode {
	public int element =Integer.MIN_VALUE;
	public int count = 0;
}
class Wrapper_MinSum {
	public int sum= Integer.MAX_VALUE;
}

