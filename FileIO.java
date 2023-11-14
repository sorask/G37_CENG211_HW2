package FileAccess;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	public final static String COUNTRIES_CITIES_FILE = "src\\files\\countries_and_cities.csv";
	
	public static ArrayList<ArrayList<String>> getCountriesCities() {
		
		ArrayList<ArrayList<String>> tmpArrayListOfArrayList = new ArrayList<ArrayList<String>>();
		
		try(BufferedReader fileReader = new BufferedReader(new FileReader(COUNTRIES_CITIES_FILE)))
		{	
			int lineCount = 0;
			String line = "";
		  
			while ((line = fileReader.readLine()) != null)
			{
				String [] tmpFields = line.split(",");
				
				ArrayList<String> tmpArrayList = new ArrayList<>();
				tmpArrayList.add(tmpFields[0]);
				
				for (int i = 1; i < tmpFields.length; ++i) {
					tmpArrayList.add(tmpFields[i]);
				}
			    
				System.out.println(tmpArrayList.toString());
				System.out.println(line);
				
				tmpArrayListOfArrayList.add(new ArrayList<String>(tmpArrayList));
				lineCount++;
			}
			
		  fileReader.close();
		  System.out.println(lineCount);
		}
        catch (FileNotFoundException ex){
            System.out.println(ex);
        }
        catch (IOException ex){
            System.out.println(ex);
        }
		
		System.out.println(tmpArrayListOfArrayList.toString());
		return tmpArrayListOfArrayList;
	}
}
