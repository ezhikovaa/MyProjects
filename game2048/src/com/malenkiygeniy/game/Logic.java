package com.malenkiygeniy.game;

public class Logic implements EventProcessor {
	private State _state;

	public Logic(State state) {
		_state = state;
	}

	@Override
	public void left() {
		_state.left();
		isGameFinished();
	}

	@Override
	public void right() {
		_state.right();
		isGameFinished();
	}

	@Override
	public void down() {
		_state.down();
		isGameFinished();
	}

	@Override
	public void up() {
		_state.up();
		isGameFinished();
	}

	private void isGameFinished() {
		if(_state.canAdd()){
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
