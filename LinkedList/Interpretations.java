import java.util.Arrays;


public class Interpretations {

	public TreePrintString head;
	public String[] alpha= {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};;
	public Interpretations()
	{
		head = null;
	}
	
	public void check(int[] arr)
	{
		TreePrintString head = checking(0,"",arr);
		printLeaf(head);
	}
	
	private TreePrintString checking(int data, String empty, int[] arr)
	{
		if(data>26)
			return null;
		String newString = empty + alpha[data];
		TreePrintString root = new TreePrintString(newString);
		if(arr.length!=0)
		{
			data = arr[0];
			int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
			
			root.left = checking(data,newString,newArr);
		if(arr.length>1)
		{
			data = arr[0]*10+arr[1];
			
			newArr = Arrays.copyOfRange(arr, 2, arr.length);
			
			root.right = checking(data,newString,newArr);
		}
		}
		return root;
	}
	
	private void printLeaf(TreePrintString node)
	{
		if(node==null)
			return;
		if(node.left == null && node.right == null)
		{
			System.out.print(node.data+" ");
			return;
		}
		printLeaf(node.left);
		printLeaf(node.right);
	}
}
