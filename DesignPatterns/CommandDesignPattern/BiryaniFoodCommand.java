
public class BiryaniFoodCommand implements FoodCommand {

	private Cook cook = null;
	
	public BiryaniFoodCommand(Cook c) {
		cook = c;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		cook.BiryaniCook();
	}

	
}
