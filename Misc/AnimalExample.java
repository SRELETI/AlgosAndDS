
public abstract class AnimalExample {
	private int height;
	private int weight;
	protected String sound;
	public AnimalExample() {
		System.out.println("Testing ");
	}
	
	protected Flying fl;
	public void setHeight(int h) { height = h; }
	public int getHeight() { return height; }
	
	public void setWeight(int w) { weight = w; }
	public int getWeight() { return weight; }
	
	public abstract void setSound(String s);
	public String getSound() { return sound; }
	
	
	public String FlyingType() {
		return fl.getFlyingType();
	}
	
	public void changeType(Flying rs) {
		fl = rs;
	}
}
