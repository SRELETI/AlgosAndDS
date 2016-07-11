class heap {
	public int freq;
	public int val;
	
	public heap(int fre, int va) {
		freq = fre;
		val = va;
	}
}

class heap_fun {
	public heap[] arr;
	int length;
	public heap_fun(int length) {
		arr = new heap[length];
		this.length = length;
	}
}


public class CharactersD {

	public void moveD(StringBuilder text, int d) {
		if(text.length()==0)
			return;
		heap[] freq = new heap[256];
		for(int i=0;i<freq.length;i++) {
			freq[i] = new heap(0,i);
		}
		int m=0;
		for(int i=0;i<text.length();i++) {
			if(freq[text.charAt(i)].freq==0)	{
				freq[text.charAt(i)].freq=1;
				m++;
			}
			else
				freq[text.charAt(i)].freq++;
			text.setCharAt(i, ' ');
		}
		
		buildHeap(freq, 256);
		for(int i=0;i<m;i++) {
			heap max = extractMax(freq,256-i);
			int p=i;
			while(text.charAt(p)!=' ')
				p++;
			for(int k=0;k<max.freq;k++) {
				if((p+k*d)>=text.length()) {
					System.out.println("not allowed");
					return;
				}
				text.setCharAt(p+k*d,(char)max.val);
			}
		}
		System.out.println(text.toString());
	}
	
	public static void main(String args[]){
		StringBuilder text = new StringBuilder("aaa");
		CharactersD d = new CharactersD();
		d.moveD(text, 2);
	}
	
	public void buildHeap(heap[] freq, int n) {
		int i = (n-1)/2;
		while(i>=0) {
			maxHeapify(freq,i,n);
			i--;
		}
	}
	
	public void maxHeapify(heap[] freq, int i, int n) {
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		if(left<n && freq[left].freq>freq[largest].freq)
			largest = left;
		if(right<n && freq[right].freq>freq[largest].freq) 
			largest = right;
		if(largest!=i) {
			swap(freq,largest,i);
			maxHeapify(freq,largest,n);
		}
	}
	
	public heap extractMax(heap[] freq, int heap_size) {
		heap result = freq[0];
		if(heap_size>1) {
			freq[0] = freq[heap_size-1];
			maxHeapify(freq,0,heap_size);
		}
		return result;
	}
	public void swap(heap[] freq, int i, int j) {
		heap temp = freq[i];
		freq[i] = freq[j];
		freq[j] = temp;
	}
	
	
}
