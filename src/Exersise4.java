import java.util.Scanner;
import java.io.*;
public class Exersise4 {
	
	static Scanner scan = new Scanner(System.in);
	static File hashMaze;
	static FileReader fileReader;
	static BufferedReader bf;
	static String filePath = "";
	
	public static void main(String[] arguments){
		Boolean[][] hashes = null;
		hashes = run(hashes);
	}
	
	public static Boolean[][] run(Boolean[][] array){
		//Test commit on new System. Ignore comment.
				
				filePath = getFilePath(filePath);
				int numberOfLines =0;
				int numberOfCharacters = 0;
				
				
				//Get number of lines to init the number of rows hashes has
				numberOfLines = getNumberOfLines(numberOfLines, filePath);
				//Get number of characters to init the number of characters hases has per row
				numberOfCharacters = getNumberOfCharacters(numberOfCharacters, filePath);
				array = new Boolean[numberOfLines][numberOfCharacters];
				initBooleanArray(array,filePath);
				printArray(array);
		return array;
	}
	
	//Used to get the path of the file
	public static String getFilePath(String path){
		System.out.println("Please enter the path of your file below");
		path = scan.nextLine();
		return path;
	}
	
	//Used to get the number of lines in the file
	public static int getNumberOfLines(int numberOfLines,String filePath){
		String line;
		try{
			hashMaze = new File(filePath);
			fileReader = new FileReader(hashMaze);
			bf = new BufferedReader(fileReader);
			while((line = bf.readLine()) != null){
				numberOfLines ++;
			}
			bf.close();
		}
		
		catch(FileNotFoundException e){
			System.out.println("Error - The file " + filePath + "Couldn't be found");
		}
		catch(IOException e){
			System.out.println("Error - " + e.toString());
			//Do nothing 
		}
		
		return numberOfLines;
	}
	
	//Used to get the number of characters in a line
	public static int getNumberOfCharacters(int characters, String filePath){
		String line;
		
		try{
			hashMaze = new File(filePath);
			fileReader = new FileReader(hashMaze);
			bf = new BufferedReader(fileReader);
			
			line = bf.readLine();
			String[] character = line.split("");
			for(String c: character){
				characters ++;
			}
			bf.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Error - The file " + filePath + "Couldn't be found");
		}
		catch(IOException e){
			System.out.println("Error - " + e.toString());
			//Do nothing 
		}
		
		return characters;
	}
	
	// This method populates the boolean array.
	// If the file contains a # character the array element will equal to true
	// If the file contains a space (" ") the array element will equal to false
	public static void initBooleanArray(Boolean[][] array, String filePath){
		
		try{
			String line;
			String[] currentLine = new String[array[0].length];
			hashMaze = new File(filePath);
			fileReader = new FileReader(hashMaze);
			bf = new BufferedReader(fileReader);
		
			for(int col=0;col <array.length;col++){
				line=bf.readLine();
				if(line==null){break;}
				currentLine =line.split("");
				
				for(int row=0;row<array[0].length;row++){
						if(currentLine[row].equals("#")){
							array[col][row] = true;
						}
						
						else{
							array[col][row] = false;
							}
					
				}
			}
			
			bf.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Error - The file " + filePath + "Couldn't be found");
		}
		catch(IOException e){
			System.out.println("Error - " + e.toString());
			//Do nothing 
		}
		
		
	}
	
	//Used to print out the Boolean 2D array to the console.
	public static void printArray(Boolean[][] array){
		
		System.out.println("Current array:");
		for(int col=0;col <array.length;col++){
			for(int row=0;row<array[0].length;row++){
				if(array[col][row] == true){System.out.print("#" + " ");}
				else{System.out.print(" " + " ");}
			}
			System.out.println();
		}
	}
	
}

