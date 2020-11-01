package atmospheric_conditions;



import java.io.*; 


import aerodyne.Coordinates;

public class WeatherTower extends Tower {
	
	public String getWeather( Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	
	public void changeWeather() {
		try {
            this.conditionsChanged();
        }
		catch (IOException e) {
            e.printStackTrace();
        }
	}
}
