package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2629_양팔저울 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		int choo[] = new int[N+1];

		for(int i=1; i<=N; i++) {
			
			choo[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int M = Integer.parseInt(in.readLine());
		
		boolean dp[][] = new boolean[N+1][40001];
		
		for(int i=1; i<=N; i++) {
			dp[i][choo[i]]= true;
			for(int j=0; j<40001; j++) {
				if(dp[i-1][j]) {
					dp[i][j] = true;
					dp[i][Math.abs(choo[i]-j)] = true;
					dp[i][choo[i]+j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<M; i++) {

			int weight = Integer.parseInt(st.nextToken());
			
			if(dp[N][weight]) sb.append("Y ");
			else sb.append("N ");
		}
		
		System.out.println(sb);
		
		in.close();
	}
}
