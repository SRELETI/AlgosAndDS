
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class MenuItems {

	public String name;
	public String description;
	public boolean isVeg;
	public int cost;
	
	public MenuItems(String name, String desc, boolean isVeg, int cost) {
		this.name = name;
		this.description = desc;
		this.isVeg = isVeg;
		this.cost = cost;
	}
	
	public String getName() { return name; }
	public void setName( String val ) { this.name = val; }
	
	public String getDescription(){ return description; }
	public void setDescription( String desc ) { this.description = desc; }
	
	public boolean getIsVeg() { return isVeg; }
	public void setIsVeg(boolean val) { isVeg = val; }
	
	public int getCost() { return cost; }
	public void setCost(int val) { this.cost = val; }

}
