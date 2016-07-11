
public class NoCashInMachine extends ATMState {

	ATMMachine atmMachine;
    
    public NoCashInMachine(ATMMachine newATMMachine){
         
        atmMachine = newATMMachine;
         
    }

	@Override
	public void insertCard() {
		// TODO Auto-generated method stub
		System.out.println("no Cash in ATM now");
	}

	@Override
	public void ejectCard() {
		// TODO Auto-generated method stub
		System.out.println("no Cash in ATM now");
	}

	@Override
	public void insertPin(int pin) {
		// TODO Auto-generated method stub
		System.out.println("no Cash in ATM now");
	}

	@Override
	public void requestCash(int val) {
		// TODO Auto-generated method stub
		System.out.println("no Cash in ATM now");
	}
    
}
