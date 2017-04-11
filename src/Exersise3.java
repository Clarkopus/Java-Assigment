import java.util.Scanner;
import java.io.*;
public class Exersise3 {
	
	static Scanner scan = new Scanner(System.in);
	static File hashMaze;
	static FileReader fileReader;
	static BufferedReader bf;
	
	public static void main(String[] arguments){
		
		String filePath = "";
		filePath = getFilePath(filePath);
		int numberOfLines =0;
		int numberOfCharacters = 0;
		Boolean[][] hashes;
		
		//Get number of lines to init the number of rows hashes has
		numberOfLines = getNumberOfLines(numberOfLines, filePath);
		//Get number of characters to init the number of characters hases has per row
		numberOfCharacters = getNumberOfCharacters(numberOfCharacters, filePath);
		hashes = new Boolean[numberOfLines][numberOfCharacters];
		String[][] HashesFormatted = new String[numberOfLines][numberOfCharacters];
		initBooleanArray(hashes,filePath);
		createHashArray(hashes,HashesFormatted);
		printArray(hashes);
		
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
				System.out.println(line);
				currentLine =line.split("");
				
				for(int row=0;row<array[0].length;row++){
						if(currentLine[row].equals("#")){
							array[col][row] = true;
							System.out.println("Element " + array[col][row]);
						}
						
						else{
							array[col][row] = false;
							System.out.println("Element " + array[col][row]);
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
	
	public static String[][] createHashArray(Boolean[][] array, String[][] formattedArray){
		
		for(int col=0;col <array.length;col++){
			for(int row=0;row<array[0].length;row++){
				if (array[col][row] == true){
					formattedArray[col][row] = "#";
				}
				else{
					formattedArray[col][row] = " ";
				}
			}
		}
		return formattedArray;
	}
	//Used to print out the Boolean 2D array
	public static void printArray(Boolean[][] array){
		
		System.out.println("Current array:");
		for(int col=0;col <array.length;col++){
			for(int row=0;row<array[0].length;row++){
				if(array[col][row] == true){System.out.print("#");}
				else{System.out.print(" ");}
			}
			System.out.println();
		}
	}
	
}

