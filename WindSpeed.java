package measurements;

public class WindSpeed extends ClimateMeasurement {
    private double metersPerSecond;
    private double kmPerHour;

    public WindSpeed(int year, String month) {
        super(year, month);
        // Initialize measurements randomly within the range
        this.metersPerSecond = Math.random() * 113.2;
        this.kmPerHour = convertToMetersPerSecondToKmPerHour(this.metersPerSecond);
    }

    private double convertToMetersPerSecondToKmPerHour(double metersPerSecond) {
        // Apply conversion rate
        return metersPerSecond * 3.6;
    }

    public double getMetersPerSecond() {
        return metersPerSecond;
    }

    public double getKmPerHour() {
        return kmPerHour;
    }
}
