package com.malenkiygeniy.game;

public class View {

	private Platform _platform;
	private int bigSize = 0;
	private int smallSize = 0;
	private int fontSize = 12;

	public View(Platform platform) {
		_platform = platform;
	}

	public void updateState(State state) {
		calculate();
		_platform.clearArea();
		showState(state);
	}

	private void showState(State state) {
		System.out.println(state.toString());
		_platform.fillRect(3, bigSize - smallSize, bigSize - smallSize, bigSize
				* 4 + smallSize * 5, bigSize * 4 + smallSize * 5);
		int y = bigSize;
		int x = 0;
		for (int i = 0; i < state.matrix.length; i++) {
			x = bigSize;
			for (int j = 0; j < state.matrix[i].length; j++) {
				_platform.fillRect(state.matrix[i][j], x, y, bigSize, bigSize);
				drawText(state.matrix[i][j], x, y);

				x += bigSize + smallSize;
			}
			y += bigSize + smallSize;
		}

		x = bigSize;
		y = bigSize * 6 + smallSize * 3;
		_platform.fillRect(1, x, y, bigSize * 3, bigSize);

	}

	private void drawText(int i, int x, int y) {
		int xFont = x;
		int yFont = y;
		if (i != 0) {
			xFont += (bigSize - fontWight(i)) / 2;
			yFont += (bigSize - fontSize) / 2 + fontSize;
			_platform.drawString(fontSize, xFont, yFont, i);
		}

	}

	private int fontWight(int i) {
		if (i < 10) {
			return (int) (fontSize * .6);
		} else if (i < 100) {
			return (int) ((fontSize * .6 * 2) + (fontSize * .2));
		} else if (i < 1000) {
			return (int) ((fontSize * .6 * 3) + (fontSize * .2 * 2));
		} else {
			return (int) ((fontSize * .6 * 4) + (fontSize * .2 * 3));
		}

	}

	private void calculate() {
		if (_platform.getHeight() > _platform.getWidth()) {
			smallSize = _platform.getWidth() / 33;
		} else {
			smallSize = _platform.getHeight() / 33;
		}
		bigSize = smallSize * 5;
		fontSize = bigSize / 3;
	}

}
