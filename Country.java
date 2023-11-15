package measurements;

import measurements.City;

public class Country {
	private String name;
	private City[] cities;

	public String getName() {
		return name;
	}

	public City[] getCities() {
		return cities;
	}
	
	public void setCities(City[] cities) {
		this.cities=cities;
	}
}
