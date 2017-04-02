
import java.util.Scanner;
import java.math.*;
import java.text.DecimalFormat;

public class Exercise1 {
	
	
	public static void pizzaServiceA(){
		
		String order;
		Scanner scan = new Scanner(System.in);
		String[] order_seperated = new String[5];
		String formattedOrder ="";
		double totalPrice = 0.00;
		DecimalFormat f = new DecimalFormat("##.00");
		
		
		/* while loop is used to allow the end user to take multiple orders */
		while(true){
			
			System.out.println("Please enter your order below");
			
			order = scan.nextLine();
			if (order.equals("quit")|| order.equals("Quit")){
				break;
			}
			
			/* For loop is used to take each character and store them inside an array
			 * this is so I can treat each option as a separate entity */
			for(int x=0; x<order_seperated.length; x++){
				
				order_seperated[x] = Character.toString(order.charAt(x));
			}
			
			for(int x=0;x<1; x++){
				switch(order_seperated[x]){
				case "m":
				case "M":
					formattedOrder += "Medium pizza, ";
					totalPrice = 4.00;
					break;
				case "l":
				case "L":
					totalPrice = 5.00;
					formattedOrder +="Large pizza, ";
					break;
				default:
					break;
				}
			}
			/* x is equal to one this time round to skip the first element */
			for(int x=1;x<order_seperated.length;x++){
				switch(order_seperated[x]){
				case"m":
				case"M":
					formattedOrder +="Mozzerella, ";
					if(order_seperated[0].equals("m")||order_seperated[0].equals("M"))totalPrice += 1.00;
					else totalPrice += 1.50;
					break;
				case"h":
				case"H":
					formattedOrder +="Ham, ";
					if(order_seperated[0].equals("h") || order_seperated[0].equals("H"))totalPrice += 1.40;
					else totalPrice += 2.10;
					break;
				case"o":
				case"O":
					formattedOrder += "olives, ";
					if(order_seperated[0].equals("m")|| order_seperated[0].equals("M"))totalPrice += 0.80;
					else totalPrice += 1.20;
					break;
				case"p":
				case"P":
					formattedOrder += "pineapple, ";
					if(order_seperated[0].equals("p")||order_seperated[0].equals("P")) totalPrice += 1.00;
					else totalPrice += 1.50;
					break;
				case"s":
				case"S":
					formattedOrder +="spinach, ";
					if(order_seperated[0].equals("s")||order_seperated[0].equals("S"))totalPrice +=0.80;
					else totalPrice += 1.20;
					break;
				}
				
				
			}
			System.out.println(formattedOrder + " £" + f.format(totalPrice));
			formattedOrder = "";
			totalPrice = 0.00;
		}
		
		
	}
	
	public static void main(String[] arguments){
		
		pizzaServiceA();
	}
}
