package measurements;

import java.util.ArrayList;

import data.FileIo;

public class ClimateRecord {
    private ArrayList<Location> countries;
    private ArrayList<Location> cities;

    public ClimateRecord() {
        this.countries = new ArrayList<>();
        this.cities = new ArrayList<>();
        FileIo.readFile(countries, cities);
    }

    public ArrayList<Double> getAverageCountryTemperature(String countryName, String measurementType, int year) {
        ArrayList<Double> averageTemperatures = new ArrayList<>();
      
        for (Location country : countries) {
            if (country.getName().equals(countryName)) {
                for (ClimateMeasurement measurement : ((Country) country).getMeasurements()) {
                    if (measurement instanceof Temperature && measurement.getYear() == year) {
                        Temperature temperature = (Temperature) measurement;
                        double avgTemperature = getTemperatureByType(temperature, measurementType);
                        averageTemperatures.add(avgTemperature);
                    }
                }
            }
        }

        return averageTemperatures;
    }

    public ArrayList<Double> getAverageCityTemperature(String cityName, String measurementType, int year) {
        ArrayList<Double> averageTemperatures = new ArrayList<>();

        for (Location city : cities) {
            if (city.getName().equals(cityName)) {
                for (ClimateMeasurement measurement : ((City) city).getMeasurements()) {
                    if (measurement instanceof Temperature && measurement.getYear() == year) {
                        Temperature temperature = (Temperature) measurement;
                        double avgTemperature = getTemperatureByType(temperature, measurementType);
                        averageTemperatures.add(avgTemperature);
                    }
                }
            }
        }

        return averageTemperatures;
    }

    private double getTemperatureByType(Temperature temperature, String measurementType) {
        switch (measurementType) {
            case "Celsius":
                return temperature.getCelciusMeasurement();
            case "Fahrenheit":
                return temperature.getFahrenheitMeasurement();
            case "Kelvin":
                return temperature.getKelvinMeasurement();
            default:
                return 0.0;
        }
    }

    public double getAverageCityWindSpeed(String cityName, String unitOfSpeed, String month) {
        int count = 0;
        double totalWindSpeed = 0.0;

        for (Location city : cities) {
            if (city.getName().equals(cityName)) {
                for (ClimateMeasurement measurement : ((City) city).getMeasurements()) {
                    if (measurement instanceof WindSpeed && measurement.getMonth().equals(month)) {
                        WindSpeed windSpeed = (WindSpeed) measurement;
                        totalWindSpeed += (unitOfSpeed.equals("km/h")) ? windSpeed.getKmPerHour()
                                : windSpeed.getMetersPerSecond();
                        count++;
                    }
                }
            }
        }

        return (count > 0) ? totalWindSpeed / count : 0.0;
    }

    public double getAverageCityHumidity(String cityName) {
        int count = 0;
        double totalHumidity = 0.0;

        for (Location city : cities) {
            if (city.getName().equals(cityName)) {
                for (ClimateMeasurement measurement : ((City) city).getMeasurements()) {
                    if (measurement instanceof Humidity) {
                        Humidity humidity = (Humidity) measurement;
                        totalHumidity += humidity.getHumidityPercentage();
                        count++;
                    }
                }
            }
        }

        return (count > 0) ? totalHumidity / count : 0.0;
    }

    public int getRadiationIntensityCount(String cityName, int year, String intensityValue) {
        int count = 0;

        for (Location city : cities) {
            if (city.getName().equals(cityName)) {
                for (ClimateMeasurement measurement : ((City) city).getMeasurements()) {
                    if (measurement instanceof RadiationAbsorption && measurement.getYear() == year) {
                        RadiationAbsorption radiation = (RadiationAbsorption) measurement;
                        if (radiation.getRadiationIntensity().toString().equalsIgnoreCase(intensityValue)) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public double calculateFeltTemperature(String cityName, String month, int year) {
        double feltTemperature = 0.0;

        for (Location city : cities) {
            if (city.getName().equals(cityName)) {
                for (ClimateMeasurement measurement : ((City) city).getMeasurements()) {
                    if (measurement instanceof Temperature &&
                            measurement.getMonth().equalsIgnoreCase(month) && measurement.getYear() == year) {
                        Temperature temperature = (Temperature) measurement;
                        feltTemperature = calculateFeltTemperatureFormula(temperature);
                    }
                }
            }
        }

        return feltTemperature;
    }

    private double calculateFeltTemperatureFormula(Temperature temperature) {
        // Placeholder
        return temperature.getCelciusMeasurement() * 2;
    }
}
