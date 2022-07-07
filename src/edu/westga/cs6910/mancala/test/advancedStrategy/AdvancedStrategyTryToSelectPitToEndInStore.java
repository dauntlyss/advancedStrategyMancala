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

}
