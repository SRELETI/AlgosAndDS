
public abstract class ATMState {

	public abstract void insertCard();
	public abstract void ejectCard();
	public abstract void insertPin(int pin);
	public abstract void requestCash(int val);
	
}
