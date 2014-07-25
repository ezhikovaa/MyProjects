package com.malenkiygeniy.game;

import java.util.LinkedList;
import java.util.List;

public class Model implements EventProcessor {
	private State _state;
	private Logic _logic;
	private List<ModelListener> _listeners;

	public Model() {
		_state = new State();
		_logic = new Logic(_state);
		_listeners = new LinkedList<ModelListener>();
	}

	@Override
	public void left() {
		_logic.left();
		updateState(_state);
	}

	@Override
	public void right() {
		_logic.right();
		updateState(_state);
	}

	@Override
	public void down() {
		_logic.down();
		updateState(_state);
	}

	@Override
	public void up() {
		_logic.up();
		updateState(_state);
	}

	@Override
	public void newGame() {
		_logic.newGame();
		updateState(_state);
	}

	private void updateState(State state) {
		for (ModelListener listener : _listeners) {
			listener.updateState(state);
		}
	}

	public void addListener(ModelListener listener) {
		_listeners.add(listener);
	}
}
