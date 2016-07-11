
public class TreeChildProperty {
	
	private TreePrint head;
	
	public TreeChildProperty()
	{
		head =null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			TreePrint parent = head;
			TreePrint temp = head;
			while(true)
			{
				parent = temp;
				if(value<temp.data)
				{
					temp=temp.left;
					if(temp==null)
					{
						parent.left=newNode;
						return;
					}
				}
				else
				{
					temp = temp.right;
					if(temp == null)
					{
						parent.right=newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inorder()
	{
		inorder(head);
	}
	private void inorder(TreePrint temp)
	{
		if(temp==null)
			return;
		inorder(temp.left);
		System.out.print(temp.data+" ");
		inorder(temp.right);
	}
	
	public void childprop()
	{
		boolean result = childPropCheck(head);
		System.out.println(result);
	}
	
	private boolean childPropCheck(TreePrint temp)
	{
		int left_data=0, right_data=0;
		if(temp==null || (temp.left==null && temp.right==null))
			return true;
		if(temp.left!=null)
			left_data=temp.left.data;
		if(temp.right!=null)
			right_data=temp.right.data;
		if(temp.data==(left_data+right_data) && childPropCheck(temp.left)==true && childPropCheck(temp.right)==true)
			return true;
		else
			return false;
	}
	
	
	public void convertProp()
	{
		convert(head);
		inorder(head);
	}
	
	private void convert(TreePrint temp)
	{
		int left_data=0, right_data=0;
		if(temp==null || (temp.left==null && temp.right==null))
			return;
		convert(temp.left);
		convert(temp.right);
		if(temp.left!=null)
		{
			left_data = temp.left.data;
		}
		if(temp.right!=null)
		{
			right_data = temp.right.data;
		}
		int diff = left_data + right_data - temp.data;
		if(diff>0)
			temp.data=temp.data+diff;
		else
			increment(temp,-diff);
				
	}
	
	private void increment(TreePrint temp, int diff)
	{
		if(temp.left!=null)
		{
			temp.left.data=temp.left.data+diff;
			increment(temp.left,diff);
		}
		else if(temp.right!=null)
		{
			temp.right.data=temp.right.data+diff;
			increment(temp.right,diff);
		}
	}
	
}
