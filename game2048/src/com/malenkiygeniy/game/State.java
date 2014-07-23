package com.malenkiygeniy.game;

import java.util.Random;

public class State {

	public int[][] matrix=new int[4][4];
	private int[] forAdding = new int[]{2,2,2,2,4,4};
	private Random random = new Random();
	
	
	public boolean equals(Object obj){
		int[][] mat=(int[][])obj;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j]!=mat[i][j]){
					return false;
				}
			}
		}
		return true;
	}


	public void add() {
		boolean flag=false;
		while(!flag){
			int i = random.nextInt(4);
			int j = random.nextInt(4);
			if(matrix[i][j]==0){
				matrix[i][j]=forAdding[random.nextInt(forAdding.length)];
				flag=true;
			}
		}
	}
	public String toString(){
		String str="";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				 str+=matrix[i][j]+" ";
			}
			str+="\n";
		}
		
		return str;
	}
}
