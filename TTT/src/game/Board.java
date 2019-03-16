package game;
import java.util.Scanner;

	public class Board {
		Scanner scanCoor = new Scanner(System.in);
		public int ROWS, COLS;
		public static char[][] board = new char[3][3];
		public static char currentMarker;
		boolean isFree = true;
		//constructor for Board object
		public Board() {
			currentMarker = 'X';
			initBoard();
			isFree = true;
		}
		
		//initializes game board with empty spaces
		public void initBoard() {
			
			// loop through columns
			for (int i  = 0; i < 3; i++) {
				
				//loop through rows
				for (int j = 0; j < 3; j++) {
					board[i][j] = ' ';	
				}
			}
		}
		
		
		//prints out game board
		public void printBoard() {
			
			System.out.println("-------------");
			
			for (int i = 0; i < 3; i++) {
				System.out.print("| ");
				for (int j = 0; j <3; j++) {
					System.out.print(board[i][j] + " | ");
				}
				
				System.out.println();
				System.out.println("-------------");
			}
			
		}
		
		// updates game board based on scanner input for row and column
		public void updateBoard() {
			System.out.println("Enter your desired row:");
			ROWS = scanCoor.nextInt()-1;
			System.out.println("Enter your desired column:");
			COLS = scanCoor.nextInt()-1;
			
			
			if (isFree(ROWS,COLS)) {
			board[ROWS][COLS] = currentMarker;
			printBoard();
			changePlayer();
			}
			
			else {
				notValid();
			}
			
			updateBoard();
		}
		
		// changes player marker between x's and o's
		public void changePlayer() {
			if (currentMarker == 'X') {
				currentMarker = 'O';
			}
			else {
				currentMarker = 'X';
			}
		}
		
		public boolean isFree(int input,int output) {
			if (board[input][output] != ' ') {
				isFree = false;
			}
			return isFree;
		}
		
		public void notValid() { // figure out why method keeps looping
				printBoard();
				System.out.print("Invalid move. Try again.");
				System.out.println();
				return;
			}
		}
		
	


