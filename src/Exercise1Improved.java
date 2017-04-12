import java.util.Scanner;

/* Improved version of exercise 1
 * Splits the different functions of the program into
 * there own separated methods to help with code
 * management and cleaner code in general.*/
public class Exercise1Improved {
	static Scanner scan;
	static String order;
	static String[] orderSeperated;
	static double totalPrice = 0.00;
	static String formattedOrder = "";
	
	public static void pizzaServiceA(){
		while(true){
		orderSeperated = takeOrder();
		if(orderSeperated == null)continue;
		printOrder();
		}
	}
	
	public static void pizzaServiceB(){
		
		
	}
	
	/* Used to take the user's order.
	 * Returns a String array which contains the characters
	 * of the order.*/ 
	public static String[] takeOrder(){
		String[] orderToReturn;
		scan = new Scanner(System.in);
		System.out.println("Please enter your order: ");
		order = scan.nextLine();
		if(order.equals("")){
			System.out.println("Sorry, you must enter an order");
			return null;
		}
		
		if(order.toLowerCase().equals("quit")){
			System.out.println("Quitting");
			System.exit(0);}
		
		orderToReturn = order.toLowerCase().split("");
		
		//order validation code
		//all code below here is used to validate the array and check for errors
		
		//Checks to see if the selected topping's don't include spaces
		for(int x=0; x<order.length();x++){
			if(orderToReturn[x].equals(" ")){
				System.out.println("Sorry, please enter a valid set of toppings");
				return null;
			}
		}
		
		//Checks to see if the length of the order isn't more than 5 characters long
		if(orderToReturn.length > 5){
			System.out.println("order can't have more than 4 toppings per pizza and 5 characters in total");
			return null;
		}
		
		
		else if(!orderToReturn[0].toLowerCase().equals("m") && !orderToReturn[0].toLowerCase().equals("l")){
			System.out.println("A valid pizza size must be present");
			return null;
		}
		//End of validation code
		return orderToReturn;
	}
	
	/* Used to print the order
	 * Returns a String with the formatted order and the price*/
	public static void printOrder(){
		formattedOrder = "";
		totalPrice = 0.00;
		switch(orderSeperated[0]){
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
			System.out.println("Order doesn't have pizza size");
			break;
		}
	/* x is equal to one this time round to skip the first element */
	for(int x=1;x<order.length();x++){
		switch(orderSeperated[x]){
		case"m":
		case"M":
			formattedOrder +="Mozzerella, ";
			if(orderSeperated[0].toLowerCase().equals("m"))totalPrice += 1.00;
			else totalPrice += 1.50;
			break;
		case"h":
		case"H":
			formattedOrder +="Ham, ";
			if(orderSeperated[0].toLowerCase().equals("h"))totalPrice += 1.40;
			else totalPrice += 2.10;
			break;
		case"o":
		case"O":
			formattedOrder += "olives, ";
			if(orderSeperated[0].toLowerCase().equals("m"))totalPrice += 0.80;
			else totalPrice += 1.20;
			break;
		case"p":
		case"P":
			formattedOrder += "pineapple, ";
			if(orderSeperated[0].toLowerCase().equals("p")) totalPrice += 1.00;
			else totalPrice += 1.50;
			break;
		case"s":
		case"S":
			formattedOrder +="spinach, ";
			if(orderSeperated[0].toLowerCase().equals("s"))totalPrice +=0.80;
			else totalPrice += 1.20;
			break;
		default:
			formattedOrder+="Unknown topping (" +orderSeperated[x] + "), ";
		}
		
	}
	System.out.println("Order: " + formattedOrder + "Total price: " + totalPrice);
	}
	
	public static void main(String[] arguments){
		
		pizzaServiceA();
	}
}
