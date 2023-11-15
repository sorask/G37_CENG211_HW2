package measurements;

import java.util.ArrayList;

public class City extends Location{
    public static final int CITY_COUNT = 3;
    private ArrayList<ClimateMeasurement> measurements;

    public City(String name) {
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
