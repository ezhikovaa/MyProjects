package com.malenkiygeniy.game;

import java.util.Random;

public class State {

	public int[][] matrix = new int[4][4];
	private int[] forAdding = new int[] { 2, 2, 2, 2, 4, 4 };
	private Random random = new Random();
	public int score = 0;

	public void init() {
		add();
		add();
	}

	public boolean equals(Object obj) {
		int[][] mat = (int[][]) obj;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != mat[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	void add() {
		boolean flag = false;
		while (!flag) {
			int i = random.nextInt(4);
			int j = random.nextInt(4);
			if (matrix[i][j] == 0) {
				matrix[i][j] = forAdding[random.nextInt(forAdding.length)];
				flag = true;
			}
		}
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				str += matrix[i][j] + " ";
			}
			str += "\n";
		}

		return str;
	}

	public int[] collapse(int[] current) {
		int[] data = new int[current.length];
		int c = 0;
		int lastValue = 0;
		for (int i = 0; i < data.length; i++) {
			if (current[i] != 0) {
				if (current[i] == lastValue) {
					score += data[c - 1] = current[i] * 2;
					lastValue = 0;
				} else {
					data[c++] = current[i];
					lastValue = current[i];
				}
			}
		}
		return data;
	}

	public void set(int[][] newMatrix) {
		matrix = newMatrix;
	}

	int[][] flip(int[][] matrix) {
		int[][] newData = new int[4][4];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < matrix.length; j++) {
				newData[j][i] = matrix[j][3 - i];
				newData[j][3 - i] = matrix[j][i];
			}
		}
		return newData;
	}

	public int[][] rotateLeft(int[][] data) {
		int[][] newData = new int[data.length][data.length];
		int m = data.length;
		for (int i = 0; i < m / 2; i++) {
			for (int j = i; j < m - 1 - i; j++) {
				newData[i][j] = data[j][m - 1 - i];
				newData[j][m - 1 - i] = data[m - 1 - i][m - 1 - j];
				newData[m - 1 - i][m - 1 - j] = data[m - 1 - j][i];
				newData[m - 1 - j][i] = data[i][j];
			}
		}
		return newData;
	}

	public int[][] rotateRight(int[][] data) {
		int[][] newData = new int[data.length][data.length];
		int m = data.length;
		for (int i = 0; i < m / 2; i++) {
			for (int j = i; j < m - 1 - i; j++) {
				newData[j][m - 1 - i] = data[i][j];
				newData[m - 1 - i][m - 1 - j] = data[j][m - 1 - i];
				newData[m - 1 - j][i] = data[m - 1 - i][m - 1 - j];
				newData[i][j] = data[m - 1 - j][i];
			}
		}
		return newData;
	}

	public void right() {
		int[][] newData = flip(matrix);
		for (int i = 0; i < newData.length; i++) {
			newData[i] = collapse(newData[i]);
		}
		matrix = flip(newData);
	}

	public void left() {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = collapse(matrix[i]);
		}
	}

	public void down() {
		int[][] newData = rotateRight(matrix);
		for (int i = 0; i < newData.length; i++) {
			newData[i] = collapse(newData[i]);
		}
		matrix = rotateLeft(newData);
	}

	public void up() {
		int[][] newData = rotateLeft(matrix);
		for (int i = 0; i < newData.length; i++) {
			newData[i] = collapse(newData[i]);
		}
		matrix = rotateRight(newData);
	}

	public boolean canAdd() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
}
