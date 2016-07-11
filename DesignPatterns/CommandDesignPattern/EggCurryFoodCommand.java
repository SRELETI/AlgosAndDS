
public class EggCurryFoodCommand implements FoodCommand {

	private Cook cook;
	
	public EggCurryFoodCommand(Cook c) {
		cook = c;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		cook.EggCurryCook();
	}

}
