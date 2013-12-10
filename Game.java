

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

//==================================================================================
// Class Game.
// 
//==================================================================================

public class Game implements Runnable {

	// Lists hold values to keep track of user and computer 'three in a rows' and the number of cats games
	public static ArrayList<Integer> usrwinscore = new ArrayList<Integer>();
	public static ArrayList<Integer> compwinscore = new ArrayList<Integer>();
	public static ArrayList<Integer> catgamescore = new ArrayList<Integer>();

	public static int usrscore = 0;
	public static int compscore = 0;
	public static int catscore = 0;
	
	//Used to determine where on the screen the window will appear
	int x;
	int y;

	//Increments each time to eventually exit the game after 9 tries
	public static int done =0;
	
	
	
		
	//==================================================================================
	//Main
	//==================================================================================
	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Welcome to tic CAT toe!");

		Object[] options = { "Help", "Play" };
		int n = JOptionPane.showOptionDialog(null, "Choose an option",
				"Tic CAT Toe", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == JOptionPane.YES_OPTION) {
			JOptionPane
					.showMessageDialog(
							null,
							"The aim of this game is to get a Cats game instead of three in a row.\n"
									+ "A Cats game is when no one gets three in a row and the board is filled up.\n"
									+"This means that NEITHER you nor the computer can get three in a row!");
			JOptionPane.showMessageDialog(null,"You have 9 tables to play on.\n"
					+"To make your move, click on any button to place in X in that spot.\n"
					+"In order to quit the game close any one table.");
			JOptionPane.showMessageDialog(
					null,"SCORING\n"
					+"0-1 Cats Game: Meh, you need practice.\n"
					+"2-3 Cats Games: Average.\n"
					+"4-6 Cats Games: Above average!\n"
					+"7 Cats Games: Excellent!\n"
					+"8 Cats Game: Your a beast!\n"
					+"9 Cats Game: World class profesional! You beat the game!\n");
					JOptionPane.showMessageDialog(null,"You will now be taken to the game. Goodluck, you'll need it!");
		}
		Game g1 = new Game();

		
		SwingUtilities.invokeLater(g1);
		

	}

	@Override
	public void run() {

		for (int i = 0; i < 9; i++) {

			if (i < 3) {
				x = (i * 250);
				y = (10);
			}

			if (i >= 3 && i <= 5) {

				x = ((i - 3) * 250);
				y = (250);

			}

			if (i > 5 && i <= 8) {
				x = (i - 6) * 250;
				y = (500);
			}
			PlayerMove m1 = new PlayerMove(x, y);
		
		//system.out.println("DONE = " + done);
		
		}
		}

	

	public static void score() {
		//system.out.println(usrwinscore);
		//system.out.println(compwinscore);

		usrscore = 0;
		compscore = 0;
		catscore = 0;

		for (int i = 0; i < usrwinscore.size(); i++) {

			//system.out.println(usrwinscore.get(i) + " " + usrscore);

			usrscore += (usrwinscore.get(i));
			compscore += (compwinscore.get(i));
			catscore += (catgamescore.get(i));

		}

		JOptionPane.showMessageDialog(null, "Three in a row: User: " + usrscore
				+ " Computer: " + compscore);

		JOptionPane.showMessageDialog(null, "You managed to get " + catscore
				+ " cat games!");

	}
	
	public static void gameover(){
		
		JOptionPane.showMessageDialog(null,"Game over!");
		
			JOptionPane.showMessageDialog(
					null,"See how you scored!\n"
					+"0-1 Cats Game: Meh, you need practice.\n"
					+"2-3 Cats Games: Average.\n"
					+"4-6 Cats Games: Above average!\n"
					+"7 Cats Games: Excellent!\n"
					+"8 Cats Game: Your a beast!\n"
					+"9 Cats Game: World class profesional! You beat the game!\n");
			
			JOptionPane.showMessageDialog(null,"The game will now exit.");
			
	}

}
