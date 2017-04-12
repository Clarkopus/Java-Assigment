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
	
	public static void pizzaServiceA(){
		while(true){
		orderSeperated = takeOrder();
		if(orderSeperated == null)continue;
		
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
		
		orderToReturn = order.split("");
		
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
		
		//THIS ERROR CHECK NEEDS TO WORK. CONDITION ISN'T WORKING.
		else if(!orderToReturn[0].equals("m")||!orderToReturn[0].equals("M")){
			System.out.println("A valid pizza size must be present");
			return null;
		}
		//Add validation to check if current ingredents are valid
		//End of validation code
		else return orderToReturn;
	}
	/* Used to print the order
	 * Returns a String with the formatted order and the price*/
	public static String printOrder(){
		return null;
	}
	
	public static void main(String[] arguments){
		
		pizzaServiceA();
	}
}
