package atmospheric_conditions;

import aerodyne.Coordinates;

public class WeatherProvider {
	
	protected static WeatherProvider weatherProvider;
	private static String[] weather = {"FOG", "RAIN", "SUN", "SNOW"};
	
	private WeatherProvider() {
		
	}
	
	public static WeatherProvider getProvider() {
		weatherProvider = new WeatherProvider();
        return weatherProvider;
	}
	
	public String getCurrentWeather (Coordinates coordinates) {
        return weather[(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4];
	}

}
