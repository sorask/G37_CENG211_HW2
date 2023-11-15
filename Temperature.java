package measurements;

public class Temperature extends ClimateMeasurement {
    private double celciusMeasurement;
    private double fahrenheitMeasurement;
    private double kelvinMeasurement;

    public Temperature(int year, String month) {
        super(year, month);
        // Initialize measurements randomly within the range
        this.celciusMeasurement = Math.random() * (50.0 - (-40.0)) + (-40.0);
        this.fahrenheitMeasurement = convertCelsiusToFahrenheit(this.celciusMeasurement);
        this.kelvinMeasurement = convertCelsiusToKelvin(this.celciusMeasurement);
    }

    private double convertCelsiusToFahrenheit(double celsius) {
        // Apply conversion rate
        return (celsius * 9 / 5) + 32;
    }

    private double convertCelsiusToKelvin(double celsius) {
        // Apply conversion rate
        return celsius + 273.15;
    }

    public double getCelciusMeasurement() {
        return celciusMeasurement;
    }

    public double getFahrenheitMeasurement() {
        return fahrenheitMeasurement;
    }

    public double getKelvinMeasurement() {
        return kelvinMeasurement;
    }
}
