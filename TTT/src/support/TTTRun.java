package support;

import java.util.Scanner;

import game.Board;
import game.Mechanics;

public class TTTRun {
	static Mechanics game = new Mechanics();
	static boolean win1 = game.xWins;
	static boolean win2 = game.oWins;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to Mitshu's Tic Tac Toe game!");
		System.out.println("Pick your game mode, please.");
		System.out.println("1: Play against the AI.");
		System.out.println("2: Play against your friends!");
		
		
		int san = scan.nextInt();
		if (san == 2) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			game.jwizz.printBoard();
			while (!game.gameOver) {
				game.jwizz.updateBoard();
			}
			
		}
		
		if (win1) {
			System.out.println("Congratulations! Player X has won!");
		}
		
		if (win2) {
			System.out.println("Congratulations! Player O has won!");
		}
	
		if (game.gameOver) {
			game.reset();
			System.out.print("Press '3' to play again!");
			int input = scan.nextInt();
			
			if (input == 3) {
				game.welcomeMessage();
			}
			
		}
		
		
				
	}

}
