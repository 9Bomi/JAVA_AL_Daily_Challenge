package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1699_제곱수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
		}

		for (int i = 1;  i <= N; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i - (j * j)] + 1, dp[i]);
			}
		}
		
		System.out.println(dp[N]);
				
		in.close();
	}
}
