
public class SearchInsert {

	private TreePrint head;
	
	public SearchInsert()
	{
		head= null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head == null)
		{
			head = newNode;
			return;
		}
		TreePrint parent;
		TreePrint temp = head;
		
		while(temp!=null)
		{
			parent = temp;
			if(value<temp.data)
			{
				temp = temp.left;
				if(temp == null)
				{
					parent.left = newNode;
					return;
				}
			}
			else
			{
				temp = temp.right;
				if(temp == null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
		
	}
	
	public TreePrint find(TreePrint node, int key)
	{
		if(node == null || node.data == key)
			return node;
		if(key<node.data)
			return find(node.left,key);
		else
			return find(node.right,key);
	}
	
	public static void main(String args[])
	{
		SearchInsert s = new SearchInsert();
		s.insert(5);
		s.insert(4);
		s.insert(3);
		s.insert(6);
		s.insert(2);
		
		TreePrint result = s.find(s.head, 7);
		System.out.println(result == null ? null : result.data);
	}
}
