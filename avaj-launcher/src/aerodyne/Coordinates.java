package aerodyne;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;
	
	Coordinates(int longitude, int latitude, int height) {
		if(longitude < 0) {
			longitude = 0;
		}
		if(latitude < 0) {
			latitude = 0;
		}
		if(height < 0) {
			height = 0;
		}
		this.longitude = longitude;
	    this.latitude = latitude;
	    this.height = height;
	}
	
	public int getLongitude() {
		return this.longitude;
	}
	
	public int getLatitude() {
		return this.latitude;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	
}
