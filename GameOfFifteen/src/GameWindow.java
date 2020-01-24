import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GameWindow {
	private JFrame frame;
	public static Cell cellArr[][];
	public static Cell correctCellArr[][];
	public static int nMoves;
	
	public GameWindow() {
		cellArr = new Cell[4][4];
		correctCellArr = new Cell[4][4];
		nMoves = 0;
		makeFrame();
	}

	private void makeFrame() {
		this.frame = new JFrame("Game Of Fifteen");
		
		final JPanel contentPane = (JPanel) this.frame.getContentPane();
		
		Border lineBorder = BorderFactory.createLineBorder(Color.black);
		
		contentPane.setLayout(new GridLayout(4, 4, 3, 3));
		
		GameGenerator generator = new GameGenerator(4);
		
		int row = 0;
		int col = 0;
	
		for(int i : generator) {
			
			Cell a = new Cell(i,row,col);
			a.setBorder(lineBorder);
			contentPane.add(a);
			cellArr[row][col] =(a);
			col++;
			if(col>3) {
				row++;
				col = 0;
			}
		}
		
		row = 0;
		col = 0;
		
		//Gives correct values to compare
		for(int j = 1; j < 17; j++) {
			if(j==16) {
				correctCellArr[row][col] = new Cell(0,row,col);
			} else {
			correctCellArr[row][col] = new Cell(j,row,col);
			}
			col++;
			if(col>3) {
				row++;
				col=0;
			}
		}
		
		frame.setSize(500,500);
		//frame.pack();
		frame.setVisible(true);
	}
	
}

