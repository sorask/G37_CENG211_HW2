package FileAccess;

import java.util.ArrayList;

public class App {

	FileIO fileIO = new FileIO();
	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> countryAndCityList = new ArrayList<ArrayList<String>>();
		countryAndCityList = FileIO.getCountriesCities();
	}
}
