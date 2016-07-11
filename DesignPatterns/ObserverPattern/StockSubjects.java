import java.util.LinkedList;
import java.util.List;


public class StockSubjects implements Subjects{

	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	private List<Observers> observers = new LinkedList<Observers>();
	
	@Override
	public void register(Observers o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void unregister(Observers o) {
		// TODO Auto-generated method stub
		int index = observers.indexOf(o);
		observers.remove(index);
	}

	@Override
	public void notifyObs() {
		// TODO Auto-generated method stub
		for(Observers o: observers) {
			o.update(ibmPrice, aaplPrice, googPrice);
		}
		
	} 
	
	public void setibmPrice(double ibmPrice) { 
		this.ibmPrice  = ibmPrice; 
		notifyObs();
	}
	
	public void setaaplPrice(double aaplPrice) { 
		this.aaplPrice = aaplPrice; 
		notifyObs();
	}
	
	public void setgoogPrice(double googPrice) { 
		this.googPrice = googPrice; 
		notifyObs();
	}
	
	

}
