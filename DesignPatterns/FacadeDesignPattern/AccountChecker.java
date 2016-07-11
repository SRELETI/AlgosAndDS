
public class AccountChecker {

	private int accNumber = 1234567;
	
	public int getAccNumber() { return accNumber; }
	
	public boolean isAccActive(int accNum) {
		if(accNum==getAccNumber()) {
			
			return true;
		}
		System.out.println("Account number invalid ");
		return false;
	}
}
