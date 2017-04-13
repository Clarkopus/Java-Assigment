/* Class to complement E4.
 * Used to create a GUI version of the maze*/

import java.awt.*;

import javax.swing.*;
public class mazeCreator extends JComponent{
	
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
					g.fillRect(xCord, yCord, 20, 20);
					xCord += 20;
				}
				else{
					g.setColor(Color.WHITE);
					g.fillRect(xCord, yCord, 20, 20);
					xCord += 20;
				}
			}
			yCord +=20;
			xCord =0;
		}
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.BLUE);
		g.fillOval(20, 20, 15, 15);
		
		
		
	}
	
	
	
	
}
