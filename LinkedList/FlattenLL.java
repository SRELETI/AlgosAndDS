class Practice_flat
{
	int data;
	Practice_flat right;
	Practice_flat down;
	
	public Practice_flat(int val)
	{
		data = val;
		right = null;
		down = null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
}
public class FlattenLL {

	private Practice_flat head;
	private Practice_flat last;
	
	public FlattenLL()
	{
		head = null;
		last = null;
	}
	
	public void insertion(int val)
	{
		Practice_flat newNode = new Practice_flat(val);
		if(head ==null)
			head = newNode;
		else
			last.right = newNode;
		last = newNode;
	}
	
	public void display(Practice_flat temp)
	{
		while(temp!=null)
		{
			temp.display();
			temp = temp.down;
		}
	}
	public Practice_flat flatten(Practice_flat node)
	{
		 if(node==null || node.right==null)
			 return node;
		 return merge(node,flatten(node.right));
	}
	public Practice_flat merge(Practice_flat temp1, Practice_flat temp2)
	{
	if(temp1==null && temp2==null)
		return null;
	Practice_flat head1;
	if(temp1==null)
	{
		head1= temp2;
		return head1;
	}
	if(temp2==null)
	{
		head1= temp1;
		return head1;
	}
	
	if(temp1.data<temp2.data)
	{
		head1 = temp1;
		temp1 = temp1.down;
	}
	else
	{
		head1 = temp2;
		temp2= temp2.down;
	}
	Practice_flat temp3 = head1;
	while(temp1!=null && temp2!=null)
	{
		if(temp1.data<temp2.data)
		{
			temp3.down = temp1;
			temp3 = temp3.down;
			temp1 = temp1.down;
		}
		else
		{
			temp3.down = temp2;
			temp3 = temp3.down;
			temp2 = temp2.down;
		}
	}
	
	while(temp1!=null)
	{
		temp3.down = temp1;
		temp1 = temp1.down;
		temp3 = temp3.down;
	}
	while(temp2!=null)
	{
		temp3.down = temp2;
		temp2 = temp2.down;
		temp3 = temp3.down;
	}
	return head1;
	}
	
	public static void main(String args[])
	{
		FlattenLL f = new FlattenLL();
		f.insertion(5);
		f.head.down = new Practice_flat(7);
		f.head.down.down = new Practice_flat(8);
		f.head.down.down.down = new Practice_flat(30);
		
		f.insertion(10);
		f.head.right.down = new Practice_flat(20);
		
		f.insertion(19);
		f.head.right.right.down = new Practice_flat(22);
		f.head.right.right.down.down = new Practice_flat(50);
		
		f.insertion(28);
		f.head.right.right.right.down = new Practice_flat(35);
		f.head.right.right.right.down.down = new Practice_flat(40);
		f.head.right.right.right.down.down.down = new Practice_flat(45);
		
		Practice_flat temp =f.flatten(f.head);
		f.display(temp);
		
	}
}
