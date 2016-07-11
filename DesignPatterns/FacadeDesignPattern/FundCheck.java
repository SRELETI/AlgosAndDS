
public class FundCheck {

	private int balance = 1000;
	
	public int getBalance() { return balance; }
	public FundCheck() {
	}
	
	public void increaseBalance(int val) {
		balance += val;
	}
	
	public void decreaseBalance(int val) {
		balance -= val;
	}
	
	public boolean canIWithdraw(int val) {
		if(val>balance) {
			System.out.println("Not enough balance in your account ");
			System.out.println("Current balance is: "+getBalance());
			return false;
		}
		else {
			decreaseBalance(val);
			System.out.println("WithDraw Complete: Balance in the account "+getBalance());
			return true;
		}
	}
	
	public boolean depositAmount(int val) {
		increaseBalance(val);
		return true;
	}
}
