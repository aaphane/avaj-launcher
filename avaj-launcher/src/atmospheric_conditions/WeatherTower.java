package atmospheric_conditions;



import java.io.*; 

import java.io.IOException;

import aerodyne.Coordinates;

public class WeatherTower extends Tower {
	
	public String getWeather( Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	
	public void changeWeather() throws IOException {
		this.conditionsChanged();
	}
}