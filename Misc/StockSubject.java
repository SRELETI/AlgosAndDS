import java.util.ArrayList;


public class StockSubject implements Subject{

	public double ibmPrice;
	public double aaplPrice;
	public double googPrice;
	ArrayList<Observer> observers;
	
	public StockSubject() {
		observers = new ArrayList<Observer>();
		ibmPrice = 0.0;
		aaplPrice = 0.0;
		googPrice = 0.0;
	}
	@Override
	public void register(Observer newObserver) {
		// TODO Auto-generated method stub
		observers.add(newObserver);
		
	}
	@Override
	public void unregister(Observer obs) {
		// TODO Auto-generated method stub
		int index = observers.indexOf(obs);
		observers.remove(index);
	}
	@Override
	public void notifyObs() {
		// TODO Auto-generated method stub
		for(Observer obs: observers) {
			obs.update(ibmPrice,aaplPrice,googPrice);
		}
	}
	
	public void setIBMPrice(double val) {
		this.ibmPrice = val;
		notifyObs();
	}
	
	public void setAAPLPrice(double val) {
		this.aaplPrice = val;
		notifyObs();
	}
	
	public void setGOOGPrice(double val) {
		this.googPrice = val;
		notifyObs();
	}
	
}
