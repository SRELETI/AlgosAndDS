
public class BinaryNumbersPrint {

	private void binaryNumbers(int n)
	{
		if(n==0)
			return;
		MainQueueLL m = new MainQueueLL();
		m.enqueue_str("1");
		while(n-- > 0)
		{
			String temp = m.dequeue_str();
			System.out.println(temp);
			String s2 = temp;
			m.enqueue_str(temp+"0");
			m.enqueue_str(s2+"1");
		}
	}
	
	public static void main(String args[]) {
		BinaryNumbersPrint b = new BinaryNumbersPrint();
		b.binaryNumbers(10);
	}
}
