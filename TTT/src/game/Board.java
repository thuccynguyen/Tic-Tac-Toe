package game;
import java.util.Scanner;

	public class Board {
		Scanner scanCoor = new Scanner(System.in);
		public int ROWS, COLS;
		public static char[][] board = new char[3][3];
		public static char currentMarker;
		boolean isFree = true;
		public int winner;
		//constructor for Board object
		public Board() {
			currentMarker = 'X';
			initBoard();
			isFree = true;
			winner = -1;
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
			
			
			
			board[ROWS][COLS] = currentMarker;
			printBoard();
			
			if (checkWinner() == -1) {
			changePlayer();
			updateBoard();
			}
			
		}
		
		public void updateBoard(int rows, int cols) {
			ROWS = rows-1;
			COLS = cols-1;
			
			
			board[ROWS][COLS] = currentMarker;
			
			changePlayer();
			
			
			
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
		
		// possible infinite loop somewhere?
		public boolean isFree(int input,int output) {
			if (board[input][output] != ' ') {
				isFree = false;
			}
			return isFree;
		}
		
		
		
		public int checkWinner() {
			for (int box = 0; box < 8; box++) {
				String line = null;
				switch (box) {
				case 0: 
					line = String.valueOf(board[1][1]) + 
					String.valueOf(board[1][2]) +
					String.valueOf(board[1][0]);
					break;
					
				case 1: 
					line = String.valueOf(board[2][1]) + 
					String.valueOf(board[2][2]) +
					String.valueOf(board[2][0]);
					break;
					
				case 2: 
					line = String.valueOf(board[0][1]) + 
					String.valueOf(board[0][2]) +
					String.valueOf(board[0][0]);
					break;
					
				case 3: 
					line = String.valueOf(board[1][1]) + 
					String.valueOf(board[2][1]) +
					String.valueOf(board[0][1]);
					break;
				
				case 4:
					line = String.valueOf(board[1][2]) + 
					String.valueOf(board[2][2]) +
					String.valueOf(board[0][2]);
					break;
					
				case 5: 
					line = String.valueOf(board[1][0]) + 
					String.valueOf(board[2][0]) +
					String.valueOf(board[0][0]);
					break;
					
				case 6:
					line = String.valueOf(board[1][1]) + 
					String.valueOf(board[2][2]) +
					String.valueOf(board[0][0]);
					break;
					
				case 7:
					line = String.valueOf(board[1][0]) + 
					String.valueOf(board[2][2]) +
					String.valueOf(board[0][1]);
					break;
				}
				
				if (line.equals("XXX")) {
					winner = 1;
					
				}
				
				if (line.equals("OOO")) {
					winner = 0;
					
				}
				
			}
			
			return winner;
		}
		
		public void checkDraw() {
			boolean freeSpace = false;
			for (int i  = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] == ' ') {
						freeSpace = true;
					}
				}
			}
			
			if (!freeSpace && winner==-1) {
				
				System.out.print("The game is a draw.");
		
			}
		}	
		
		public char markerValue(int rows, int cols) {
			
			char markerValue = board[rows][cols];
			return markerValue;
		}
		
		public boolean isEmpty() {
			
			boolean isEmpty = true;
			
			for (int i  = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] != ' ') {
						isEmpty = false;
					}
					
				}
			}
			
			return isEmpty;
		}
		
	}
		
	
	


