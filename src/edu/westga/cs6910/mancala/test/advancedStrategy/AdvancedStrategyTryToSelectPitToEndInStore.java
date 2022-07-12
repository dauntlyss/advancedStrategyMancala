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
public class AdvancedStrategyTryToSelectPitToEndInStore {

	private AdvancedStrategy theStrategy;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.theStrategy = new AdvancedStrategy();
	}
	
	/***
	 * Test for the situation where only the pit closest to the store
	 * has a stone.
	 */
	@Test
	public void testShouldReturnClosestPit() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 1, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where the pit closest to the store
	 * has a stone and the second closest pit also has stones.
	 */
	@Test
	public void testShouldReturnClosestPitWhenPitOnlyHasOneStone() {
		int[] theBoard = {0, 0, 0, 0, 0, 2, 1, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where the pit closest to the store
	 * has a stone and the second closest pit also has stones.
	 */
	@Test
	public void testShouldReturnSecondClosestPitWith2StonesWhenFirstPitEmpty() {
		int[] theBoard = {0, 0, 0, 0, 0, 2, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where the pit closest to the store
	 * has a stone and the second closest pit also has stones.
	 */
	@Test
	public void testShouldReturnThirdPitWith2StonesWhenOtherPitsEmpty() {
		int[] theBoard = {0, 0, 0, 0, 2, 0, 0, 0};
		assertEquals(4, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where the each pit has the same amount of stones.
	 */
	@Test
	public void testShouldReturnSecondPitWhenAllPitsHave2Stones() {
		int[] theBoard = {0, 0, 0, 0, 2, 2, 2, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where the each pit has an opportune amount of stones.
	 */
	@Test
	public void testShouldReturnFirstPitWhenAllPitsReturnAnotherTurn() {
		int[] theBoard = {0, 0, 0, 0, 3, 2, 1, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/***
	 * Test for the situation where no pit has an opportune amount of stones.
	 */
	@Test
	public void testShouldReturnFirstPitWhenNoPitsReturnAnotherTurn() {
		int[] theBoard = {0, 0, 0, 0, 4, 7, 2, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}

}
