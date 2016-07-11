
public class TestingStrategy {

	public static void main(String args[]) {
		Animals a = new Dogs();
		a.setSound("Bark");
		a.setHeight(20);
		a.setWeight(30);
		
		System.out.println(a.checkFlying());
		System.out.println(a.getSound());
		System.out.println(a.getHeight());
		System.out.println(a.getWeight());
		
		a.resetFlying(new CanFlys());
		
		System.out.println(a.checkFlying());
		
	}
}
