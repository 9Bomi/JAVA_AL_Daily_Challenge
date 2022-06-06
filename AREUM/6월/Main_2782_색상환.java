package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2782_색상환 {
	static final int MOD = 1000000003;
	static int N, K;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());
		
		dp = new int[N + 1][N + 1];
		
		System.out.println(find(N, K));
		
		in.close();
	}

	public static int find(int n, int k) {
		if (dp[n][k] != 0) {
			return dp[n][k];
		}
		
		if (k == 1) {
			return n;
		}
		
		if (n / 2 < k) {
			return 0;
		}
		
		return dp[n][k] = (find(n - 2, k - 1) + find(n - 1, k)) % MOD;
	}
}
