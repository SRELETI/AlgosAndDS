
public abstract class PizzaMake {
	
	public void makePizza() {
		
		cutBun();
		
		if(doAddCheese()) {
			addCheese();
		}
		
		if(doAddMeat()) {
			addMeat();
		}
		
		if(doAddCondiment()) {
			addCondiment();
		}
		addSauce();
		System.out.println("Your pizza is ready for pickup\n");
	}	
	protected boolean doAddCheese() { return true; }
	protected boolean doAddMeat() { return true; }
	protected boolean doAddCondiment() { return true; }

	public void cutBun() {
		System.out.println("Bun is cut ");
	}
	
	public void addSauce() {
		System.out.println("Sauce is added");
	}
	
	public abstract void addMeat();
	public abstract void addCheese();
	public abstract void addCondiment();
}
