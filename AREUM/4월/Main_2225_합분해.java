package com.baek.algo;

import java.util.Scanner;

public class Main_2225_합분해 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] dp = new int[K + 1][N + 1];
		final int MOD = 1000000000;
		
		for (int i = 0;  i <= N; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				for (int l = 0; l <= j; l++) {
					dp[i][j] = (dp[i][j] + dp[i-1][j-l]) % MOD;
				}
			}
		}
		
		System.out.println(dp[K][N]);
		
		sc.close();
	}
}
