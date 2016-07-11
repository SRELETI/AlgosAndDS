
public class ReverseStack {

	private InfixToPost sta;
	
	public ReverseStack(int val) {
		sta = new InfixToPost(val);
	}
	
	public void reverse()
	{
		if(sta.isEmpty())
			return;
		int temp = (int) sta.pop();
		reverse();
		insertAtbottom(temp);
	}
	
	public void insertAtbottom(int temp)
	{
		if(sta.isEmpty())
		{
			sta.push(temp);
			return;
		}
		int temp2 = (int) sta.pop();
		insertAtbottom(temp);
		sta.push(temp2);
	}
	
	public static void main(String args[])
	{
		
		ReverseStack r = new ReverseStack(4);
		r.sta.push(4);
		r.sta.push(3);
		r.sta.push(2);
		r.sta.display();
		r.reverse();
		r.sta.display();
		
	}
}
