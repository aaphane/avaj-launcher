package aerodyne;

import atmospheric_conditions.WeatherTower;
import embrasure.Flyable;
import note.WriteToFile;

public class Helicopter extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	public void updateConditions() {
		 String weatherCondition = weatherTower.getWeather(this.coordinates);
	        String regToFile = "";
	        String unregToFile = "";
	        String temp = "Helicopter#" + this.name + "(" + this.id + "): ";

	        if(weatherCondition == "RAIN"){
	            coordinates = new Coordinates(
	                    coordinates.getLongitude() + 5,
	                    coordinates.getLatitude(),
	                    coordinates.getHeight());
	            regToFile = temp + "Let the rain come down wash away my tears...\n";
	        }
	        else if(weatherCondition == "SUN") {
	            coordinates = new Coordinates(
	                    coordinates.getLongitude() + 10,
	                    coordinates.getLatitude(),
	                    coordinates.getHeight() + 2 > 100 ? 100 : coordinates.getHeight() + 2 );
	            regToFile = temp + "It is extremely hot...\n";
	        }
	        else if(weatherCondition == "FOG") {
	            coordinates = new Coordinates(
	                    coordinates.getLongitude() + 1,
	                    coordinates.getLatitude(),
	                    coordinates.getHeight());
	            regToFile = temp + "Damn it, I can't see...\n";
	        }
	        else if(weatherCondition == "SNOW") {
	            coordinates = new Coordinates(
	                    coordinates.getLongitude(),
	                    coordinates.getLatitude(),
	                    coordinates.getHeight() - 12 < 0 ? 0 : coordinates.getHeight() - 12);
	            regToFile = temp + "Winter is coming...\n";
	        }

	        WriteToFile.getWriteFile().writingToFile(regToFile);

	        if(this.coordinates.getHeight() < 0) {
	            unregToFile = "Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from Weather Tower.\n";
	            WriteToFile.getWriteFile().writingToFile(unregToFile);
	            weatherTower.unregister(this);
	        }
	}
	
	public void registerTower(WeatherTower weatherTower) {
		
	}

}
