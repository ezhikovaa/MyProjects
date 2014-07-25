package com.malenkiygeniy.game;

import javax.swing.JFrame;

public class PlayGame {
public static void main(String[] args) {
	JFrame frame = new JFrame("2048");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JavaPlatform platform = new JavaPlatform();
	View view = new View(platform);
	Model model = new Model();
	Controller controller = new Controller(model, platform, view);
	platform.init(frame, controller);
	frame.pack();
	frame.setVisible(true);
	model.addListener(controller);
	controller.newGame();
}
}
