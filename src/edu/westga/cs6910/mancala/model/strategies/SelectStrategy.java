package edu.westga.cs6910.mancala.model.strategies;

/**
 * SelectStrategy defines the common interface for all
 * 	game-play algorithms for the game of Mancala
 * 
 * @author	CS6910
 * @version	Summer 2022
 *
 */
public interface SelectStrategy {
	/**
	 * Determines which pit should be selected
	 * 	from which to distribute the stones
	 * 
	 * @param theBoard	The game board keeping track
	 * 					of the number of stones per pit
	 * 
	 * @return	The pit to be used for stone distribution
	 */
	int selectPit(int[] theBoard);
}