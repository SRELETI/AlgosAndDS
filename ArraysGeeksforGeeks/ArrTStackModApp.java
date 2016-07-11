
public class ArrTStackModApp {
	public static void main(String args[])
	{
		ArrTStackMod am = new ArrTStackMod(10);
		am.pop();
		am.pop2();
		am.push(5);
		am.push2(5);
		am.push(4);
		am.push2(4);
		am.push(3);
		am.push2(3);
		am.push(2);
		am.push2(2);
		am.push(1);
		am.push(0);
		am.display();
		am.display2();
	}
}
