
public class StockObservers implements Observers{

	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	private Subjects stockSubjects;
	private static int instanceCounter = 0;
	private int instanceID;
	public StockObservers(Subjects stock) {
		stockSubjects = stock;
		instanceID = ++instanceCounter;
		stockSubjects.register(this);
	}
	@Override
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		// TODO Auto-generated method stub
		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.googPrice = googPrice;
		printThem();
	}
	
	public void printThem() {
		System.out.println("The Instance ID is "+instanceID+" \nibmPrice: "+ibmPrice+" \naaplPrice: "+aaplPrice+" \ngoogPrice: "+googPrice);
	}
	
	

}
