
public class HasPin extends ATMState {

	ATMMachine atmMachine;
    
    public HasPin(ATMMachine newATMMachine){
         
        atmMachine = newATMMachine;
         
    }
	@Override
	public void insertCard() {
		// TODO Auto-generated method stub
		System.out.println("Cant enter more than one card ");
	}

	@Override
	public void ejectCard() {
		// TODO Auto-generated method stub
		System.out.println("Card ejected");
		atmMachine.setATMState(atmMachine.getNoCardState());
	}

	@Override
	public void insertPin(int pin) {
		// TODO Auto-generated method stub
		System.out.println("You already entered a pin ");
	}

	@Override
	public void requestCash(int cashToWithdraw) {
		// TODO Auto-generated method stub
		if(cashToWithdraw > atmMachine.cashInATM){	             
				            System.out.println("You don't have that much cash available");
				            System.out.println("Your card is ejected");
				            atmMachine.setATMState(atmMachine.getNoCardState());
				             
				        } else {
				             
				            System.out.println(cashToWithdraw + " is provided by the machine");
				            atmMachine.setCashInMachine(atmMachine.cashInATM - cashToWithdraw);
				             
			            System.out.println("Your card is ejected");
				            atmMachine.setATMState(atmMachine.getNoCardState());
				             
				            if(atmMachine.cashInATM <= 0){
				                 
				                atmMachine.setATMState(atmMachine.getNoCashState());
				                 
				            }
				        }
			
	}

		
}
