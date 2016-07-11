
/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class WeatherData extends Observable {

	/* (non-Javadoc)
	 * @see Observable#setChanged()
	 */
	public float temperatur;
	public float humidity;
	public float pressure;
	public WeatherData() {
	}
	@Override
	public void setChanged() {
		// TODO Auto-generated method stub
		this.isChanged=true;
	}
	
	public void measurementChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temp, float hum, float pres) {
		this.temperatur = temp;
		this.humidity = hum;
		this.pressure = pres;
		measurementChanged();
	}
	
	public float getTemperature() {
		return this.temperatur;
	}
	
	public float getHumidity() {
		return this.humidity;
	}
	
	public float getPressure() {
		return this.pressure;
	}
}
