
public class Composite {

	private Component heirarcy;
	
	public Composite(Component newComponent) {
		heirarcy = newComponent;
	}
	
	public void displaySongInfo() {
		heirarcy.displayInfo();
	}

}
