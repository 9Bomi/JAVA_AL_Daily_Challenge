package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 단계별 -분할정복
public class Main_1780_종이의개수 {

	static int paper[][];
	static int cntOne=0;
	static int cntMOne=0;
	static int cntZero=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
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
		
		cut(N, 0, 0);
		System.out.println(cntMOne);
		System.out.println(cntZero);
		System.out.println(cntOne);
		
	}
	
	public static void cut(int N, int row, int col) {
		if(N==1) {
			if(paper[row][col]==0) cntZero++;
			else if(paper[row][col]==-1) cntMOne++;
			else cntOne++;
			return;
		}
		
		if(check(N,row,col)) {
			if(paper[row][col]==0) cntZero++;
			else if(paper[row][col]==-1) cntMOne++;
			else cntOne++;		
			return;
		}
		
		for(int i=0; i<3; i++) {
			cut(N/3, row, col+i*N/3);
			cut(N/3, row+N/3, col+i*N/3);
			cut(N/3, row+N/3*2, col+i*N/3);
		}
		
	}
	
	public static boolean check(int N, int row, int col) {
		int temp = paper[row][col];
		
		for(int i=row; i<row+N; i++) {
			for(int j=col; j<col+N; j++) {
				if(paper[i][j]!=temp) return false;
			}
		}
		return true;
	}
	

}
