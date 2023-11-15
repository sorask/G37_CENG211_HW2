package measurements;

public class ClimateMeasurement {
//	protected Location location;
	protected int year;
	protected String month;
	
    public ClimateMeasurement(int year, String month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }
}
