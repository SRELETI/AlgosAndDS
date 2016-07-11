
public class WorkingWithAnimals {

	public static void main(String args[]) {
		Dog d = new Dog();
		d.setSound("bark");
		System.out.println(d.getSound());
		Cat c = new Cat();
		c.setBehav("meow");
		System.out.println(c.getBehav());
		
		System.out.println("Dog :" +d.FlyingType());
		d.changeType(new FlyingHigh());
		System.out.println("Dog :" +d.FlyingType());
	}
}
