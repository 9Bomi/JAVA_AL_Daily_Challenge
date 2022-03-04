package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2718_타일채우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			
			int[] dp = new int[N + 1];
			
			dp[0] = 1;
			dp[1] = 1;
			
			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i-2] * 4 + dp[i-1];
				
				for (int j = 3; j <= i; j += 2) {
					dp[i] += dp[i - j] * 2;
				}
				
				for (int j = 4; j <= i; j += 2) {
					dp[i] += dp[i - j] * 3;
				}
			}
			
			System.out.println(dp[N]);
		}
		
		in.close();
	}

}
