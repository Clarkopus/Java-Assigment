import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Exercise5 {
	static Hill benNevis = new Hill(255, "Ben Nevis", "Highland", 1344.5, 56.796849, -5.003525);
	static Scanner scan2 = new Scanner(System.in);
	
	public static void exercise5a() {
		  Hill benNevis = new Hill(255, "Ben Nevis", "Highland", 1344.5, 56.796849, -5.003525);
		  System.out.println(benNevis);
		}
	
	public static String getHillName(){
		
		
		return null;
		
		
		
	}
	public static void exercise5b(){
		
		
		List<Hill> hillList = new ArrayList<Hill>();
		
		hillList = benNevis.readHills();
		
		for(int x =0; x<20;x++){System.out.println(hillList.get(x)); }
	}
	
	public static void exercise5c(){
		
		List<Hill> hillList;
		hillList = Hill.readHills();
		String userInput;
		
		while(true){
			
			System.out.println("Input hill name");
			
			userInput = scan2.next();
			if(userInput.equals("quit")){
				System.out.println("Goodbye!");
				break;}
			for(int i=0; i<hillList.size();i++){
				
				Hill element = hillList.get(i);
				//If the user input matches the first part of the name (Ignore the next characters as multiple times)
				if(element.name.matches("^"+userInput+".*")){
					System.out.println(element.toString());
				}
				
			}
			
		}
		
	}
	public static void main(String[] arguments){
		
		
		//exercise5a();
		//exercise5b();
		exercise5c();
		scan2.close();
	}
	
}
