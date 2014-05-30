import java.io.*;

public class dbgen {
	public static void main(String[] args){	
		try{
			BufferedReader line = new BufferedReader(new FileReader("cities1000.txt"));
			while(line.readLine()!=null){
				
			}
			}
		catch(IOException event){
			System.out.println("Wrong cities directory");
		}
	}
}