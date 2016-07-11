
public class Adidas extends ShoppingMall{

	private Discount ds;
	
	public Adidas(String day) {
		if(day=="high") 
			ds = new HighDiscount();
		else if(day=="med")
			ds = new MedDiscount();
		else if(day=="low")
			ds = new LowDiscount();
		else 
			ds = new NoDiscount();
	}
}
