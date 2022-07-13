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
		int store = theBoard.length - 1;

		while (closestPit > theBoard.length / 2 - 1) {
			if (theBoard[closestPit] == stonesNeeded) {
				return closestPit;
			} else if (closestPit > theBoard.length / 2 - 1 && (((theBoard[closestPit] == 0
					|| store - closestPit < theBoard[closestPit]
							&& (theBoard[closestPit] - (store - theBoard[closestPit])) <= theBoard.length / 2 - 1)
					|| store - closestPit < theBoard[closestPit] 
							&& theBoard[theBoard.length - 2 - (closestPit + theBoard[closestPit])] == 0
					|| store - closestPit < theBoard[closestPit] 
							&& theBoard[closestPit + theBoard[closestPit]] != 0
							|| (theBoard[theBoard.length - 2 - (closestPit + theBoard[closestPit])] == 0)))) {

				return closestPit - 1;
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
}