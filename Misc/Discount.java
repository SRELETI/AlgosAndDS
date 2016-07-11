
public interface Discount {
	public double getDiscount();
}

class LowDiscount implements Discount {

	@Override
	public double getDiscount() {
		// TODO Auto-generated method stub
		return 0.10;
	}
	
}

class MedDiscount implements Discount {

	@Override
	public double getDiscount() {
		// TODO Auto-generated method stub
		return 0.25;
	}
	
}

class HighDiscount implements Discount {

	@Override
	public double getDiscount() {
		// TODO Auto-generated method stub
		return 0.50;
	}
	
}

class NoDiscount implements Discount {

	@Override
	public double getDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
