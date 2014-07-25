package com.malenkiygeniy.game;

public class Logic implements EventProcessor {
	private State _state;

	public Logic(State state) {
		_state = state;
	}

	@Override
	public void left() {
		int[][] oldData=_state.matrix;
		_state.left();
		isGameFinished(oldData);
	}

	@Override
	public void right() {
		int[][] oldData=_state.matrix;
		_state.right();
		isGameFinished(oldData);
	}

	@Override
	public void down() {
		int[][] oldData=_state.matrix;
		_state.down();
		isGameFinished(oldData);
	}

	@Override
	public void up() {
		int[][] oldData=_state.matrix;
		_state.up();
		isGameFinished(oldData);
	}

	private void isGameFinished(int[][] oldData) {
		if(_state.canAdd(oldData)){
			_state.add();
		} else{
			System.out.println("Game has finished");
		}
	}

	@Override
	public void newGame() {
		_state.init();
	}

}
