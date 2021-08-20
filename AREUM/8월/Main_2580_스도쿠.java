package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준 단계별 -백트래킹
public class Main_2580_스도쿠 {
	static int pan[][];
	static ArrayList<Blank> list;
	static boolean isSolved = false;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		pan = new int[9][9];
		list = new ArrayList<Blank>();
		
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<9; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if(pan[i][j]==0) list.add(new Blank(i, j));
			}
		}
		
		solve(0);
		
		
	}
	
	public static void solve(int cnt) {
		if(cnt==list.size()) {
			isSolved=true;
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(pan[i][j]+" ");
				}
				System.out.println();
			}
			return;
		}
		
		if(isSolved) {
			return;
		}
		
		for(int i=1; i<=9; i++) {
			if(check(i, list.get(cnt).row, list.get(cnt).col)) {
				pan[list.get(cnt).row][list.get(cnt).col]=i;
				solve(cnt+1);
				pan[list.get(cnt).row][list.get(cnt).col]=0;
			}
		}
	}
	

	//숫자 중복 검사
	public static boolean check(int value, int row, int col) {
		for(int i=0; i<9; i++) {
			if(pan[row][i] == value) return false;
			if(pan[i][col] == value) return false;
		}		
		
		int tempR=row-row%3;
		int tempC=col-col%3;
		for(int i=tempR; i<tempR+3; i++) {
			for(int j=tempC; j<tempC+3; j++) {
				if(pan[i][j] == value) return false;
			}
		}
		return true;
	}

	public static class Blank{
		int row;
		int col;
		
		public Blank(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
	}

}
