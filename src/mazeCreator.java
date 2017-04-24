/* Class to complement E4.
 * Used to create a GUI version of the maze*/

import java.awt.*;

import javax.swing.*;
public class mazeCreator extends JComponent {
	
	static Exersise4 mazeInfo = new Exersise4();
	static Boolean[][] hashArray = null;
	
	//Create a maze object
	public static void main(String[] arguments){
		hashArray = Exersise4.run(hashArray);
		//Swing UI code
		JFrame f = new JFrame("maze creator");
		f.setSize(800,800);
		f.add(new mazeCreator());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		hashArray = Exersise4.run(hashArray);
		
		
		
	}
	
	public void paint(Graphics graphics){
		
		
		int xCord =0;
		int yCord =0;
		for(int col=0;col<hashArray.length;col++){
			Graphics2D g = (Graphics2D) graphics;
			for(int row=0; row<hashArray.length;row++){
				if(hashArray[col][row] == true){
					g.setColor(Color.black);
					g.fillRect(xCord, yCord, 15, 15);
					xCord += 15;
				}
				else{
					g.setColor(Color.WHITE);
					g.fillRect(xCord, yCord, 15, 15);
					xCord += 15;
				}
			}
			yCord +=15;
			xCord =0;
		}
		Graphics2D g = (Graphics2D) graphics;
		String command = "";
		
		g.setColor(Color.BLUE);
		g.fillOval(15, 15, 10, 10);
		//Set red start
		g.setColor(Color.RED);
		g.fillOval((getFinishCord()), (getFinishCord()), 15, 15);
		
		
		
	}
	
	public static int getFinishCord(){
		int xAndY = 0;
		if (Exersise4.filePath.matches(".*maze61.txt$")){
			xAndY = (15*59);
		}
		else if(Exersise4.filePath.matches(".*maze21.txt$")){
			xAndY = (15*19);
		}
		else if (Exersise4.filePath.matches(".*maze41.txt$")){
			xAndY = (15*39);
			
		}
		return  xAndY;
	}

	
	
	
	
}
