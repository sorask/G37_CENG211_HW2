package measurements;

import java.util.ArrayList;

public class Country extends Location{
	
	public static final int COUNTRY_COUNT = 5;
	private ArrayList<ClimateMeasurement> measurements;

    public Country(String name) {
        super(name);
        this.measurements = new ArrayList<>();
    }
    
	public String getName() {
		return super.getName();
	}
	
    public ArrayList<ClimateMeasurement> getMeasurements() {
        return measurements;
    }
}
