import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Hill {
	/* variable init */
int hillNumber;
String name;
String county;
double height;
double latitude;
double longitude;
static String filePath = "";
static List<Hill> hillList = new ArrayList<Hill>();
static boolean check = false;


/* Custom constructor */
	public Hill(int hillNumber, String name, String county, double height, double latitude, double longitude){
	
		this.name = name;
		this.hillNumber = hillNumber;
		this.county = county;
		this.height = height;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/* toString method to print out the Hill data */
	public String toString(){
		
		return hillNumber + ", " + name + ", " + height + ", " + latitude + ", " + longitude + "\n";
	}
	
	/* Reads the hill file */
	public static List<Hill> readHills(){
		
		//Used to store the current hill attribute (called cha)
		
		
		try{
			
			filePath = getFilePath(filePath);
			File f = new File(filePath);
			FileReader fileReader = new FileReader(f);
			BufferedReader bf = new BufferedReader(fileReader);
			bf.readLine();
			listHills(bf);
				
				bf.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Error - The file " + filePath + "Couldn't be found");
		}
		catch(IOException e){
			System.out.println("Error - " + e.toString());
			//Do nothing 
		}
		return hillList;
	}
	
	public static String getFilePath(String s){
		check = true;
		System.out.println("Enter your file name");
		Scanner scan = new Scanner(System.in);
		
		s = scan.nextLine();
		return s;
	}
	
	public static void listHills(BufferedReader bf){
		String[] cha = new String[6];
		for(int i=0; i<19770;i++){
			try{
			String currentLine = "";
			currentLine = bf.readLine();
			cha = currentLine.split(",");
			Hill currentHill = new Hill(Integer.parseInt(cha[0]),cha[1],cha[2],Double.parseDouble(cha[3]),Double.parseDouble(cha[4]),Double.parseDouble(cha[5]));
			hillList.add(currentHill);
			}
			catch(IOException e){
				System.out.println("Error - " + e.toString());
			}
		}
	}
	}
