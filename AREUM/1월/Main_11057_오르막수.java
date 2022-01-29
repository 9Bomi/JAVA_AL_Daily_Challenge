package com.baek.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11057_오르막수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] dp = new int[N+1][10];
		
		Arrays.fill(dp[1], 1);
		
		for (int i = 2; i <= N; i++) {
			for (int j=0; j < 10; j++) {
				for (int k=j; k<10; k++) {
					dp[i][k] = (dp[i][k] + dp[i-1][j]) % 10007;
				}
			}
		}
		
		int res =0;
		
		for(int i=0; i<10; i++) {
			res = (dp[N][i] + res) % 10007;
		}
		
		System.out.println(res);
		
		sc.close();
	}

}
