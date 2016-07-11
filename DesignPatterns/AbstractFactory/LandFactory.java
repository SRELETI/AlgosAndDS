
public class LandFactory extends AnimalFactoryAny {

	private AnimalAny animal = null;
	public AnimalAny getAnimal(String typeOfAnimal) {
		if(typeOfAnimal.equals("C")) {
			animal = new CatAny();
		}
		else if(typeOfAnimal.equals("D")) {
			animal = new DogAny();
		}
		else if(typeOfAnimal.equals("S")) {
			animal = new Snake();
		}
		return animal;
	}
}
