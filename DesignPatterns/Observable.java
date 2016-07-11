import java.util.ArrayList;
import java.util.List;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public abstract class Observable {

	Observable os;
	boolean isChanged;
	List<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void deleteObserver(Observer o) {
		int index = observers.indexOf(o);
		if(index>=0) 
			observers.remove(index);
	}
	
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++) {
			observers.get(i).update(this);
		}
	}
	
	public abstract void setChanged();
	
}
