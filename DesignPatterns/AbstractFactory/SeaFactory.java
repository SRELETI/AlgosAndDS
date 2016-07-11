
public class SeaFactory extends AnimalFactoryAny{

	private AnimalAny animal = null;
	
	public AnimalAny getAnimal(String typeOfAnimal) {
		if(typeOfAnimal.equals("Sh")) {
			animal = new Shark();
		}
		else if(typeOfAnimal.equals("F")) {
			animal = new Fish();
		}
		return animal;
	}
}
