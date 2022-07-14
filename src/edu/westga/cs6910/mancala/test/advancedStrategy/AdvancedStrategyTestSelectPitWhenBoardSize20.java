package edu.westga.cs6910.mancala.test.advancedStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.mancala.model.strategies.AdvancedStrategy;

/**
 * Tests to confirm the correct functionality of the advancedStrategy class.
 *
 * @author Alyssa Harris
 * @version Jul 7, 2022
 */
public class AdvancedStrategyTestSelectPitWhenBoardSize20 {

	private AdvancedStrategy theStrategy;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.theStrategy = new AdvancedStrategy();
	}

	/**
	 * Test for the situation where only the pit closest to the store
	 * has a stone.
	 */
	@Test
	public void testShouldReturnClosestPitWhenOnlyHasOneStone() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
		assertEquals(18, this.theStrategy.selectPit(theBoard));
	}

	/**
	 * Test for the situation where only the pit closest to the store
	 * has a stone.
	 */
	@Test
	public void testShouldReturnFurthestPitWhenItWillResultInAnotherTurn() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 1, 1, 1, 5, 9, 0, 0, 0, 0, 0, 0, 0, 8, 0};
		assertEquals(10, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where the pit closest to the store
	 * has a stone and other pits are also oppotune for another turn.
	 */
	@Test
	public void testShouldReturnClosestPitWhenOtherPitsAllowForAnotherTurn() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 1, 1, 1, 5, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		assertEquals(18, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where the pit closest to the store
	 * has no stone and the second closest pit has stones to offer
	 * another turn.
	 */
	@Test
	public void testShouldReturnSecondClosestPitWith2StonesWhenFirstPitEmpty() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 1, 1, 1, 5, 9, 8, 7, 6, 5, 4, 3, 2, 0, 0};
		assertEquals(17, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where only one pit contains stones.
	 */
	@Test
	public void testShouldReturnNonEmptyPitWhenOtherPitsEmpty() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 1, 1, 1, 5, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0};
		assertEquals(11, this.theStrategy.selectPit(theBoard));
	}

	/***
	 * Test for the situation where the each pit has the same amount of stones.
	 */
	@Test
	public void testShouldReturnFifthPitWhenAllPitsHave5Stones() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 1, 1, 1, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0};
		assertEquals(14, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where no pit has an opportune amount of stones.
	 */
	@Test
	public void testShouldReturnFirstPitWhenNoPitsReturnAnotherTurnOrCapture() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 1, 1, 1, 5, 3, 1, 1, 3, 1, 1, 13, 12, 11, 0};
		assertEquals(18, this.theStrategy.selectPit(theBoard));
	}
	
}
