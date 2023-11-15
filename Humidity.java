package measurements;

public class Humidity extends ClimateMeasurement {
    private double humidityPercentage;

    public Humidity(int year, String month) {
        super(year, month);
        // Initialize measurements randomly within the range
        this.humidityPercentage = Math.random() * 100.0;
    }

    public double getHumidityPercentage() {
        return humidityPercentage;
    }
}