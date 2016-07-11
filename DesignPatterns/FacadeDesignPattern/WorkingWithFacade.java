
public class WorkingWithFacade {

	public static void main(String args[]) {
		
		int accNumber = 1234567;
		int code = 234;
		FacadeBank f = new FacadeBank(accNumber,code);
		f.withDraw(50);
		f.withDraw(900);
		f.withDraw(100);
		
	}
}
