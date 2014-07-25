package com.malenkiygeniy.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaPlatform implements Platform {

	private JFrame _frame;
	private PlatformKeyListener _listener;
	private JPanel _panel;
	private HashMap<Integer, Color> colors = new HashMap<>();

	public JavaPlatform() {
		colors.put(0, new Color(224,224,224));
		colors.put(1, Color.black);
		colors.put(2, new Color(255,255,204));
		colors.put(3, new Color(128,128,128));
		colors.put(4, new Color(255,204,153));
		colors.put(8, new Color(255,178,102));
		colors.put(16, new Color(204,102,0));
		colors.put(32, new Color(204,102,0));
		colors.put(64, new Color(255,51,51));
		colors.put(128, new Color(255,255,204));
		colors.put(256, new Color(255,204,153));
		colors.put(512, new Color(255,178,102));
	}

	public void init(JFrame frame, PlatformKeyListener listener) {
		_frame = frame;
		_listener = listener;
		_panel = new JPanel();
		Dimension d = new Dimension(660, 860);
		_panel.setPreferredSize(d);
		_panel.setMaximumSize(d);
		_panel.setMinimumSize(d);
		_frame.add(_panel);
		_frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					_listener.left();
					break;
				case KeyEvent.VK_RIGHT:
					_listener.right();
					break;
				case KeyEvent.VK_UP:
					_listener.up();
					break;
				case KeyEvent.VK_DOWN:
					_listener.down();
					break;
				}
			}
		});
	}

	@Override
	public void clearArea() {
		Graphics2D g = (Graphics2D) _frame.getGraphics();
		g.clearRect(0, 0, _panel.getWidth(), _panel.getHeight());
	}

	@Override
	public int backgroundColorIndex() {
		return 0;
	}

	@Override
	public void fillRect(int backgroundColorIndex, int x, int y, int width,
			int height) {
		Graphics2D g = (Graphics2D) _frame.getGraphics();
		g.setColor(colors.get(backgroundColorIndex));
		g.fillRect(x, y, width, height);
	}

	@Override
	public int getWidth() {
		return _panel.getWidth();
	}

	@Override
	public int getHeight() {
		return _panel.getHeight();
	}

	@Override
	public void setKeyListener(PlatformKeyListener listener) {
		_listener = listener;
	}

	@Override
	public void drawString(int fontSize, int x, int y, int text) {
		Graphics2D g = (Graphics2D) _frame.getGraphics();
		Font font = new Font("TimesRoman", Font.BOLD, fontSize);
		g.setFont(font);
		g.drawString(""+text, x, y);
	}

}
