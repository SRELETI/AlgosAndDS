
public class TestingAbstractFactory {

	public static void main(String args[]) {
		AnimalFactoryAny factory = AnimalFactoryAny.getFactory("land");
		if(factory!=null) {
			AnimalAny animal = factory.getAnimal("S");
			if(animal!=null)
				doStuff(animal);
		}
	}
	
	private static void doStuff(AnimalAny animal) {
		System.out.println(animal.getName());
		System.out.println(animal.speak());
	}
}
