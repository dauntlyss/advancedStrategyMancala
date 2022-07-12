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
		int stonesNeeded = 1;

		while (closestPit > theBoard.length / 2 - 1) {
			if (theBoard[closestPit] == stonesNeeded) {
				return closestPit;
			} else if (stonesNeeded == 4) {
				this.captureFromOppositePit(theBoard);
			} 
			closestPit--;
			stonesNeeded++;
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
	
	private int captureFromOppositePit(int[] theBoard) {
		return 1;
	}
}
