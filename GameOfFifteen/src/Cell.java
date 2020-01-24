import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class Cell extends JButton implements ActionListener{
	private int row;
	private int col;
	private int value;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Cell(int value, int row, int col) {
		super();
		
		this.row = row;
		this.col = col;
		this.setValue(value);
		
		
		setBorder(new EmptyBorder(3,3,3,3));	
		addActionListener(this);
		
		if(value == 0) {
			setText(" ");
		} 
		else {
			setText("" + value);
		}
	}
	
	public boolean isWin() { 
		for(int r = 0; r < GameWindow.cellArr.length; r++) {
			for(int c = 0; c < GameWindow.cellArr[r].length; c++) {
				if(GameWindow.cellArr[row][col].getValue() != GameWindow.correctCellArr[row][col].getValue()) {
					return false;
				}
			}
		}		
		return true;
	}
	
	public void swapNeighbors(int row, int col) {
		
		int currentR = row;
		int currentC = col;
		
		int emptyC = 0;
		int emptyR = 0;
		
		for (int r = 0; r < GameWindow.cellArr.length; r++) {
			for (int c = 0; c < GameWindow.cellArr[r].length; c++) {
				if(GameWindow.cellArr[r][c].getValue() == 0) {
					emptyR = GameWindow.cellArr[r][c].row;
					emptyC = GameWindow.cellArr[r][c].col;
				}
			}	
		}
		
		if((currentR == emptyR && Math.abs(currentC - emptyC)==1) || (currentC == emptyC && Math.abs(currentR - emptyR)==1)) {
			//Set new text and value to empty cell
			GameWindow.cellArr[emptyR][emptyC].setText(GameWindow.cellArr[row][col].getText());
			GameWindow.cellArr[emptyR][emptyC].setValue(GameWindow.cellArr[row][col].getValue());
			
			//Set text and value of clicked cell to zero
			GameWindow.cellArr[row][col].setText(" ");
			GameWindow.cellArr[row][col].setValue(0);
		} else {
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GameWindow.nMoves++;
		swapNeighbors(row, col);
		
		//hårdkodat, fixa sedan
		if(GameWindow.cellArr[3][3].getValue() == 0) {
			if(isWin()) {
				System.out.print("Game over!\n");
				System.out.print("You've made " + GameWindow.nMoves + "moves\n");
			}
		}
			
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
