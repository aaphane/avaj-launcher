package aerodyne;

import atmospheric_conditions.WeatherTower;
import embrasure.Flyable;
import note.WriteToFile;

public class Baloon extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;
	String weatherCondition = weatherTower.getWeather(this.coordinates);
	String temp = "Baloon#" + this.name + "(" + this.id + "): ";
	String regToFile = "";
    String unregToFile = "";
	
	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	public void updateConditions() {
		if(weatherCondition == "RAIN"){
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 5);
            regToFile = temp + "Let the rain come down and wash away my tears...\n";
        }
        else if(weatherCondition == "SUN") {
            coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 4);
            regToFile = temp + "You can see the sparks from high meadows";
        }
        else if(weatherCondition == "FOG") {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 3);
            regToFile = temp + "Damn it! I can't see...\n";
        }
        else if(weatherCondition == "SNOW") {
            coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 15);
            regToFile = temp + "Winter is coming...\n";
        }
        WriteToFile.getWriteFile().writingToFile(regToFile);

        if(this.coordinates.getHeight() < 0) {
            unregToFile = "Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from Weather Tower.\n";
            WriteToFile.getWriteFile().writingToFile(unregToFile);
            weatherTower.unregister(this);
        }
	}
	
	public void registerTower(WeatherTower weatherTower) {
		   weatherTower.register(this);
	        String write = "Tower says: Baloon#" + this.name + "(" + this.id + ") registered to Weather Tower.\n";
	        this.weatherTower = weatherTower;
	        WriteToFile.getWriteFile().writingToFile(write);
	}

}
