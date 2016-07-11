
public abstract class EnemyShip {

	private String name;
	private double amtDamage;
	
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	
	public void setAmtDamage(double amt) { amtDamage = amt; }
	public double getAmtDamage() { return amtDamage; }
	
	public void followHero() {
		System.out.println(getName() +" is following the hero");
	}
	
	public void destroyed() {
		System.out.println(getName() +" has done following amount of destruction "+getAmtDamage());
	}
}
