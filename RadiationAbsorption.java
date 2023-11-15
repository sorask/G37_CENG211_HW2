package measurements;

public class RadiationAbsorption extends ClimateMeasurement {
    private RadiationIntensity radiationIntensity;
    private double unitAbsorptionValue;

    public RadiationAbsorption(int year, String month) {
        super(year, month);
        // Initialize measurements randomly within the range
        this.radiationIntensity = getRandomRadiationIntensity();
        this.unitAbsorptionValue = Math.random() * (20.0 - 5.0) + 5.0;
    }

    private RadiationIntensity getRandomRadiationIntensity() {
        // Return random radiation intensity
        return RadiationIntensity.values()[(int) (Math.random() * RadiationIntensity.values().length)];
    }

    public RadiationIntensity getRadiationIntensity() {
        return radiationIntensity;
    }

    public double getunitAbsorptionValue() {
        return unitAbsorptionValue;
    }
}
