
public class BalancedPar {

	private InfixToPost sta;
	public BalancedPar(int val)
	{
		sta = new InfixToPost(val);
	}
	
	public void balanced(String s)
	{
		if(s.length()==0)
			return;
		for(int i=0;i<s.length();i++)
		{
			char ch = s.charAt(i);
			if(ch=='{' || ch== '(' || ch=='[')
				sta.push(ch);
			else
			{
				if(!sta.isEmpty())
				{
					char temp = (char)sta.pop();
				//	System.out.println(ch+" "+temp);
					if((ch=='}' && temp !='{') || (ch==')' && temp !='(') || (ch == ']' && temp !='['))
					{
						System.out.println("braces are not matching ");
						return;
					}
				}
				else
				{
					System.out.println("left brace is missing ");
					return;
				}
			}
		}
		if(!sta.isEmpty())
		{
			while(!sta.isEmpty())
				sta.pop();
			System.out.println("No right braces found ");
			return;
		}
		System.out.println("The parenthesis are balanced ");
		
	}
	
	public static void main(String args[])
	{
		String input ="1111";
		BalancedPar b = new BalancedPar(input.length());
	//	b.balanced(input);
		int[] arr = {13,7,6,12};
		b.nextGreater(arr);
	}
	
	public void nextGreater(int[] arr)
	{
		if(arr.length==0)
			return;
		sta.push(arr[0]);
		int temp;
		for(int i=1;i<arr.length;i++)
		{
			while(!sta.isEmpty() && (int)sta.peek()<arr[i])
			{
				temp =(int) sta.pop();
				System.out.println("The next greater element for "+temp+" is "+arr[i]);
			}
			sta.push(arr[i]);
		}
		while(!sta.isEmpty())
		{
			System.out.println("The next greater element for "+(int)sta.pop()+" is "+(-1));
		}
	}
}
