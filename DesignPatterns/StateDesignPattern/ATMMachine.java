
public class ATMMachine {

	private ATMState hasCard;
	private ATMState noCard;
	private ATMState hasPin;
	private ATMState noCashInMachine;
	
	private ATMState currentState;
	
	public int cashInATM=2000;
	
	public boolean correctPin = false;
	public ATMMachine() {
		hasCard = new HasCard(this);
		noCard = new NoCard(this);
		hasPin = new HasPin(this);
		noCashInMachine = new NoCashInMachine(this);
		
		currentState = noCard;
		
		if(cashInATM<0) {
			currentState = noCashInMachine;
		}
	}
	
	public void setATMState(ATMState newState) {
		currentState = newState;
	}
	
	public void setCashInMachine(int val) {
		cashInATM -= val;
	}
	
	public void insertCard() {
		currentState.insertCard();
	}
	
	public void ejectCard() {
		currentState.ejectCard();
	}
	
	public void insertPin(int pin) {
		currentState.insertPin(pin);
	}
	
	public void requestCash(int val) {
		currentState.requestCash(val);
	}
	
	public ATMState getYesCardState() { return hasCard; }
	public ATMState getNoCardState() { return noCard; }
	public ATMState getHasPinState() { return hasPin; }
	public ATMState getNoCashState() { return noCashInMachine; }
}
