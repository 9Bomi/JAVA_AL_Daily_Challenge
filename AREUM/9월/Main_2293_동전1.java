package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_동전1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int coins[] = new int[N];
		int dp[] = new int[K+1];
		
		dp[0] = 1;
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(in.readLine());
			
			for(int j=coins[i]; j<=K; j++) {
				dp[j] += dp[j-coins[i]]; 
			}
		}
		
		System.out.println(dp[K]);
	}
}
