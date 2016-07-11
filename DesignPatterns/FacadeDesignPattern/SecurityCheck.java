
public class SecurityCheck {

	private int securityCode = 234;
	
	public int getSecurity() { return securityCode; }
	
	public boolean isSecurityCorrect(int code) {
		if(code == getSecurity()) {
			return true;
		}
		System.out.println("Security code Invalid");
		return false;
	}
	
}
