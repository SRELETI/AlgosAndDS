
public class SpecialTreePreOrder {

	public void construct(int[] pre, char[] bool, int size)
	{
		Wrapper h = new Wrapper();
		TreePrint head = constructTree(pre,bool,h,size);
		inorder(head);
	}
	
	private class Wrapper
	{
		int value=0;
	}
	private void inorder(TreePrint node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	
	private TreePrint constructTree(int[] pre, char[] bool, Wrapper index, int size)
	{
		int index_value = index.value;
		if(index_value == size)
			return null;
		
		TreePrint root = new TreePrint(pre[index_value]);
		index.value =index.value+1;
		if(bool[index_value] == 'N')
		{
			root.left = constructTree(pre,bool,index,size);
			root.right = constructTree(pre,bool,index,size);
		}
		return root;
	}
}
