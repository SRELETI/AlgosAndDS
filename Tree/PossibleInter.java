import java.util.Arrays;


public class PossibleInter {


	private char[] alpa = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private TreeString root;
	
	public PossibleInter() {
		root = null;
	}
	
	public TreeString possible(int data, String p, int[] arr) {
		if(data>26)
			return null;
		String datato = p+alpa[data];
		TreeString temp = new TreeString(datato);
		if(arr.length!=0)
		{
			data = arr[0];
			int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
			temp.left = possible(data,datato,newArr);
		}
		if(arr.length>1)
		{
			data = arr[0]*10+arr[1];
			int[] newArr = Arrays.copyOfRange(arr, 2, arr.length);
			temp.right = possible(data,datato,newArr);
		}
		return temp;
	}
	
	private void printLeaf(TreeString temp) {
		if(temp==null)
			return;
		if(temp.left==null && temp.right==null)
		{
			temp.display();
			return;
		}
		printLeaf(temp.left);
		printLeaf(temp.right);
	}
	
	public void possible_print(int[] arr) {
		if(arr.length==0)
			return;
		TreeString temp = possible(0,"",arr);
		printLeaf(temp);
	}
	
	public static void main(String args[]) {
		PossibleInter p = new PossibleInter();
		int[] arr = {9,1,8};
		p.possible_print(arr);
	}
}
