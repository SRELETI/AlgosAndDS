
public class StackOnQueueApp {
	public static void main(String args[])
	{
		int length=5;
		StackOnQueue sd=new StackOnQueue(length);
		sd.push(5);
		sd.push(4);
		sd.push(3);
		sd.push(2);
		sd.push(1);
		sd.push(0);
		sd.pop();
	}
}
