
public class Dog extends AnimalExample{
	
	private String color;
//	private Flying fl;
	public Dog() {
		super();
		System.out.println("Dog");
	//	setSound("bark");
		fl = new CantFly();
	}
	public void setSound(String s) { sound = s;}
	
	
	public void setColor(String c) { color = c; }
	
	public String getColor() { return color; }
}
