import java.util.Stack;


public class NextPer {
	Stack<Integer> s = new Stack<Integer>();
	
	public void next(int[] num) {
		if(num.length<2)
			return;
		int length = num.length;
		int j = length-1;
		while(j>0)
		{
			if(num[j-1]<num[j])
				break;
			j--;
		}
		if(j==0)
		{
			reverseSort(num,0,length-1);
			return;
		}
		int index = j-1;
		j = length-1;
		while(j>=index)
		{
			if(num[j]>num[index])
				break;
			j--;
		}
		swap(num,index,j);
		reverseSort(num,index+1,length-1);
		return;
	}
	
	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	private void reverseSort(int[]num, int i, int j) {
		while(i<j) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			i++;
			j--;
		}
	}
}
