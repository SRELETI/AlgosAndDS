
public class WorkingWithState {

	public static void main(String args[]) {
		ATMMachine atm = new ATMMachine();
		atm.insertCard();
		atm.ejectCard();
		atm.insertCard();
		atm.insertPin(1234);
		atm.requestCash(500);
	}
}
