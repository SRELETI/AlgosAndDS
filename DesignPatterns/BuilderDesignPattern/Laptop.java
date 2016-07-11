
public class Laptop {

	private String ram;
	private String hardDisk;
	private String battery;
	private String screen;
	private String brandName;
	
	public String getBrandName() { return brandName; }
	public void setBrandName(String brandName) { this.brandName = brandName;}
	
	public String getRam() { return ram; }
	public void setRam(String ram) { this.ram = ram; }
	
	public String getHardDisk() { return hardDisk;}
	public void setHardDisk(String hardDisk) { this.hardDisk = hardDisk;}
	
	public String getBattery() { return battery; }
	public void setBattery(String battery) { this.battery = battery; }
	
	public String getScreen() { return screen; }
	public void setScreen(String screen ) { this.screen = screen;}
	
	public String toString() {
		return " The makers of the laptop are "+getBrandName()+" and screen size is "+getScreen()+" and the ram size " +
		getRam()+" and memory is "+getHardDisk()+" and battery cells are "+getBattery();
		
	}
	
}
