
public class StockObserver implements Observer{

	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	private Subject stockGrab;
	private static int observerID=0;
	
	private int obId;
	public StockObserver(Subject s) {
		stockGrab = s;
		obId = ++observerID;
		s.register(this);
	}
	@Override
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		// TODO Auto-generated method stub
		
		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.googPrice = googPrice;
		
		printAllPrices();
	}
	
	private void printAllPrices() {
		System.out.println(" The Observer ID is: "+obId+ "\nIBM: "+ibmPrice+" \nAAPLE: "+aaplPrice+" \nGOOGLE: "+googPrice);
	}
	
	
}
