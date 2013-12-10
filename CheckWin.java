import java.awt.event.ActionEvent;

import javax.swing.JButton;
//==================================================================================
//class CheckWin
// Based on the values sent from PlayerMove, this class checks to see who got three
// in a row.
//==================================================================================

public class CheckWin {

	int win = 0;

	public static String check(JButton button1, JButton button2, JButton button3) {

		if (

		(button1.isEnabled() == false) && (button2.isEnabled() == false)
				&& (button3.isEnabled() == false) && (button1.getText() == "O")
				&& (button1.getText() == button2.getText())
				&& (button2.getText() == button3.getText())) {

			return "Computer Wins";

		}
		if (

		(button1.isEnabled() == false) && (button2.isEnabled() == false)
				&& (button3.isEnabled() == false) && (button1.getText() == "X")
				&& (button1.getText() == button2.getText())
				&& (button2.getText() == button3.getText())) {

			return "User Wins";

		}

		return "";

	}

}
