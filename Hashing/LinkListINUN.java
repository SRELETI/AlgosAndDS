import java.util.HashMap;


public class LinkListINUN {

	public TreePrint head1;
	public TreePrint head2;
	public TreePrint result;
	
	public LinkListINUN()
	{
		head1 = null;
		head2 = null;
		result = null;
	}
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head1 == null)
		{
			head1 = newNode;
			return;
		}
		newNode.right = head1;
		head1 = newNode;
	}
	
	public void insert2(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head2 == null)
		{
			head2 = newNode;
			return;
		}
		newNode.right = head2;
		head2 = newNode;
	}
	
	public void add(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(result == null)
		{
			result = newNode;
			return;
		}
		
		newNode.right = result;
		result = newNode;
	}
	
	public void union()
	{
		TreePrint temp = head1;
		
		while(temp!=null)
		{
			add(temp.data);
			temp= temp.right;
		}
		
		temp = head2;
		while(temp!=null)
		{
			if(!isPresenthead1(temp.data))
				add(temp.data);
			temp = temp.right;
		}
	}
	
	private boolean isPresenthead1(int data)
	{
		TreePrint temp = head1;
		while(temp!=null)
		{
			if(temp.data == data)
				return true;
			temp = temp.right;
		}
		return false;
	}
	
	public void display(TreePrint node)
	{
		TreePrint temp = node;
		
		while(temp!=null)
		{
			temp.display();
			temp = temp.right;
		}
	}
	
	
	public void intersection()
	{
		TreePrint temp = head2;
		while(temp!=null)
		{
			if(isPresenthead1(temp.data))
				add(temp.data);
			temp = temp.right;
		}
	}
	
	
	public void union_hash()
	{
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		
		TreePrint temp = head1;
		
		while(temp!=null)
		{
			if(h.containsKey(temp.data) == false)
			{
				h.put(temp.data, 1);
				add(temp.data);
			}
			temp = temp.right;
		}
		
		
		temp = head2;
		
		while(temp!=null)
		{
			if(h.containsKey(temp.data) == false)
			{
				h.put(temp.data, 1);
				add(temp.data);
			}
			temp = temp.right;
		}
		
		display(result);
	}
	
	public void intersection_hash()
	{
		HashMap<Integer,Integer> h = new HashMap<Integer, Integer>();
		
		TreePrint temp = head1;
		
		while(temp!=null)
		{
			if(h.containsKey(temp.data)==false)
				h.put(temp.data, 1);
			temp = temp.right;
		}
		
		temp = head2;
		
		while(temp!=null)
		{
			if(h.containsKey(temp.data)==true)
				add(temp.data);
			temp = temp.right;
		}
		
		display(result);
	}
}
