import java.util.Arrays;

class Wrapper_post {
	int index=0;
}
public class PrintPostOrder {

	private TreeInt root;
	
	public PrintPostOrder() {
		root = null;
	}
	
	public void printPost(int[] in, int[] pre,Wrapper_post i, int start, int end) {
		int root = search(in,pre[i.index++],start,end);
	//	System.out.print(root+" ");
		if(root!=start)
		{
			printPost(in,pre,i,start,root-1);
		}
		if(root!=end)
		{
			printPost(in,pre,i,root+1,end);
		}
		System.out.print(in[root]+" ");
	}
	
	private int search(int[] in , int val, int start, int end) {
		for(int i=start;i<=end;i++)
		{
			if(in[i]==val)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[]) {
		PrintPostOrder p = new PrintPostOrder();
		int in[] = {4,2,5,1,3,6};
		int[] pre = {1, 2, 4, 5, 3, 6};
		Wrapper_post inn = new Wrapper_post();
		p.printPost(in, pre,inn, 0, in.length-1);
	}
}
