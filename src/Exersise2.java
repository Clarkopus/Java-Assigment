/* TODO -
 * Clean up code by putting a lot of it into other functions */

import java.util.Arrays;
public class Exersise2  {
	
	/* Method to find mean and returns the position of the closest element */
	public static int[] closestToMean (double[][] array){
		double[][] difference = new double[3][4];
		double min = Integer.MAX_VALUE;
		int[] coord = new int[2];
		int xCord = 0;
		int yCord = 0;
		printArray(array);
		double sum =0;
		int count=0;
		for(int x=0;x<array.length;x++){
			for(int y=0;y<array[0].length;y++){
				sum +=array[x][y];
				count++;
			}
		}
		
		double mean = sum/count;
		System.out.println("array mean is: " + mean);
		findDifference(array,difference,mean);
		
		for(int x=0; x<difference.length;x++){
			for(int y=0;y<difference[0].length;y++){
				if(difference[x][y] <min) {min = difference[x][y];coord[0]=x; coord[1] =y; xCord = x; yCord = y;}
			}
		}
		System.out.println("The closest element is: " + array[xCord][yCord]);
		return coord;
	}

	
	public static void main(String[] arguments){
		
		double[][] numbers = new double[3][4];
		numbers[0][0] = 3;
		numbers[0][1] = -1;
		numbers[0][2] = -4;
		numbers[0][3] = 0;
		numbers[1][0]= 5;
		numbers[1][1] = -2;
		numbers[1][2] = 9;
		numbers[1][3] = 6;
		numbers[2][0] =8; 
		numbers[2][1] = 2;
		numbers[2][2] = 4;
		numbers[2][3] =-9;
		System.out.println("The co-ords for this element is" + Arrays.toString(closestToMean(numbers)));
		
	}
	
	static void printArray(double[][]array){
		
		System.out.println("Current Array: ");
		for(int col=0;col <array.length;col++){
			for(int row=0;row<array[0].length;row++){
				System.out.print(array[col][row] + " ");
			}
			System.out.println();
		}
	}
	
	static void findDifference(double[][] array,double[][] arrayToFindD,double mean){
		
		for(int x =0; x<array.length; x++){
			for(int y=0;y<array[0].length;y++){
				arrayToFindD[x][y] = Math.abs(mean-array[x][y]);
				
			}
		}
	}


}
