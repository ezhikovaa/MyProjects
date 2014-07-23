package com.malenkiygeniy.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateTest {

	@Test
	public void test() {
		State state = new State();
		assertTrue(state.matrix!=null);
		int[][] waiting = new int[][]{
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
		};
		assertTrue(state.equals(waiting));
		state.add();
		assertFalse(state.equals(waiting));
		state.add();
		state.add();
		System.out.println(state.toString());
		
	}

}
