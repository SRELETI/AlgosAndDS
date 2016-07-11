
public interface Flying {

	public String getFlyingType();
}

class FlyingHigh implements Flying {

	@Override
	public String getFlyingType() {
	// TODO Auto-generated method stub
		return "Flying High man";
	}
	
}

class CantFly implements Flying {

	@Override
	public String getFlyingType() {
		// TODO Auto-generated method stub
		return "Can't Fly";
	}
	
}
