
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class CurrentDisplay implements Observer,Display{
	
	/* (non-Javadoc)
	 * @see Observer#update(Observable)
	 */
	
	public float temperature;
	public float pressure;
	public float humidity;
	@Override
	public void update(Observable o) {
		// TODO Auto-generated method stub
		if(o instanceof WeatherData) {
			WeatherData wd = (WeatherData)o;
			temperature = wd.getTemperature();
			pressure = wd.getPressure();
			humidity = wd.getHumidity();
		}
	}
	
	public void display() {
		System.out.println("The current temperature is "+temperature+" and humidity is "+humidity+" and pressure is "+pressure);
	}

}
