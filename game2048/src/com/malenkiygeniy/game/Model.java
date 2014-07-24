package com.malenkiygeniy.game;

import java.util.LinkedList;
import java.util.List;

public class Model implements EventProcessor {
	private State _state;
	private Logic _logic;
	private List<ModelListener> _listeners;

	public Model(State state, Logic logic) {
		_state = state;
		_logic = logic;
		_listeners = new LinkedList<ModelListener>();
	}

	@Override
	public void left() {
		_logic.left();

	}

	@Override
	public void right() {
		// TODO Auto-generated method stub

	}

	@Override
	public void down() {
		// TODO Auto-generated method stub

	}

	@Override
	public void up() {
		// TODO Auto-generated method stub

	}

	@Override
	public void newGame() {
		// TODO Auto-generated method stub

	}

	public void setListener(ModelListener listener) {
		_listeners.add(listener);
	}
}
