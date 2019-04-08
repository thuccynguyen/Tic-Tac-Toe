package support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import game.Board;
import game.Mechanics;
import support.TTTRun;
import org.junit.rules.Timeout;

class TTTTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(10);
	
	Board b = new Board();
	Mechanics g = new Mechanics();
	
		
	@Test
	public void testInitializeBoard() {
		assertTrue(b.isEmpty());
	
	}
	@Test
	public void testChangePlayers() {
		Board.currentMarker = 'X';
		b.changePlayer();
		assertEquals(Board.currentMarker, 'O');
		b.changePlayer();
		assertEquals(Board.currentMarker, 'X');
		assertFalse(Board.currentMarker == 'O');
		
	}

	@Test
	public void testDraw() {
		
		testChangePlayers();
		
	}

	// tests update board functionality 
	@Test 
	public void updateBoardTest() {
		b.updateBoard(1, 1);
		assertFalse(b.isFree(0, 0));
		assertEquals('X',b.markerValue(0, 0));
		b.updateBoard(2, 2);
		assertFalse(b.isFree(1,1));
		assertEquals('O',b.markerValue(1, 1));
		b.updateBoard(3, 3);
		assertFalse(b.isFree(2, 2));
		assertFalse(b.isEmpty());
		assertEquals('X',b.markerValue(2, 2));
		
	}

	@Test
	public void isLegal() {
		
	}
	
	@Test 
	public void checkWinner() {
		b.updateBoard(1, 1); // x
		b.updateBoard(2, 2); // o
		b.updateBoard(1, 2); // x
		b.updateBoard(3, 1); // o
		b.updateBoard(1, 3); // x
		b.printBoard();
		assertTrue(1 == b.checkWinner()); 
		
	}
	
	@Test
	public void resetTest() {
		updateBoardTest();
		g.reset();
		assertTrue(b.isEmpty());
		assertTrue(b.winner == -1);
		
		
	}
}
