package pokergame.view;

import java.util.Scanner;

import pokergame.logic.WinnerDecider;
import pokergame.modes.AnyCardJocker;
import pokergame.modes.HighCardJocker;
import pokergame.modes.LowCardJocker;
import pokergame.modes.NormalRule;

public class Game {
	Scanner sc;
	NormalRule normalObj;
	AnyCardJocker anyCardObj;
	HighCardJocker highCardObj;
	LowCardJocker lowCardObj;

	Game() {
		sc = new Scanner(System.in);
	}

	// made this method to start game
	public void start() {
		boolean flag = true;
		boolean flag1 = true;
		int choice;
		int choice1;
		// welcome note
		System.out.println("\t_____Welcome To Game Of Pocker_____");
		do {
			// main menu start or quit game
			System.out.println("\t_____Main Menu_____");
			System.out.println("\t1.Start Game");
			System.out.println("\t2.Quit Game");
			System.out.println("\tEnter your Choice...");
			choice = sc.nextInt();
			// game can be play in four different modes
			
				if (choice == 1) {
					do {
					// here user will select mode in which he want to play game
					System.out.println("\t_____Modes_____");
					System.out.println("\t1.Normal Mode");
					System.out.println("\t2.Any Card Jocker");
					System.out.println("\t3.High Card Jocker");
					System.out.println("\t4.Low Card Jocker");
					System.out.println("\tEnter your choice of mode...");
					choice1 = sc.nextInt();
					// user will enter number of players will play game
					System.out.println("\tEnter number of players");
					int noOfPlayers = sc.nextInt();

					if (choice1 == 1) {
						// first mode user will play as per normal rules
						System.out.println("\t_____Welcome To Normal Mode_____");
						System.out.println("Number of players " + noOfPlayers);
						normalObj = new NormalRule(noOfPlayers);
						normalObj.normalMode();
						flag1 = false;
					} else if (choice1 == 2) {
						// Second mode user will assume any card as a joker and make best combination
						System.out.println("\t_____Welcome To Any Card Jocker Mode_____");
						System.out.println("Number of players " + noOfPlayers);
						anyCardObj = new AnyCardJocker(noOfPlayers);
						anyCardObj.AnyCardProcess();
						flag1 = false;
					} else if (choice1 == 3) {
						// Third mode user will assume high card as a joker and make best combination
						System.out.println("\t_____Welcome To High Card Jocker Mode_____");
						System.out.println("Number of players " + noOfPlayers);
						highCardObj = new HighCardJocker(noOfPlayers);
						highCardObj.highCardProcess();
						flag1 = false;
					} else if (choice1 == 4) {
						// Fourth mode user will assume Low card as a joker and make best combination
						System.out.println("\t_____Welcome To Low Card Jocker Mode_____");
						System.out.println("Number of players " + noOfPlayers);
						lowCardObj = new LowCardJocker(noOfPlayers);
						lowCardObj.LowCardProcess();
						flag1 = false;
					} else {
						System.out.println("you entered wrong choice");
						flag1 = true;
					} 
					}while (flag1);
				} else if (choice == 2) {
					// Quit game, ending note
					flag = false;
					System.out.println("Thanks For Playing");
					System.out.println("Game End!");
				} else {
					System.out.println("Enter choice is Wrong");
				}
			
		} while (flag);
	}
}
