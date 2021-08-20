package com.baek.algo;

import java.util.Scanner;

public class Main_9663_NQueen {
	static int N;
	static int cols[];
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		cnt=0;
		cols = new int[N]; // 각 행마다 열값
		
		put(0);
		
		System.out.println(cnt);
	}
	
	public static void put(int row) {
		if(row==N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			cols[row]=i;
			if(check(row, i)) {
				put(row+1);
			
			}
		}
	}

	public static boolean check(int row, int col) {
		for(int i=0; i<row; i++) {
			if(cols[i]==cols[row] || Math.abs(row-i)==Math.abs(cols[row]-cols[i])) return false;
		}
		return true;
	}

}
