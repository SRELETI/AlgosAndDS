
public abstract class EnemyShips {

	private String name;
	private int amtDamaged;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) { this.name = name; }
	
	public int getAmtDamaged() { return amtDamaged; }
	public void setAmtDamaged(int amtDamaged) { this.amtDamaged = amtDamaged; }
	
	public void followHero() {
		System.out.println(getName()+" is following the hero ");
	}
	
	public void shipOnBoard() {
		System.out.println(getName()+ " is on board");
	}
	
	public void damagedMade() {
		System.out.println(getName()+ "has made a damage of"+ getAmtDamaged());
	}
	
}
