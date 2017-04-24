
public class testClass {

	public static void main(String[] arguments){
		
		String[] stringList = new String[]{"poop Street","poop mountain", "poop Nevis", "Random Hill poop"};
		
		for(int x=0; x<stringList.length;x++){
			
			if(stringList[x].matches("^poop.*"))System.out.println(stringList[x]);
			//Using regex I can check if a String contains a word at the start by using the ^ operator
			// I can then follow that regex expression by typing in ".*" which means "any character (.) any amount of times(*)"
		}
		
	}
	
}
