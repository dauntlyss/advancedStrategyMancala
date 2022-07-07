package edu.westga.cs6910.mancala.model.strategies;

/**
 * Defines the computer player's advancedStrategy behaviors
 *
 * @author Alyssa Harris
 * @version Jul 7, 2022
 */
public class AdvancedStrategy implements SelectStrategy {

	@Override
	public int selectPit(int[] theBoard) {
		int closestPit = theBoard.length - 2;
		if (theBoard[closestPit] == 1) {
			return closestPit;
		}
		
		if (theBoard[closestPit - 1] == 2) {
			return closestPit - 1;
		}
		
		if (theBoard[closestPit - 2] == 3) {
			return closestPit - 2;
		}
		
		return this.selectClosestPitWithStones(theBoard);
	}

	private int selectClosestPitWithStones(int[] theBoard) {
		int closestPit = theBoard.length - 2;
		while (closestPit > theBoard.length / 2 - 1 && theBoard[closestPit] == 0)  {
			if (theBoard[closestPit] == 0) {
				closestPit--;
			}
		}
		return closestPit;
	}

}
