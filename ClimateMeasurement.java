package measurements;

public class Location {
	protected String name;
	protected ClimateData climateData;
	
}

public Class Country extends Location {
	
}

public Class City extends Location {
	
}

public class ClimateMeasurement {
	protected Location location;
	protected Year year;
	protected Month month;
}
