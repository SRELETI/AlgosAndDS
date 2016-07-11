
public class IndianPizza extends PizzaMake {

	String[] meat = {"Chicken","Mutton", "Fish", "Prawns"};
	String[] condiment = {"oil","Lemon Juice"};
	
	protected boolean doAddCheese() { return false; }
	@Override
	public void addMeat() {
		System.out.println("Adding meat ");
		for(String meatItems: meat) {
			System.out.print(meatItems+" ");
		}
		System.out.println();
	}

	@Override
	public void addCheese() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCondiment() {
		System.out.println("Adding Condiment ");
		for(String condi: condiment) {
			System.out.print(condi+" ");
		}
		System.out.println();
	}
	

}
