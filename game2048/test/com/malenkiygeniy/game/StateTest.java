package com.malenkiygeniy.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateTest {

	@Test
	public void test() {
		State state = new State();
		assertTrue(state.matrix != null);
		int[][] waiting = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
				{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, };

		assertTrue(state.equals(waiting));
		System.out.println(state.toString());
		int[] current = new int[] { 0, 2, 0, 4 };
		int[] afterCollapse= state.collapse(current);;

	}

	@Test
	public void testCollapse() throws Exception {
		State state = new State();
		int[] current = new int[] { 4, 4, 4, 2 };
		int[] afterCollapse = new int[] { 8, 4, 2, 0 };
		current = state.collapse(current);
		assertTrue(this.isEquals(current, afterCollapse));
	}
	@Test
	public void testLeftCollaps() throws Exception {
		State state = new State();
		state.set(new int[][]{
				{2,2,0,4},
				{4,2,4,2},
				{0,0,0,4},
				{4,0,4,0},
		});
		state.left();
		assertTrue(state.equals(new int[][]{
				{4,4,0,0},
				{4,2,4,2},
				{4,0,0,0},
				{8,0,0,0},
		}));
	}
	@Test
	public void testCanAdd() throws Exception {
		State state = new State();
		state.set(new int[][]{
				{2,2,3,4},
				{4,2,4,2},
				{1,1,10,4},
				{4,1,2,2},
		});
		assertFalse(state.canAdd());
	}
	@Test
	public void testRightCollaps() throws Exception {
		State state = new State();
		state.set(new int[][]{
				{2,2,0,4},
				{4,2,4,2},
				{0,0,0,4},
				{4,0,4,0},
		});
		state.right();
		assertTrue(state.equals(new int[][]{
				{0,0,4,4},
				{4,2,4,2},
				{0,0,0,4},
				{0,0,0,8},
		}));
	}
	@Test
	public void testUpCollaps() throws Exception {
		State state = new State();
		state.set(new int[][]{
				{2,2,0,4},
				{4,2,4,2},
				{0,0,0,4},
				{4,0,4,0},
		});
		state.up();
		assertTrue(state.equals(new int[][]{
				{2,4,8,4},
				{8,0,0,2},
				{0,0,0,4},
				{0,0,0,0},
		}));
	}
	@Test
	public void testDownCollaps() throws Exception {
		State state = new State();
		state.set(new int[][]{
				{2,2,0,4},
				{4,2,4,2},
				{0,0,0,4},
				{4,0,4,0},
		});
		state.down();
		assertTrue(state.equals(new int[][]{
				{0,0,0,0},
				{0,0,0,4},
				{2,0,0,2},
				{8,4,8,4},
		}));
	}
	
	@Test
	public void testFlip() throws Exception {
		State state = new State();
		state.set(new int[][]{
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
		});
		int[][] newData=state.flip(state.matrix);
		int[][] result=new int[][]{
				{4,3,2,1},
				{4,3,2,1},
				{4,3,2,1},
				{4,3,2,1},
		};
		assertTrue(isEquals(newData, result));
	}
	@Test
	public void testRotateLeft() throws Exception {
		State state = new State();
		state.set(new int[][]{
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
		});
		int[][] newData=state.rotateLeft(state.matrix);
		int[][] result=new int[][]{
				{4,4,4,4},
				{3,3,3,3},
				{2,2,2,2},
				{1,1,1,1},
		};
		assertTrue(isEquals(newData, result));
	}
	
	@Test
	public void testRotateRight() throws Exception {
		State state = new State();
		state.set(new int[][]{
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
		});
		int[][] newData=state.rotateRight(state.matrix);
		int[][] result=new int[][]{
				{1,1,1,1},
				{2,2,2,2},
				{3,3,3,3},
				{4,4,4,4},
		};
		assertTrue(isEquals(newData, result));
	}
	@Test
	public void testScore() throws Exception {
		State state = new State();
		state.set(new int[][]{
				{2,0,4,0},
				{2,0,4,0},
				{0,0,0,0},
				{0,0,0,0},
		});
		state.up();
		assertEquals(12, state.score);
	}
	
	
	private boolean isEquals(int[][] newData, int[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				if(newData[i][j]!=result[i][j]){
					return false;
				}
			}
		}
		return true;
	}

	private boolean isEquals(int[] current, int[] afterCollapse) {
		for (int i = 0; i < afterCollapse.length; i++) {
			if (afterCollapse[i] != current[i]) {
				return false;
			}
		}
		return true;
	}
}
