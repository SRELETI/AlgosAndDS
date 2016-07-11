
public abstract class AnimalFactoryAny {

	private static AnimalFactoryAny factory=null;
	protected abstract AnimalAny getAnimal(String typeOfAnimal);
	public static AnimalFactoryAny getFactory(String typeOfFactory) {
		if(typeOfFactory.equals("sea")) {
			factory = new SeaFactory();
		}
		else if(typeOfFactory.equals("land")) {
			factory = new LandFactory();
		}
		return factory;
	}
}
