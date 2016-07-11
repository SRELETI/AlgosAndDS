
public class HyderabadiPizza extends PizzaMake {

	private String[] meatItems = {"Chicken","Mutton","Fish","Prawns","Kalyani"};
	private String[] cheese = {"White Cheese", "Chatur Cheese","Tasty Cheese"};
	private String[] condiment = {"Oil","Vinegar","Lemon Juice"};
	@Override
	public void addMeat() {
		System.out.println("Adding meat:");
		for(String meat: meatItems) {
			System.out.print(meat+" ");
		}
		System.out.println();
	}

	@Override
	public void addCheese() {
		System.out.println("Adding Cheese ");
		for(String condi: cheese) {
			System.out.print(condi+" ");
		}
		System.out.println();
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
