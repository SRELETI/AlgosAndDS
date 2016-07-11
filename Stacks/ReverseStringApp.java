
public class ReverseStringApp {
	public static void main(String args[])
	{
		ReverseString rs= new ReverseString("GeeksQuiz");
		//rs.converter();
		char[] arr = {'G','e','e','k','s','Q','u','i','z'};
		reverse(arr);
	}
	public static void reverse(char[] arr)
	{
		for(int i=0;i<arr.length/2;i++)
		{
			char temp =arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
		System.out.println(arr);
	}
}
