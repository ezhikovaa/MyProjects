package com.malenkiygeniy.game;

public class Sample {
	public static void main(String[] args) {
		int[][] matrix=new int[4][4];
		int c=0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j]=c++;
			}
			
		}
		int[] part=new int[]{0,0,0,0};
		matrix[2]=part;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		

		
	}
}
