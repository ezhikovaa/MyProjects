package com.malenkiygeniy.game;

public interface Platform {

	void clearArea();

	int backgroundColorIndex();

	void fillRect(int backgroundColorIndex, int x, int y,
			int width, int height);

	int getWidth();

	int getHeight();

	void setKeyListener(PlatformKeyListener listener);

	void drawString(int fontSize, int x, int y, int matrix);

	

}
