package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 단계별 -분할정복
public class Main_2630_색종이만들기 {
	static int paper[][];
	static int blue=0;
	static int white=0;
	static final int BLUE=1;
	static final int WHITE=0;

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		
		paper = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(N,0,0);
		
		System.out.println(white);
		System.out.println(blue);

	}

	public static void cut(int N, int row, int col) {
		if(N==1) {
			if(paper[row][col]==BLUE) blue++;
			else white++;
			return;			
		}
		
		if(check(N, row, col)) {
			if(paper[row][col]==BLUE) blue++;
			else white++;
			return;
		}
		
		cut(N/2, row, col);			
		cut(N/2, row, col+N/2);
		cut(N/2, row+N/2, col);
		cut(N/2, row+N/2, col+N/2);
		
	}
	
	public static boolean check(int N, int row, int col) {
		int temp = paper[row][col];
		
		for(int i=row; i<row+N; i++) {
			for(int j=col; j<col+N; j++) {
				if(paper[i][j] != temp) return false;
			}
		}
		return true;
	}
}
