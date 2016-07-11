
public class TestingObservers {

	public static void main(String args[]) {
		Subjects s = new StockSubjects();
		Observers o1 = new StockObservers(s);
		
	//	s.notifyObs();
		
	//	((StockSubjects) s).setibmPrice(200);
	//	((StockSubjects) s).setaaplPrice(200);
	//	((StockSubjects) s).setgoogPrice(200);
		
		Observers o2 = new StockObservers(s);
		
		
		
		s.register(new StockObservers(s));
		s.unregister(o1);
		s.notifyObs();
	}
}
