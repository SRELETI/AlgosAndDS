
public abstract class Animals {

	private int height;
	private int weight;
	private String sound;
	
	public int getHeight() { return this.height;}
	public void setHeight(int height) { this.height = height; }
	
	public int getWeight() { return this.weight; }
	public void setWeight(int weight) { this.weight = weight; }
	
	public String getSound() { return this.sound; }
	public void setSound(String sound) { this.sound = sound; }
	
	protected Flyings fly ;
	
	public String checkFlying() { return fly.checkFlying(); }
	public void resetFlying(Flyings fly) {
		this.fly = fly;
	}
}
