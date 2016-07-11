
public class TestSubjectObserver {

	public static void main(String args[]) {
		StockSubject s = new StockSubject();
		Observer o = new StockObserver(s);
		
		s.setIBMPrice(197.0);
		s.setAAPLPrice(676.1);
		s.setGOOGPrice(678.0);
		
		Observer o2 = new StockObserver(s);
		
		s.notifyObs();
	}
}
