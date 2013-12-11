import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
//==================================================================================
//PlayerMove()
// This class controls the players and computers move. 
// It also checks the 3-in-a-row combinations
//==================================================================================

public class PlayerMove extends GUI {

	int comp; // The random number slot that the computer generates
	int check = 0; // Checks to see if the computer should play its turn or not.

	boolean usrwin = false;
	boolean compwin = false;

	public PlayerMove(int x, int y) {
		this.setLocation(x, y);

	}

	public void actionPerformed(ActionEvent e) { // This is invoked when a
													// button is pressed
		count++; // Counts the number of presses

		for (int i = 0; i <= 8; i++) {

			if (button[i] == e.getSource()) {

				button[i].setText("X");
				button[i].setEnabled(false);

				if (count == 5) { // After 5 turns, dont let the computer play
					check = 1;
				} else
					check = 0;

				winner();

				while (check == 0) {

					comp = (int) (Math.random() * (9 - 1)) + 1; // Gen a random
																// number from 1
																// to 9 for each
																// slot

					if (button[comp - 1].isEnabled() == true) { // If a button
																// is available,
																// put an o
																// there

						button[comp - 1].setText("O");
						button[comp - 1].setEnabled(false);

						check = 1;
						winner();

					}

				}

			}

		}

	}

	// ==================================================================================
	// Checks the three in a row combinations
	// ==================================================================================
	public void winner() {

		if ((CheckWin.check(button[0], button[1], button[2])
				.equals("Computer Wins"))) {

			ShowComWin();
			endGame();

		}

		if ((CheckWin.check(button[0], button[1], button[2])
				.equals("User Wins"))) {
			ShowUserWin();
			endGame();

		}

		if ((CheckWin.check(button[3], button[4], button[5])
				.equals("Computer Wins"))) {
			ShowComWin();
			endGame();
		}
		if ((CheckWin.check(button[3], button[4], button[5])
				.equals("User Wins"))) {
			ShowUserWin();
			endGame();
		}

		if ((CheckWin.check(button[6], button[7], button[8])
				.equals("Computer Wins"))) {

			ShowComWin();
			endGame();
		}
		if ((CheckWin.check(button[6], button[7], button[8])
				.equals("User Wins"))) {
			ShowUserWin();
			endGame();
		}

		if ((CheckWin.check(button[0], button[3], button[6])
				.equals("Computer Wins"))) {
			ShowComWin();
			endGame();
		}

		if ((CheckWin.check(button[0], button[3], button[6])
				.equals("User Wins"))) {
			ShowUserWin();
			endGame();
		}

		if ((CheckWin.check(button[1], button[4], button[7])
				.equals("Computer Wins"))) {
			ShowComWin();
			endGame();
		}
		if ((CheckWin.check(button[1], button[4], button[7])
				.equals("User Wins"))) {
			ShowUserWin();
			endGame();
		}

		if ((CheckWin.check(button[2], button[5], button[8])
				.equals("Computer Wins"))) {
			ShowComWin();
			endGame();
		}
		if ((CheckWin.check(button[2], button[5], button[8])
				.equals("User Wins"))) {
			ShowUserWin();
			endGame();
		}

		if ((CheckWin.check(button[0], button[4], button[8])
				.equals("Computer Wins"))) {
			ShowComWin();
			endGame();
		}
		if ((CheckWin.check(button[0], button[4], button[8])
				.equals("User Wins"))) {
			ShowUserWin();
			endGame();
		}

		if ((CheckWin.check(button[2], button[4], button[6])
				.equals("Computer Wins"))) {
			ShowComWin();
			endGame();
		}
		if ((CheckWin.check(button[2], button[4], button[6])
				.equals("User Wins"))) {
			ShowUserWin();
			endGame();
		}

		// Checks to see if there is a cats game

		if ((usrwin == false) && (compwin == false)
				&& (button[0].isEnabled() == false)
				&& (button[1].isEnabled() == false)
				&& (button[2].isEnabled() == false)
				&& (button[3].isEnabled() == false)
				&& (button[4].isEnabled() == false)
				&& (button[5].isEnabled() == false)
				&& (button[6].isEnabled() == false)
				&& (button[7].isEnabled() == false)
				&& (button[8].isEnabled() == false)) {

			ShowCatsGame();

		}
		;

		// Exits the game if the user has finished playing on the 9 tables

		if (Game.done == 9) {

			Game.gameover();
			System.exit(0);

		}

	}

	// ==================================================================================

	// ==================================================================================
	// Ends the game for each individual table by disabling the buttons
	// ==================================================================================
	public void endGame() {
		check = 1;
		for (int i = 0; i <= button.length - 1; i++) {
			button[i].setEnabled(false);
		}
	}

	// ==================================================================================
	// The following three methods add to the list of computer, user, or cats
	// games. They
	// also display a message.
	// ==================================================================================

	public void ShowUserWin() {
		;
		Game.usrwinscore.add(1);
		Game.compwinscore.add(0);
		Game.catgamescore.add(0);
		Game.done++;
		usrwin = true;
		JOptionPane.showMessageDialog(null, "You got three in a row!");

		Game.score();

	}

	public void ShowComWin() {
		Game.compwinscore.add(1);
		Game.usrwinscore.add(0);
		Game.catgamescore.add(0);
		Game.done++;
		compwin = true;
		JOptionPane.showMessageDialog(null, "Computer got three in a row!");

		Game.score();

	}

	public void ShowCatsGame() {
		JOptionPane.showMessageDialog(null, "Cats Game!");
		Game.catgamescore.add(1);
		Game.usrwinscore.add(0);
		Game.compwinscore.add(0);
		Game.done++;
		
		Game.score();

	}
}
