
public class FacadeBank {

	private int accNumber;
	private int securityCode;
	
	private AccountChecker accChecker;
	private SecurityCheck secChecker;
	private FundCheck fundChecker;
	private WelcomeBank welcome;
	
	public FacadeBank(int newAcc, int code) {
		accNumber = newAcc;
		securityCode = code;
		welcome = new WelcomeBank();
		accChecker = new AccountChecker();
		secChecker = new SecurityCheck();
		fundChecker = new FundCheck();
		
	}
	
	public boolean withDraw(int amount) {
		if(accChecker.isAccActive(accNumber) && secChecker.isSecurityCorrect(securityCode) && fundChecker.canIWithdraw(amount)) {
			
			System.out.println("Transaction Complete ");
			return true;
		}
		else {
			System.out.println("Transaction Failed ");
			return false;
		}
	}
	
	public boolean depositCash(int amount) {
		if(accChecker.isAccActive(accNumber) && secChecker.isSecurityCorrect(securityCode)) {
			System.out.println("Transaction Complete ");
		return true;
		}
		else {
		System.out.println("Transaction Failed ");
		return false;
		}
	}
}
