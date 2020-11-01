package embrasure;

import atmospheric_conditions.WeatherTower;

public interface Flyable {
	
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
}
