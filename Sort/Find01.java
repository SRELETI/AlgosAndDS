
public class Find01 {

	public int findIndex(int[] arr) {
		if(arr==null || arr.length==0)
			return -1;
		
		int maxIndex=-1;
		int count = 0;
		int cur_index = 0;
		int prev_index = -1;
		int prev_prev_index = -1;
		
		for(cur_index=0;cur_index<arr.length;cur_index++) {
			if(arr[cur_index]==0) {
				if(cur_index-prev_prev_index>count) {
					count = cur_index-prev_prev_index;
					maxIndex = prev_index;
				}
				prev_prev_index = prev_index;
				prev_index = cur_index;
			}
		}
		if(arr.length-prev_prev_index>count) 
			maxIndex = prev_index;
		return maxIndex;
	}
	
	public static void main(String args[]) {
		
	}
}
