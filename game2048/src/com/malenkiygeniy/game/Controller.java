package com.malenkiygeniy.game;

public class Controller implements PlatformKeyListener, ModelListener,EventProcessor{

	private View _view;
	private Model _model;
	private Platform _platform;

	public Controller(Model model, Platform platform, View view) {
		_model = model;
		_platform = platform;
		_platform.setKeyListener(this);
		_view = view;
	}
	@Override
	public void newGame() {
		_model.newGame();
	}

	@Override
	public void updateState(State state) {
		_view.updateState(state);
	}

	@Override
	public void up() {
		_model.up();
	}

	@Override
	public void down() {
		_model.down();
	}

	@Override
	public void left() {
		_model.left();
	}

	@Override
	public void right() {
		_model.right();
	}

}
