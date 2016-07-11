
public class NoCard extends ATMState {

	ATMMachine atmMachine;
    
    public NoCard(ATMMachine newATMMachine){
         
        atmMachine = newATMMachine;
         
    }
 
    public void insertCard() {
         
        System.out.println("Card Inserted");
        atmMachine.setATMState(atmMachine.getYesCardState());
         
    }
 
    public void ejectCard() {
         
        System.out.println("Insert card to eject");
    
         
    }
 
    public void requestCash(int cashToWithdraw) {
         
        System.out.println("Insert card to request cash");
         
         
    }
 
    public void insertPin(int pinEntered) {
         
    	System.out.println("insert card ");
    }  

}

