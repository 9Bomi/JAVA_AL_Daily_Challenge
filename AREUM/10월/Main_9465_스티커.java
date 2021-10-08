package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(in.readLine());
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			StringTokenizer st2 = new StringTokenizer(in.readLine());
			
			int dp[][] = new int[3][N];
			
			dp[0][0] = Integer.parseInt(st.nextToken());
			dp[1][0] = Integer.parseInt(st2.nextToken());
			dp[2][0] = 0;
			
			for(int i=1; i<N; i++) {
				dp[0][i] = Math.max(dp[2][i-1], dp[1][i-1]) + Integer.parseInt(st.nextToken());
				dp[1][i] = Math.max(dp[2][i-1], dp[0][i-1]) + Integer.parseInt(st2.nextToken());
				dp[2][i] = Math.max(Math.max(dp[1][i-1], dp[0][i-1]), dp[2][i-1]);
			}
			
			sb.append(Math.max(Math.max(dp[1][N-1], dp[0][N-1]), dp[2][N-1])+"\n");
		}
		
		System.out.println(sb);
		
		in.close();
	}

}
