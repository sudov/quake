import java.util.*;
import Gson;

public static void main(String[] args){
	
	BufferedReader reader = new BufferedReader(new FileReader("cities1000.txt"));
	HashMap<String, String> myList;
	BufferedWriter writer = new BufferedWriter(new FileWriter(outputfilepath));

	while(reader.read()){
		System.out.println("wtf")
	}
	Gson gson = new Gson();
	gson.toJson(myList, myFileOutputStreamWriter);

}