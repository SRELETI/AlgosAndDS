
public class Customer {

	public static void main(String args[]) {
		Dealer d = new Dealer();
		Laptop lenovo = d.makeLaptop("Lenovo");
		System.out.println(lenovo);
		
		Laptop sony = d.makeLaptop("Sony");
		System.out.println(sony);
	}
}
