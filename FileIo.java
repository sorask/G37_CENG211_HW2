package data;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import measurements.City;
import measurements.Country;
import measurements.Location;

public class FileIo {
    public static final String FILENAME = "countries_and_cities.csv";
    private static String line;

    public static void readFile(ArrayList<Location> countries, ArrayList<Location> cities) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            for (int i = 0; i < Country.COUNTRY_COUNT; i++) {
                line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                countries.add(new Country(tokenizer.nextToken()));
                for (int j = 0; j < City.CITY_COUNT; j++) {
                    cities.add(new City(tokenizer.nextToken()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(FILENAME + "not found");
        } catch (IOException e) {
            System.out.println("Error reading" + FILENAME);
        }
    }
}