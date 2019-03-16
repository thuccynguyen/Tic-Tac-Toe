package game;
import game.Board;

public class Mechanics {
	
	public boolean xWins;
	public boolean oWins;
	private boolean freeRow = false;
	private boolean freeCol;
	public Board jwizz = new Board();
	public boolean gameOver;
	
	public static char currentMarker;
	
	// constructor which calls reset method
	public Mechanics() {
		reset();
	}
	
	// resets all game settings
	public void reset() {
		xWins = false;
		oWins = false;
		jwizz.initBoard();
		
	}
	
	
	public boolean checkColForWin() {
		return false;
	}
	
	public boolean checkRowForWin() {
		return false;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public void welcomeMessage() {
		System.out.println("Welcome to Mitshu's Tic Tac Toe game!");
		System.out.println("Pick your game mode, please.");
		System.out.println("1: Play against the AI.");
		System.out.println("2: Play against your friends!");
	}
	
	
}
