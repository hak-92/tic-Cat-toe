import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//==================================================================================
// Class GUI()
// This class is an abstract class, which means it is a mere template. 
// It extends the inbuilt Jframe class
// It also implements the ActionListener interface
// The GUI class sets up a frame with a 3x3 Grid. It creates an array of buttons
// and adds the button to the grid.
//==================================================================================
public abstract  class GUI extends JFrame implements ActionListener {
	JPanel panel;
	JButton[] button;

	int count = 0;
	int sign = 0;

	public GUI() {

		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		this.add(panel);
		button = new JButton[9];

		for (int i = 0; i <= 8; i++) {
			button[i] = new JButton();
			panel.add(button[i]);
			button[i].setEnabled(true);
			button[i].addActionListener(this);

		}
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

}
