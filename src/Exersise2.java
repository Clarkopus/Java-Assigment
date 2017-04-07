import java.util.Random;
import java.math.*;
/*TODO -
 * Add a way to check which element is closest to the mean 
 * replace random 2D array solution with a the requested 2D array listed in the Assigment
 * discover a way to keep track of 2D array element co-ords and print them back to the user
 * Possible solution - Hash map that keeps track of each element's co-ord by adding a new element to the map per loop
 * if that element is close to the mean, use the map to print that mapped value*/
public class Exersise2 {
	
	/* Method to find mean and returns the position of the closest element */
	public static int[] closestToMean (double[][] array){
		
		printArray(array);
		double sum =0;
		int count=0;
		int closestElement;
		for(int x=0;x<array.length;x++){
			for(int y=0;y<array.length;y++){
				sum +=array[x][y];
				count++;
			}
		}
		
		double mean = sum/count;
		System.out.println("array mean is: " + mean);
		return null;
	}
	
	public static void main(String[] arguments){
		
		double[][] numbers = new double[4][4];
		Random rng = new Random();
		int max = 10;
		int min =0;
		for(int col =0;col<4;col++){
			for( int x =0;x<4;x++){
				
				numbers[col][x] = rng.nextInt((max - min) +1) + min;
				
			}
		}
		
		closestToMean(numbers);
		
	}
	
	static void printArray(double[][]array){
		
		System.out.println("Current Array: ");
		for(int col=0;col <array.length;col++){
			for(int row=0;row<array.length;row++){
				System.out.print(array[col][row] + " ");
			}
			System.out.println();
		}
	}
}
