
public class StackLinkedListApp {
	public static void main(String args[])
	{
		int length=5;
		StackLinkedList sd=new StackLinkedList(length);
		sd.push(4);
		sd.push(3);
		sd.push(2);
		sd.push(1);
		sd.push(0);
		//sd.push(7);
		sd.display();
		while(!sd.isEmpty())
		{
			sd.pop();
		}
		sd.pop();
	}
}
