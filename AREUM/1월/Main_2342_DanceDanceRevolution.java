package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2342_DanceDanceRevolution {
	static int N, dirs[], dp[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = st.countTokens();
		
		dirs = new int[N];
		dp = new int[5][5][N];
		
		for(int i=1; i<N; i++) {
			int dir = Integer.parseInt(st.nextToken());
			
			dirs[i] = dir;
		}
			
		System.out.println(press(0,0,1));
		
		in.close();
	}
	
	static int press(int left, int right, int n) {
		if(n==N) return 0;
		if(dp[left][right][n]!=0) return dp[left][right][n];
		
		return dp[left][right][n] = Math.min(getPower(left, dirs[n])+press(dirs[n], right, n+1), 
											 getPower(right, dirs[n])+press(left, dirs[n], n+1));
	}
	
	static int getPower(int past, int next) {
		if(past==next) return 1;
		else if(past==0) return 2;
		else if(past-next==2 || past-next==-2) return 4;
		return 3;
	}
}
