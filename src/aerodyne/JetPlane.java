package aerodyne;

import atmospheric_conditions.WeatherTower;
import embrasure.Flyable;
import note.WriteToFile;

public class JetPlane extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;
	
	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	public void updateConditions() {
		 String weatherCondition = weatherTower.getWeather(this.coordinates);
	        String regToFile = "";
	        String unregToFile = "";
	        String temp = "JetPlane#" + this.name + "(" + this.id + "): ";

	        if(weatherCondition == "RAIN"){
	            coordinates = new Coordinates(
	                    coordinates.getLongitude(),
	                    coordinates.getLatitude() + 5,
	                    coordinates.getHeight());
	            regToFile = temp + "Let the rain come down and wash away my tears...\n";
	        }
	        else if(weatherCondition == "SUN") {
	            coordinates = new Coordinates(
	                    coordinates.getLongitude(),
	                    coordinates.getLatitude() + 10,
	                    coordinates.getHeight() + 2);
	            regToFile = temp + "It is extremely hot...\n";
	        }
	        else if(weatherCondition == "FOG") {
	            coordinates = new Coordinates(
	                    coordinates.getLongitude(),
	                    coordinates.getLatitude() + 1,
	                    coordinates.getHeight());
	            regToFile = temp + "Damn it, I can't see...\n";
	        }
	        else if(weatherCondition == "SNOW") {
	            coordinates = new Coordinates(
	                    coordinates.getLongitude(),
	                    coordinates.getLatitude(),
	                    coordinates.getHeight() - 7);
	            regToFile = temp + "Winter is coming...\n";
	        }

	        WriteToFile.getWriteFile().writingToFile(regToFile);

	        if(this.coordinates.getHeight() < 0) {
	            unregToFile = "Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from Weather Tower.\n";
	            WriteToFile.getWriteFile().writingToFile(unregToFile);
	            weatherTower.unregister(this);
	        }
	}
	
	public void registerTower (WeatherTower weatherTower) {
		weatherTower.register(this);
        String write = "Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to Weather Tower.\n";
        this.weatherTower = weatherTower;
        WriteToFile.getWriteFile().writingToFile(write);
	}

}
