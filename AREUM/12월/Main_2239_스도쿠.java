package com.baek.algo;

import java.util.Scanner;

public class Main_2239_스도쿠 {
	
	static int board[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		board = new int[9][9];
		
		for(int i=0; i<9; i++) {
			String temp = sc.nextLine();
			for(int j=0; j<9; j++) {
				board[i][j] = temp.charAt(j)-'0';
			}
		}
		
		dfs(0,0);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		sc.close();
	}
	
	
	public static boolean dfs(int r, int c) {
		if(r==9) return true;
		
		
		if(board[r][c]!=0) {
			if(c==8) {
				if(dfs(r+1,0)) return true;
			}
			else {
				if(dfs(r,c+1)) return true;
			}
			return false;
		}
		
		boolean avail[] = check(r,c);
		
		for(int i=1; i<=9; i++) {
			if(!avail[i]) {
				board[r][c] = i;
				if(c==8) {
					if(dfs(r+1,0)) return true;
				}
				else {
					if(dfs(r,c+1)) return true;
				}
				board[r][c]=0;
			}
		}
		
		return false;
	}
	
	public static boolean[] check(int r, int c) { 
		boolean available[] = new boolean[10];
		
		for(int i=0; i<9; i++) {
			available[board[r][i]] = true;
			available[board[i][c]] = true;
		}
		
		r/=3;
		c/=3;
		
		for(int i=r*3; i<r*3+3; i++) {
			for(int j=c*3; j<c*3+3; j++) {
				available[board[i][j]] =true;
			}
		}
		
		return available;
	}
}
