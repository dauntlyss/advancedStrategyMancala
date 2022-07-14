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
		int store = theBoard.length - 1;
		int opponentsStore = theBoard.length / 2 - 1;
		
        while (closestPit >= theBoard.length / 2 - 1
                && (theBoard[closestPit] == 0 || ((theBoard[closestPit] != store - closestPit)
                        && (theBoard[closestPit] - (store - closestPit)) != store))) {
            closestPit--;
        }

        if (closestPit > opponentsStore) {
            return closestPit;
        } else {
            return this.getCaptureMove(theBoard);
        }
    }

	private int getCaptureMove(int[] theBoard) {
        int closestPit = theBoard.length - 2;
        int store = theBoard.length - 1;
		int opponentsStore = theBoard.length / 2 - 1;
		
        while (closestPit > opponentsStore && (theBoard[closestPit] == 0
                || (this.pitValuePassesScorePit(theBoard, closestPit)
                        && (theBoard[closestPit] - (store - theBoard[closestPit])) <= opponentsStore)
                || (this.pitValuePassesScorePit(theBoard, closestPit)
                        && (this.pitValueLandsOnEmptyPit(theBoard, closestPit)
                                && (this.pitToCaptureIsZero(theBoard, closestPit))))
                || (!this.pitValuePassesScorePit(theBoard, closestPit)
                        && ((((theBoard[closestPit + theBoard[closestPit]] != 0)
                                || (theBoard[theBoard.length - 2 - (closestPit + theBoard[closestPit])] == 0))))))) {
            closestPit--;
        }

        if (closestPit > opponentsStore) {
            return closestPit;
        } else {
            return this.selectClosestPitWithStones(theBoard);
        }
    }

	private int selectClosestPitWithStones(int[] theBoard) {
        int closestPit = theBoard.length - 2;
        while (theBoard[closestPit] == 0) {
        	closestPit--;
        }
        return closestPit;
    }
	
	private boolean pitValuePassesScorePit(int [] theBoard,  int closestPit) {
		return theBoard.length - 1 - closestPit < theBoard[closestPit];
	}
	
	private boolean pitValueLandsOnEmptyPit(int [] theBoard, int closestPit) {
		 return theBoard[theBoard[closestPit] - ((theBoard.length - 1) - closestPit)] != 0 
				 && theBoard[closestPit] - ((theBoard.length - 1) - closestPit) != closestPit;
	} 
	
	private boolean pitToCaptureIsZero(int [] theBoard, int closestPit) {
		return theBoard[(theBoard.length - 2) - (theBoard[closestPit] - (theBoard.length - theBoard[closestPit]))] == 0;
	}
}