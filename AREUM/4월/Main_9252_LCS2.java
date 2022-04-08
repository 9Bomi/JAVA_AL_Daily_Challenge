package com.baek.algo;

import java.util.Scanner;

public class Main_9252_LCS2 {
	static int N, M;
	static int[][] dp;
	static char[] str1, str2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		str1 = sc.nextLine().toCharArray();
		str2 = sc.nextLine().toCharArray();
		
		N = str1.length;
		M = str2.length;
		
		dp = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		System.out.println(dp[N][M]);
		
		if (dp[N][M] != 0) {
			System.out.println(find(N, M));
		}
		
		sc.close();
	}
	
	static StringBuilder find(int n, int m) {
		if (n == 0 || m == 0) {
			return new StringBuilder("");
		}
		
		if (str1[n - 1] == str2[m - 1]) {
			return find(n -1, m-1).append(str1[n - 1]);
		} else {
			if (dp[n][m] == dp[n - 1][m]) {
				return find(n - 1, m);
			} else {
				return find(n, m - 1);
			}
		}
	}
}
