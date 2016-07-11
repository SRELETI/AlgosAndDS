
public class OddEven {

	public static void main(String args[]) {
		OddEven o = new OddEven();
		System.out.println(o.isEven(0));
	}
	
	public boolean isEven(int num) {
		if(num%2==0) {
			return true;
		}
		else {
			return false;
		}
	}
}
