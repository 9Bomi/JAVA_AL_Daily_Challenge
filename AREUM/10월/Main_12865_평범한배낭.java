package com.baek.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long dp[][] = new long[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<W && j<=K; j++) {
				dp[i][j] = dp[i-1][j];
			}
			for(int j=W; j<=K; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W]+V);
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
