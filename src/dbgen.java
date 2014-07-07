import java.io.*;
import java.util.*;

public class dbgen {
	public static void main(String[] args){	
		try {
			PrintWriter writer = new PrintWriter("cities1000.json","UTF-8");
			writer.println("{");
			int counter =0;
			
			try {
				BufferedReader line = new BufferedReader(new FileReader("cities1000.txt"));
				
				while(true){
					StringTokenizer token = new StringTokenizer(line.readLine(), "\t", true);
					token.nextToken();token.nextToken();				 
					String city = token.nextToken();
					System.out.println(city);
					
					String longitude_str= token.nextToken();
					double longitude;
					while(true){
						try{
							longitude = Double.parseDouble(longitude_str);
							break;
						}
						catch(NumberFormatException e){
							longitude_str= token.nextToken();
						}
					}
					System.out.println(longitude);
					
					String latitude_str= token.nextToken();
					double latitude;
					while(true){
						try{
							latitude = Double.parseDouble(latitude_str);
							break;
						}
						catch(NumberFormatException e){
							latitude_str= token.nextToken();
						}
					}
					System.out.println(latitude);
					
					/// Waste TIME
					String temp_str= token.nextToken();
					double temp;
					while(true){
						try{
							temp = Double.parseDouble(temp_str);
							break;
						}
						catch(NumberFormatException e){
							temp_str= token.nextToken();
						}
					}
	
					String temp_str1= token.nextToken();
					double temp1;
					while(true){
						try{
							temp1 = Double.parseDouble(temp_str1);
							break;
						}
						catch(NumberFormatException e){
							temp_str1= token.nextToken();
						}
					}				
					/// END WASTE TIME
					
	
					// Get population
					String population_str = token.nextToken();
					double population=-1;
					String country="";
					while(true){
						if (	population_str.contains("Asia") ||
								population_str.contains("Europe") ||
								population_str.contains("Africa") ||
								population_str.contains("America") ||
								population_str.contains("Antarctica") ||
								population_str.contains("Australia") ||
								population_str.contains("Pacific") ||
								population_str.contains("Atlantic") ||
								population_str.contains("Indian") ){
							country = population_str;
							String[] country_array = country.split("/");
							if (country_array.length>1)
								country = country_array[1];
							else
								country = country_array[0];
							break;
						}
						else{
							try{
								population = Double.parseDouble(population_str);
								break;
							}
							catch(NumberFormatException e){
								population_str= token.nextToken();
							}
						}
					}
					
					// Get country without missing data error
					if (country == ""){
						token.nextToken();
						country = token.nextToken();
						String[] country_array = country.split("/");
						if (country_array.length>1)
							country = country_array[1];
						else
							country = country_array[0];
					}
					
					if (population != -1 && country != "") {
						System.out.println(population);
						System.out.println(country);
					} 
					else {
						System.out.println(country);
					}
					
					System.out.println();
					System.out.println();
					
					if(city!=null){
						if (	!city.equals("\t") && 
								!longitude_str.equals("\t") && 
								!latitude_str.equals("\t") && 
								!population_str.equals("\t")){
							writer.println("{");
							writer.println("\"city\" : " 		+ city + ","); 		 
							writer.println("\"longitude\" : " 	+ longitude + ","); 	 
							writer.println("\"latitude\" : " 	+ latitude + ","); 	 
							writer.println("\"population\" : "  + population + ",");  
							writer.println("\"country\" : " 	+ country); 
			
							counter++;
						}
					}
				}
			}
			catch (IOException e) {
				System.out.println("Wrong cities directory!");
			}
			catch (NullPointerException e) {
				System.out.println(counter);
				writer.println("}");
				writer.close();
				System.out.println("End of File!");
			}
		}
		catch (Exception e){
			System.out.println("Couldn't build json");
		}
	}
}
